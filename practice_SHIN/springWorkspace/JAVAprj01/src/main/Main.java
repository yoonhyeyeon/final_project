package main;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {

    public static void main(String[] args) throws Exception {

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=gDWhTBgz1jqQhO%2FBd2HKZ86cRFMYhekL%2BqjEsUG1Ak53K%2FTTTYSdIjLx36fKbXxDhdAo%2BG7rfpnmRUigbBSDVA%3D%3D");
        urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("3", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("year", "UTF-8") + "=" + URLEncoder.encode("2024", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("itemCode", "UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8"));

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        // JSON 파싱
        JsonObject jsonObject = JsonParser.parseString(sb.toString()).getAsJsonObject();
        JsonArray items = jsonObject.getAsJsonObject("response").getAsJsonObject("body").getAsJsonArray("items");

        //db
        Connection dbConn = JDBCTemplate.getConn();
        String sql = "INSERT INTO AIR_KOREA(DISTRICT_NAME, ISSUE_GBN) VALUES ( ?, ?)";
        PreparedStatement pstmt = dbConn.prepareStatement(sql);

        for (JsonElement item : items) {
            JsonObject obj = item.getAsJsonObject();
            String districtName = obj.get("districtName").getAsString();
            String issueGbn = obj.get("issueGbn").getAsString();

            pstmt.setString(1, districtName);
            pstmt.setString(2, issueGbn);

            pstmt.addBatch();
        }



        int[] result = pstmt.executeBatch();
        System.out.println("result = " + result);
        pstmt.close();
        dbConn.close();
    }
}
