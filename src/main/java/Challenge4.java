class Challenge4 {
    public static boolean similarLicensePlates( String plate1,String plate2 ) {
        plate1 = plate1.replace(" ", "");
        plate2 = plate2.replace(" ", "");
        System.out.println(plate1 + "   " + plate2);
        if (plate1.length() != plate2.length()) {
            return false;
        }

        plate1 = plate1.replace("0", "O");
        plate1 = plate1.replace("Q", "O");
        plate1 = plate1.replace("1", "I");
        plate1 = plate1.replace("T", "I");
        plate1 = plate1.replace("2", "Z");
        plate1 = plate1.replace("5", "S");
        plate1 = plate1.replace("8", "B");

        plate2 = plate2.replace("0", "O");
        plate2 = plate2.replace("Q", "O");
        plate2 = plate2.replace("1", "I");
        plate2 = plate2.replace("T", "I");
        plate2 = plate2.replace("2", "Z");
        plate2 = plate2.replace("5", "S");
        plate2 = plate2.replace("8", "B");

        if (!plate1.equals(plate2)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(similarLicensePlates("ABC", "DEF" ));
        System.out.println(similarLicensePlates("123", "456"));
        System.out.println(similarLicensePlates("10", "IZO"));
        System.out.println(similarLicensePlates("BIZ", "812"));
    }
}