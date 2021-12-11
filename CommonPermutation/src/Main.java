import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan =
                new BufferedReader(new InputStreamReader(System.in));
        String a, b;
        while ((a = scan.readLine()) != null) {
            b = scan.readLine();
            int[] s1 = new int[26];
            int[] s2 = new int[26];

            char[] c1 = a.toCharArray();
            char[] c2 = b.toCharArray();

            int l1 = c1.length;
            int l2 = c2.length;

            if (l1 > l2) {
                for (int i = 0; i < l1; i++) {
                    s1[c1[i] - 'a']++;

                    if (i < l2) {
                        s2[c2[i] - 'a']++;
                    }

                }
            } else {
                for (int i = 0; i < l2; i++) {
                    s2[c2[i] - 'a']++;

                    if (i < l1) {
                        s1[c1[i] - 'a']++;
                    }
                }
            }

            StringBuilder res = new StringBuilder();


            int m;
            for (int i = 0; i < 26; i++) {
                m = Math.min(s1[i], s2[i]);
                res.append(String.valueOf((char) ('a' + i)).repeat(Math.max(0, m)));
            }

            System.out.println(res);
        }
    }

}