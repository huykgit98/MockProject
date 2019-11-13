package edu.sgu.bookingsystem.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

//convert json to String Online
public class HttpUtil {
	
	private String value;
	
	public HttpUtil(String value) {
		this.value = value;
	}
	
	//mapping json String vao model - Buoc 2:
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
	
	//json -> json string - Buoc 1
	public static HttpUtil of (BufferedReader reader) 
	{
		//searching keyword: parse json from bufferedreader java to string 
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			while ( (line = reader.readLine() ) != null)  {
				sb.append(line);
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return new HttpUtil(sb.toString());
		
	}
}
