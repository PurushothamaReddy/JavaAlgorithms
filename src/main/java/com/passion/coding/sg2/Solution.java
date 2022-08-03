package com.passion.coding.sg2;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
@JsonIgnoreProperties(ignoreUnknown = true)
 class Response{
    int page;
    int per_page;
    int total;
    int total_pages;
    Country[] data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public Country[] getData() {
        return data;
    }

    public void setData(Country[] data) {
        this.data = data;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
 class Country{
    public Country() {
    }

    String name;
    String capital;
    String[] callingCodes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String[] getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(String[] callingCodes) {
        this.callingCodes = callingCodes;
    }
}
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
        if ((output = br.readLine()) != null) {
    //            System.out.println(output);
            ObjectMapper objectMapper = new ObjectMapper();
            Response response = objectMapper.readValue(output,Response.class);
            if(response !=null && response.getData() !=null && response.getData().length>0) {
                String[] callingCodes = response.data[0].callingCodes;
                String callingCode = callingCodes[callingCodes.length - 1];
                return "+"+callingCode+" "+phoneNumber;
            }
        }
        return "-1";
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
