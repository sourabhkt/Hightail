package com.hightail.weather.bindings;

import javax.xml.bind.annotation.XmlAttribute;

public class Units {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Units [temperature=" + temperature + ", distance=" + distance
				+ ", pressure=" + pressure + ", speed=" + speed + "]";
	}

	@XmlAttribute
	public String temperature;
	
	@XmlAttribute
	public String distance;
	
	@XmlAttribute
	public String pressure;
	
	@XmlAttribute
	public String speed;

	/**
	 * @return the temprature
	 */
	public String getTemprature() {
		return temperature;
	}

	/**
	 * @return the distance
	 */
	public String getDistance() {
		return distance;
	}

	/**
	 * @return the pressure
	 */
	public String getPressure() {
		return pressure;
	}

	/**
	 * @return the speed
	 */
	public String getSpeed() {
		return speed;
	}
}
