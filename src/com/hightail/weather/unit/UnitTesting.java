package com.hightail.weather.unit;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import com.hightail.weather.bindings.WeatherDetails;
import com.hightail.weather.WeatherAPI;
import com.hightail.weather.WeatherAPI.TempratureUnit;

public class UnitTesting {
	
	public static final String WOID1 = "2295411";
	public static final String WOID2 = "2295420";

	// Weather details using woid
	@Test
	public void testWoid() {
		WeatherDetails weather1 = WeatherAPI.getWeatherForecast(WOID1);
		WeatherDetails weather2 = WeatherAPI.getWeatherForecast(WOID2);
		Assert.assertNotNull("Weather details is null.", weather1);
		Assert.assertNotNull("Weather details is null.", weather2);
	}
	
	// Weather details using woid and temperature unit
	@Test
	public void testWoidAndTempretureUnit()
	{
		WeatherDetails weather1 = WeatherAPI.getWeatherForecast(WOID1,TempratureUnit.CELCIUS.toString());
		WeatherDetails weather2 = WeatherAPI.getWeatherForecast(WOID1,TempratureUnit.FAHRENHEIT.toString());
		Assert.assertNotNull("Weather details should not be null.", weather1);
		Assert.assertNotNull("Weather details should not be null.", weather2);
	}
	
	//Weather API should return different values for different places
	@Test
	public void test3()
	{
		WeatherDetails weather1 = WeatherAPI.getWeatherForecast(WOID1,TempratureUnit.CELCIUS.toString());
		WeatherDetails weather2 = WeatherAPI.getWeatherForecast(WOID1,TempratureUnit.FAHRENHEIT.toString());
		Assert.assertNotEquals(weather1.getChannel(), weather2.getChannel());
	}
	
	// Incorrect values for woid
	@Test
	public void testIncorrectWoid()
	{
		WeatherDetails weather = WeatherAPI.getWeatherForecast("fdsfd343242");
		
	}
	
	//Incorrect values for temperature unit
	@Test
	public void testIncorrectTempValues()
	{
		WeatherDetails weather1 = WeatherAPI.getWeatherForecast(WOID1,TempratureUnit.CELCIUS.toString());
	}
	
	//Channel
	@Test
	public void testFeedChannel()
	{
		WeatherDetails weather = WeatherAPI.getWeatherForecast(WOID1,TempratureUnit.CELCIUS.toString());
		Assert.assertNotNull(weather.getChannel());
	}
	
	//title of the feed , Should include yahoo , city and region
	@Test
	public void testFeedTitle()
	{
		WeatherDetails weather = WeatherAPI.getWeatherForecast(WOID1);
		Assert.assertTrue(weather.getChannel().title.contains("Yahoo! Weather"));
		Assert.assertTrue(weather.getChannel().title.contains(weather.getChannel().location.city));
		Assert.assertTrue(weather.getChannel().title.contains(weather.getChannel().location.region));
	}
	
	//link should be correct
	@Test
	public void testFeedLink()
	{
		WeatherDetails weather = WeatherAPI.getWeatherForecast(WOID1);
		Assert.assertTrue(weather.getChannel().title.contains("Yahoo! Weather"));
		//UrlValidator urlValidator = new UrlValidator("http","https");
	}
	
	//language of weather forecast
	@Test
	public void testFeedLanguage()
	{
		WeatherDetails weather = WeatherAPI.getWeatherForecast(WOID1);
		//Locale.forLanguageTag(weather.getChannel().getLanguage());
	}
	
	//description of feed
	@Test
	public void testFeedDescription()
	{
		WeatherDetails weather = WeatherAPI.getWeatherForecast(WOID1);
		Assert.assertTrue(weather.getChannel().title.contains("Yahoo! Weather"));
		Assert.assertTrue(weather.getChannel().title.contains(weather.getChannel().location.city));
		Assert.assertTrue(weather.getChannel().title.contains(weather.getChannel().location.region));
	}

	//Atmosphere
	public void testTempratureAtmosphere()
	{
		WeatherDetails weather = WeatherAPI.getWeatherForecast(WOID1);
		int humidity = weather.getChannel().getAtmosphere().humidity;
		Assert.assertTrue(humidity >= 0 && humidity <= 100);
		Assert.assertNotNull(weather.getChannel().getAtmosphere().visibility);
		Assert.assertNotNull(weather.getChannel().getAtmosphere().pressure);
		int rising = weather.getChannel().getAtmosphere().rising;
		Assert.assertTrue(rising >= 0 && rising < 3);
	}
	
	//yweather:location , city, region, country
	//Location
	public void testFeedLocation()
	{
		WeatherDetails weather = WeatherAPI.getWeatherForecast(WOID1);
		Assert.assertNotNull(weather.getChannel().getLocation().city);
		Assert.assertNotNull(weather.getChannel().getLocation().region);
		Assert.assertNotNull(weather.getChannel().getLocation().country);
		
		Assert.assertTrue(weather.getChannel().getLocation().country.length() == 2);
	}
	
	//Wind
	@Test
	public void testFeedWind()
	{
		WeatherDetails weather = WeatherAPI.getWeatherForecast(WOID1,TempratureUnit.CELCIUS.toString());
		Assert.assertNotNull(weather.getChannel().getWind().chill);
		Assert.assertNotNull(weather.getChannel().getWind().direction);
		Assert.assertNotNull(weather.getChannel().getWind().speed);
	}
	
	//Default temperature unit is Fahrenheit
	@Test
	public void testTempratureUnit()
	{
		WeatherDetails weather = WeatherAPI.getWeatherForecast(WOID1);
		Assert.assertEquals(TempratureUnit.FAHRENHEIT.toString(), weather.getChannel().getUnits().temperature);
		weather = WeatherAPI.getWeatherForecast(WOID1,TempratureUnit.FAHRENHEIT.toString());
		Assert.assertEquals(TempratureUnit.FAHRENHEIT.toString(), weather.getChannel().getUnits().temperature);
		weather = WeatherAPI.getWeatherForecast(WOID1,TempratureUnit.FAHRENHEIT.toString());
		Assert.assertEquals(TempratureUnit.CELCIUS.toString(), weather.getChannel().getUnits().temperature);
	}
	
	//unit parameter is case sensitive
	@Test
	public void testCaseSensitiveUnit()
	{
	}
	
	//yweather:units , temp(f/c), distance(mi/km), pressure(in/mp) ,speed(kph,mph)
	@Test
	public void testFeedUnits()
	{
		WeatherDetails weather = WeatherAPI.getWeatherForecast(WOID1);
		String temperature = weather.getChannel().getUnits().temperature;
		String distance = weather.getChannel().getUnits().distance;
		String pressure = weather.getChannel().getUnits().pressure;
		String speed = weather.getChannel().getUnits().speed;
		
		Assert.assertTrue(temperature == "f" || temperature == "c");
		Assert.assertTrue(distance == "mi" || distance == "km");
		Assert.assertTrue(pressure == "in" || pressure == "mp");
		Assert.assertTrue(speed == "kph" || speed == "mph");
	}
	
	//yweather:atmosphere humidity(%age),visibility,pressure, rising
	@Test
	public void testFeedAtmosphere()
	{
	}
	
	//yweather:astronomy - sunrise,sunset
	@Test
	public void testFeedAstronomy()
	{
	}
	
	

}
