package com.ssafy.data;

import java.io.*;
import java.net.*;

public class DataTest {

	 public static void main(String[] args) throws IOException {
//	        StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"); /*URL*/
//	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=서비스키"); /*Service Key*/
//	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//	        urlBuilder.append("&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" + URLEncoder.encode("11110", "UTF-8")); /*지역코드*/
//	        urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD","UTF-8") + "=" + URLEncoder.encode("201512", "UTF-8")); /*계약월*/
		 	String urlBuilder = "https://apis.data.go.kr/B551011/KorService1/searchKeyword1?serviceKey=XqzbfhNXUSSyTQ0%2FK0PlrPpOhi%2BnZqAp3LP7guL1Djh9cYxsubBJJpWMmZ8EttAYZneUdg9GfBAdj3wzglcR7g%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=xml&listYN=Y&arrange=A&keyword=%ED%95%B4%EC%9A%B4%EB%8C%80&contentTypeId=12";
	        URL url = new URL(urlBuilder);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/xml");
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
	    }	
}


