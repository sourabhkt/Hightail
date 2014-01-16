package com.hightail.weather.bindings;

import javax.xml.bind.annotation.XmlElement;

public class Astronomy {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Astronomy [sunrise=" + sunrise + ", sunset=" + sunset + "]";
	}

	@XmlElement
	public String sunrise;
	
	@XmlElement
	public String sunset;

	/**
	 * @return the sunrise
	 */
	public String getSunrise() {
		return sunrise;
	}

	/**
	 * @return the sunset
	 */
	public String getSunset() {
		return sunset;
	}
}
