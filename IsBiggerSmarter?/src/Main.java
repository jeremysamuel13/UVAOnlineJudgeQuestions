import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair> {
    int w, p, id;

    Pair(int w, int p, int id){
        this.w = w;
        this.p = p;
        this.id = id;
    }


    @Override
    public int compareTo(Pair o) {
        return this.w - o.w;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan =
                new BufferedReader(new InputStreamReader(System.in));

        String r;
        StringTokenizer st;
        List<Pair> ps = new ArrayList<>();
        int n = 0;

        while((r = scan.readLine()) != null && !r.trim().isEmpty()){
            st = new StringTokenizer(r);
            ps.add(new Pair(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), ++n));
        }

        Collections.sort(ps);

        int[] P = new int[ps.size()], LIS = new int[ps.size()];
        Arrays.fill(LIS, 1);
        P[0] = 0;
        int l = 1, ls = 0;

        for (int i = 1; i < ps.size(); i++) {
            Pair cur = ps.get(i);
            P[i] = i;

            for (int j = 0 ; j < i ; ++j) {
                if (cur.w > ps.get(j).w && cur.p < ps.get(j).p && LIS[j] + 1 > LIS[i]) {
                    P[i] = j;
                    LIS[i] = LIS[j] + 1;
                    if (LIS[i] > l) {
                        ls = i;
                        l = LIS[i];
                    }
                }
            }
        }

        System.out.println(l);

        Stack<Integer> res = new Stack<>();
        while (P[ls] != ls) {
            res.push(ps.get(ls).id);
            ls = P[ls];
        }
        res.push(ps.get(ls).id);
        while (!res.isEmpty()) System.out.println(res.pop());
    }
}
