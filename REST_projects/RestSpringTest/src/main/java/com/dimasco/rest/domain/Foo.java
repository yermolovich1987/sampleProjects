package com.dimasco.rest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="FOO_TABLE")
@XmlRootElement
public class Foo implements Serializable {

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;

	@Column(name="NAME")
	//@Type(type="yes_no") // just for tests
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE")
	private Date date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Foo [id=" + id + ", name=" + name + ", date=" + date + "]" + "\n";
	}
	
	/**
	 * Checks what data was changed and update necessary properties of object
	 * 
	 * @param newFoo
	 */
	public void update(final Foo newFoo) {
		if (newFoo == null) {
			throw new IllegalArgumentException();
		}
		
		if ( (this.name!=null) && (newFoo.name!=null) && !this.name.equals(newFoo.name)) {
			this.name = newFoo.name;
		}
		
		if ( (this.date!=null) && (newFoo.date!=null) && !this.date.equals(newFoo.date) ) {
			this.date = newFoo.date;
		}
	}
}
