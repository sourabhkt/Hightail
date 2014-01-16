package com.hightail.weather;

import com.hightail.weather.bindings.WeatherDetails;

public class TestWeatherAPI {

	public static void main(String[] args)
	{
		String city_zip = "2295420";
		WeatherDetails wd = WeatherAPI.getWeatherForecast(city_zip);
		System.out.println(wd);
//		System.out.println(wd.getChannel().getAtmosphere().visibility);
	}
}
