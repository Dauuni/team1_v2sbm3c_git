package dev.mvc.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// 순수 자바 HttpURLConnection으로 접근
public class WebLoading {
	
	public static void main(String[] args) throws Exception{
		String Address = "http://finlife.fss.or.kr/finlifeapi/depositProductsSearch.json?auth=2280639be6ff46a7021f490d12ada3a0&topFinGrpNo=020000&pageNo=1";
	  String method = "GET";
		URL url = new URL(Address);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod(method);
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		
		String line ;
		while((line = br.readLine()) != null){
  		System.out.println(line);
		}
    br.close();
    
   
	}
}
