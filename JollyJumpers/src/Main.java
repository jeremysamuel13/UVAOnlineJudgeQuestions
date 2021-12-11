import java.util.*;

class Main {
    public boolean isJollyJumper(int[] inp) {
        int n = inp.length;
        int target = inp[0];

        if(target == 1)
            return true;

        int diff;
        boolean[] check = new boolean[target];

        for (int i = 1; i < n - 1; i++) {
            diff = Math.abs(inp[i] - inp[i + 1]);

            if (diff == 0 || diff > target - 1 || check[diff - 1])
                return false;

            check[diff - 1] = true;
        }

        return true;

    }

    public static void main(String[] args) {
        Main sol = new Main();

        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            try{
                int[] inp = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                System.out.println(sol.isJollyJumper(inp) ? "Jolly" : "Not jolly");
            }catch (NumberFormatException ignored){

            }
        }
    }

}