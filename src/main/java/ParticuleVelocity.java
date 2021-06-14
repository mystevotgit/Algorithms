import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class ParticuleVelocity {

    public static int particleVelocity(int[] particles) {
        // WRITE YOUR BRILLIANT CODE HERE
        int total_periods = 0, particles_size = particles.length;
        for (int i = 0; i < particles_size; i++) {
            for (int count = 0; i + 2 < particles_size && particles[i + 1] - particles[i] == particles[i + 2] - particles[i + 1]; i++) {
                count++;
                total_periods += count;
            }
        }
        return total_periods < 1000000000 ? total_periods : -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
        System.out.println(particleVelocity(arr));
        System.out.println(solution2("21"));
    }

    public static int solution2(String S) {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            StringBuilder sb = new StringBuilder(S);
            for (int j = 0; j < 10; j++) {
                sb.replace(i, i+1, j + "");
                String ns = sb.toString();
                int num = Integer.parseInt(ns);
                if (num % 3 != 0) {
                    continue;
                }
                values.add(num);
                j += 2;
            }
        }
        return values.size();
    }
}
