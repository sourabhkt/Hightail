package com.hightail.weather.bindings;

import javax.xml.bind.annotation.XmlAttribute;

public class Location {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Location [city=" + city + ", region=" + region + ", country="
				+ country + "]";
	}

	@XmlAttribute
	public String city;
	
	@XmlAttribute
	public String region;
	
	@XmlAttribute
	public String country;

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}	
}
