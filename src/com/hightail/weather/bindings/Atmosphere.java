package com.hightail.weather.bindings;

import javax.xml.bind.annotation.XmlAttribute;

public class Atmosphere {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Atmosphere [humidity=" + humidity + ", visibility="
				+ visibility + ", pressure=" + pressure + ", rising=" + rising
				+ "]";
	}

	@XmlAttribute
	public int humidity;
	
	@XmlAttribute
	public int visibility;
	
	@XmlAttribute
	public float pressure;
	
	@XmlAttribute
	public int rising;

	/**
	 * @return the humidity
	 */
	public int getHumidity() {
		return humidity;
	}

	/**
	 * @return the visibility
	 */
	public int getVisibility() {
		return visibility;
	}

	/**
	 * @return the pressure
	 */
	public float getPressure() {
		return pressure;
	}

	/**
	 * @return the rising
	 */
	public int getRising() {
		return rising;
	}
}
