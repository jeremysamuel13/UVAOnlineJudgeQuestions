import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan =
                new BufferedReader(new InputStreamReader(System.in));

        //get first line
        int cases = Integer.parseInt(scan.readLine());
        int[] relatives;
        int numRelatives;
        int l, diff, mid;
        StringTokenizer inp;
        for (int i = 0; i < cases; i++) {
            inp = new StringTokenizer(scan.readLine());

            numRelatives = Integer.parseInt(inp.nextToken());
            relatives = new int[numRelatives];

            for (int j = 0; j < numRelatives; j++) {
                relatives[j] = Integer.parseInt(inp.nextToken());
            }

            //O(nlog(n))
            Arrays.sort(relatives);

            l = relatives.length;

            diff = 0;
            mid = (l & 1) == 1 ? relatives[l / 2] :
                    (relatives[l / 2] + relatives[l / 2 - 1]) / 2;

            //O(n)
            for (int j = 0; j < l; j++) {
                diff+=Math.abs(relatives[j] - mid);
            }


            System.out.println(diff);
        }

    }

}


