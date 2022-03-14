import java.util.*;
import java.util.stream.Collectors;

class Challenge {
    public static String sortCsvColumns(String csv_data) {
        System.out.println(csv_data);
        List<List<String>> table = new ArrayList<>();
        table.add(new ArrayList<>());
        List<String> list = Arrays.asList(csv_data.split(","));
        for (int i = 0; i < list.size(); i++) {
            List<String> each = Arrays.asList(list.get(i).split("\n"));
            if (each.size() == 1) {
                table.get(table.size() - 1).add(each.get(0).trim());
            } else if (each.size() == 2) {
                table.get(table.size() - 1).add(each.get(0).trim());
                table.add(new ArrayList<>());
                table.get(table.size() - 1).add(each.get(1).trim());
            }
        }
        List<String> column = table.get(0);
        SortedMap<String, List<String>> data = new TreeMap<>(new Comparator<String>() {
            public int compare(String a, String b) {
                return a.compareToIgnoreCase(b);
            }
        });

        for (int i = 0; i < column.size(); i++) {
            List<String> columnData = new ArrayList<>();
            for (int j = 1; j < table.size(); j++) {
                columnData.add(table.get(j).get(i));
            }
            data.put(column.get(i), columnData);
        }
        String result = "";
        List<String> keys = Arrays.asList(data.keySet().stream().collect(Collectors.joining(",")));
        Iterator x = keys.iterator();
        while (x.hasNext()) {
            result += x.next();
        }
        List<List<String>> val = new ArrayList<>();
        val.addAll(data.values());
        for (int i = 0; i < val.get(0).size(); i++) {
            result += "\n";
            for (int j = 0; j < val.size(); j++) {
                result += val.get(j).get(i);
                result += ",";
            }
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sortCsvColumns("Beth,Adam\n" +
                "2,1"));
        System.out.println(sortCsvColumns("Beth,Charles,Danielle,Adam,Eric\n" +
                "        17945,10091,10088,3907,10132\n" +
                "        2,12,13,48,11"));

        RoundPeg roundPeg = new RoundPeg(5);
        RoundHole roundHole = new RoundHole(5);
        System.out.println(roundHole.isFit(roundPeg));
        SquarePeg squarePeg = new SquarePeg(5);
        SquareAdapter squareAdapter = new SquareAdapter(squarePeg);
        System.out.println(roundHole.isFit(squareAdapter));
    }

    static class RoundPeg {
        private double radius;

        public RoundPeg(int radius) {
            this.radius = radius;
        }

        public Double getRadius() {
            return this.radius;
        }
    }

    static class RoundHole {
        private RoundPeg peg;
        private int radius;

        public RoundHole(int radius) {
            this.radius = radius;
        }

        public Boolean isFit(RoundPeg roundPeg) {
            if (roundPeg.getRadius() <= radius) {
                this.peg = roundPeg;
                return true;
            }
            return false;
        }
    }

    static class SquarePeg {
        private int width;

        public SquarePeg(int width) {
            this.width = width;
        }

        public int getWidth() {
            return this.width;
        }
    }

    static class SquareAdapter extends RoundPeg {
        private SquarePeg squarePeg;

        public SquareAdapter(SquarePeg squarePeg) {
            super(0);
            this.squarePeg = squarePeg;
        }

        public Double getRadius() {
            return squarePeg.width * (Math.sqrt(2) / 2);
        }
    }
}
