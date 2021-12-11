import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

class Main {

    HashMap<Integer, Integer> cache = new HashMap<>();

    static String ReadLn() { // utility function to read from stdin
        byte[] lin = new byte[255];
        int lg = 0, car = -1;

        try {
            while (lg < 255) {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin[lg++] += car;
            }
        } catch (IOException e) {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String(lin, 0, lg));
    }

    //Recursive cycle length with memoization
    public int cycleLength(int n) {
        if (n == 1) {
            return 1;
        }

        if (!cache.containsKey(n)) {
            cache.put(n,
                    (n & 1) == 0 ?  1 + cycleLength(n / 2) :
                            2 + cycleLength((3 * n + 1) / 2) );
        }

        return cache.get(n);
    }

    /*public int cycleLengthFor(int n) {
        for (int i = n, c = 0; true; i = (i % 2 == 0) ? i/2 : (3*i)+1, c++){
            if(i == 1){
                return c+1;
            }xw
        }
    }*/


    /*public int cycleLengthWhile(int n){
        int count = 0;
        int res = n;
        while (res != 1) {
            if (res % 2 == 1) {
                res = (3 * res + 1) / 2;
                count++; //two steps
            } else {
                res = res / 2;
            }
            count++;
        }

        return count + 1;


    }*/

    public int largestCycleLength(int i, int j) { //[i,j] inclusive
        int largestCycleCount = 0;
        int res;

        int min = Math.min(i, j);
        int max = Math.max(i, j);

        for (int k = min; k <= max ; k++) {
            res = cycleLength(k);

            if (res > largestCycleCount) {
                largestCycleCount = res;
            }
        }

        return largestCycleCount;


        //cleaner code but direct for loop + max is probably faster
        //return IntStream.rangeClosed(Math.min(i,j), Math.max(i,j)).map
        // (this::cycleLength).max().orElse(1);

    }

    public static void main(String[] args) {
        Main sol = new Main();

        String input;
        StringTokenizer data;
        int a, b;

        while ((input = ReadLn()) != null) {
            data = new StringTokenizer(input);
            a = Integer.parseInt(data.nextToken());
            b = Integer.parseInt(data.nextToken());
            System.out.println(a + " " + b + " " + sol.largestCycleLength(a, b));
        }
    }

}