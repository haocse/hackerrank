import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {
		int start = 0 ; 
		int end = start + 1; 
		int strLength = s.length(); 
		int counter = 0;        
		HashMap<String,Integer> str = new HashMap<>();
        while(start < strLength){
            char[] c = s.substring(start,end).toCharArray();
            Arrays.sort(c);
            String temp = String.valueOf(c);

            if(!str.containsKey(temp))
                str.put(temp, 1);
            else{
                int freq = str.get(temp);
                counter += freq;
                str.put(temp, freq + 1);
            }
            end++;
            if(end > strLength){
                start++;
                end = start + 1;
            }
        }
        return counter;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
			
			System.out.print(result + "\n");
            // bufferedWriter.write(String.valueOf(result));
            // bufferedWriter.newLine();
        }

        // bufferedWriter.close();

        scanner.close();
    }
}
