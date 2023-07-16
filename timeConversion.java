/*Given a time in -hour AM/PM format, convert it to military (24-hour) time.

Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.

Example


Return '12:01:00'.


Return '00:01:00'. */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
    
    String sb=s.substring(0,2);
    int sbparse=Integer.parseInt(sb);
    
    //String sub=Integer.toString(sbparse);
    
    if(s.charAt(8)=='P' || s.charAt(8)=='p'){
        if(s.charAt(0)=='1'&& s.charAt(1)=='2'){
            s=s.substring(0, 8);
        }
        else if(s.charAt(0)=='0'&& sbparse>0 ){
            sbparse=sbparse+12;
             sb=Integer.toString(sbparse);
             s=sb+s.substring(2,8);
        }
        else if(s.charAt(0)=='1' && sbparse<12){
            sbparse=sbparse+12;
             sb=Integer.toString(sbparse);
             s=sb+s.substring(2,8);
        }
        
    }
    else if(s.charAt(8)=='A' || s.charAt(8)=='a'){
        if(s.charAt(0)=='1'&& s.charAt(1)=='2'){
            s="00"+s.substring(2, 8);
         }
         else{
             s=s.substring(0, 8);
         }
    }
    return s;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
