package com.hightail.weather.bindings;

import javax.xml.bind.annotation.XmlAttribute;

public class Wind {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Wind [chill=" + chill + ", direction=" + direction + ", speed="
				+ speed + "]";
	}

	@XmlAttribute
	public int chill;
	
	@XmlAttribute
	public int direction;
	
	@XmlAttribute
	public float speed;

	/**
	 * @return the chill
	 */
	public int getChill() {
		return chill;
	}

	/**
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}
}
