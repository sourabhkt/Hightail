package com.hightail.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.hightail.weather.bindings.WeatherDetails;

public class WeatherAPI {
	
	private static final String YAHOO_SERVICE_URL = "http://weather.yahooapis.com/forecastrss";
	
	public static WeatherDetails getWeatherForecast(String woid,String unitCode)
	{
		try
		{
			StringBuilder u = new StringBuilder(YAHOO_SERVICE_URL);
			u.append("?w="+woid);
			u.append("&u="+unitCode);
			
			System.out.println("-------------------------------");
			System.out.println(u.toString());
			System.out.println("-------------------------------");
		
			URL url = new URL(u.toString());
			URLConnection connection = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
 
			while ((inputLine = in.readLine()) != null)
			{
				response.append(inputLine+"\r");
			}
			in.close();
			return parseXML(response.toString());
		}
		catch(IOException io)
		{
			System.out.println("IOException while processing your request !!");
			return null;
		}
		catch(JAXBException jaxb)
		{
			System.out.println("JAXBException while processing your request !!");
			return null;
		}
		catch(Exception ex)
		{
			System.out.println("Error processing your request !!");
			return null;
		}
	}
	
	public static WeatherDetails getWeatherForecast(String woid)
	{
		return getWeatherForecast(woid, TempratureUnit.FAHRENHEIT.unitCode);
	}
	
	private static WeatherDetails parseXML(String xml) throws JAXBException
	{
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(WeatherDetails.class);
		 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			WeatherDetails wd = (WeatherDetails) jaxbUnmarshaller.unmarshal(new StringReader(xml));
		
			return wd;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public enum TempratureUnit {
		FAHRENHEIT("f"),
		CELCIUS("c");
		
		private String unitCode;
		
		private TempratureUnit(String arg) {
			this.unitCode = arg;
		}
		
		@Override
		public String toString()
		{
			return this.unitCode;
		}
	}
}
