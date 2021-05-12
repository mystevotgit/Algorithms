import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.sqrt;

public class SeamfixAlgorithm {

    public static List<Double> almightyFormula(Double a, Double b, Double c) {
        Double preRes1 = (b * b) - (4 * a * c);
        Double preRes2 = preRes1 / (2 * a);
        Double res1 = -b + sqrt(preRes2);
        Double res2 = -b - sqrt(preRes2);
        List<Double> result = new ArrayList<>();
        result.add(res1);
        result.add(res2);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(almightyFormula(1.0, -5.0, 6.0));
    }
}
