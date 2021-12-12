import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan =
                new BufferedReader(new InputStreamReader(System.in));

        //get first line
        int cases = Integer.parseInt(scan.readLine());
        int numJobs;

        for (int i = 0; i < cases; i++) {
            //skip starting blank line
            scan.readLine();

            //Get data
            numJobs = Integer.parseInt(scan.readLine());
            List<List<Double>> jobs = new ArrayList<>();

            for (int j = 0; j < numJobs; j++) {
                List<Double> a =
                        Arrays.stream((scan.readLine()).split(" ")).map(Double::parseDouble).collect(Collectors.toList());

                a.add((double) j + 1);
                jobs.add(a);
            }

            jobs =
                    jobs.stream().sorted(Comparator.comparingDouble(x -> - (x.get(1) / x.get(0)))).sorted((x, y) -> {
                        double a = x.get(1), b = x.get(0), c = y.get(1), d = y.get(0);
                        return Double.compare(c*(b + d) + a*b, a*(b + d) + c*d ); }).collect(Collectors.toList());

            System.out.println(Arrays.toString(jobs.stream().mapToInt(x -> x.get(2).intValue()).toArray()).replaceAll("(\\[)|]|,", ""));
            System.out.println();

        }

    }


}
