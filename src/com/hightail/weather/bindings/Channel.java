package com.hightail.weather.bindings;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Channel {
	
	public static final String NAMESPACE = "http://xml.weather.yahoo.com/ns/rss/1.0";
	public Channel() {
		super();
	}

	@XmlElement
    public String title;
    
    @XmlElement
    public String link;

    @XmlElement
    public String language;

    @XmlElement
    public String description;

    @XmlElement
    public Date lastBuildDate;

    @XmlElement
    public long ttl;
    
    @XmlElement(namespace=NAMESPACE)
    public Location location;
    
    @XmlElement(namespace=NAMESPACE)
    public Units units;

    @XmlElement(namespace=NAMESPACE)
    public Wind wind;
    
    @XmlElement(namespace=NAMESPACE)
    public Atmosphere atmosphere;
    
    @XmlElement(namespace=NAMESPACE)
    public Astronomy astronomy;

    /**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the lastBuildDate
	 */
	public Date getLastBuildDate() {
		return lastBuildDate;
	}

	/**
	 * @return the ttl
	 */
	public long getTtl() {
		return ttl;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @return the units
	 */
	public Units getUnits() {
		return units;
	}

	/**
	 * @return the wind
	 */
	public Wind getWind() {
		return wind;
	}

	/**
	 * @return the atmosphere
	 */
	public Atmosphere getAtmosphere() {
		return atmosphere;
	}

	/**
	 * @return the astronomy
	 */
	public Astronomy getAstronomy() {
		return astronomy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Channel [title=" + title + ", link=" + link + ", language="
				+ language + ", description=" + description
				+ ", lastBuildDate=" + lastBuildDate + ", ttl=" + ttl
				+ ", location=" + location + ", units=" + units + ", wind="
				+ wind + ", atmosphere=" + atmosphere + ", astronomy="
				+ astronomy + "]";
	}

}
