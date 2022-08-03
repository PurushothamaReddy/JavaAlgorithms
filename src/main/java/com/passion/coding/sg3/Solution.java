package com.passion.coding.sg3;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

class Result {


    /*
     * Complete the 'getPhoneNumbers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING country
     *  2. STRING phoneNumber
     * API URL: https://jsonmock.hackerrank.com/api/countries?name=<country>
     */

    public static String getPhoneNumbers(String country, String phoneNumber) throws IOException{

        // Create a neat value object to hold the URL
        // %20 is to handle the spaces in country names
        URL url = new URL("https://jsonmock.hackerrank.com/api/countries?name="+country.replaceAll(" ","%20"));

    // Open a connection(?) on the URL(??) and cast the response(???)
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    // Now it's "open", we can set the request method, headers etc.
        connection.setRequestProperty("accept", "application/json");
    // This line makes the request
        InputStream responseStream = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (responseStream)));

        String output;
        String previous = "";
        String result="-1";
        boolean iscallingCodesMulti=false;
        if ((output = br.readLine()) != null) {
            StringTokenizer stField =
                    new StringTokenizer(output, ",");
            while (stField.hasMoreElements()){
                String field = stField.nextToken();
                System.out.println(field);
                if(field.contains("callingCodes") ) {
                    previous = field;
                }
                else if(field.contains("capital") && previous.contains("callingCodes") && !iscallingCodesMulti){
                    String callField = previous.substring(previous.indexOf("[")+1,previous.indexOf("]"));
                return "+"+callField.substring(1,callField.length()-1)+" "+phoneNumber;
                } else if(field.contains("capital")){
                    return result;
                }
                else if(previous.contains("callingCodes") && !field.contains("capital")  ){
                    iscallingCodesMulti = true;
                    result = "+"+field.substring(1,field.length()-2)+" "+phoneNumber;
                }
            }

        }
        return result;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String country = bufferedReader.readLine();

        String phoneNumber = bufferedReader.readLine();

        String result = Result.getPhoneNumbers(country, phoneNumber);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
