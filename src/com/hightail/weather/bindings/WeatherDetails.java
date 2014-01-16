package com.hightail.weather.bindings;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rss")
public class WeatherDetails {
	
		final String NAMESPACE = "http://xml.weather.yahoo.com/ns/rss/1.0";
		
		@XmlElement
		public Channel channel;
		
		public WeatherDetails()
		{
		}
        
		public Channel getChannel()
		{
			return channel;
		}
		
		@Override
		public String toString()
		{
			return getChannel().toString();
		}
}