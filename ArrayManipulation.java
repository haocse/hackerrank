import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    /**
     * Check this out. 
     * https://stackoverflow.com/questions/48162233/logic-used-behind-array-manipulation-of-hackerrank
     * 
     * @param n
     * @param queries
     * @return
     */
    static long arrayManipulation(int n, int[][] queries) { //

        // initialize array with 0's of size n
        long arr[] = new long[n];

        // each successive element contains the difference between itself and previous
        // element

        for (int i = 0; i < queries.length; i++) {
            // when checking query, subtract 1 from both a and b since 0 indexed array
            int a = queries[i][0] - 1;
            int b = queries[i][1] - 1;
            int k = queries[i][2];
            
            // System.out.print("p:" + a + "\n");
            // System.out.print(arr[a] + "\n");
            arr[a] += k;
            // System.out.print(arr[a] + "\n");
            
            
            
            if (b + 1 < n) { // what's this?
                arr[b + 1] -= k;
            }
        }
        

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + "\n") ;
        // }

        // track highest val seen so far as we go
        long max = Long.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            max = Math.max(arr[i], max);
        }
        System.out.print(arr[0] + "-" + arr[1] + "-" + arr[2] + "-" + arr[3] + "-" + arr[4] + "\n");

        System.out.print("---max----");
        System.out.print(max);

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // System.out.printf("...");
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        // for (int i = 0; i < nm.length; i++) {
        // System.out.printf("" + nm[i] + "\n");
        // }
        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.print(result);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
