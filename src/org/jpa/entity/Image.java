package org.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class Image {
	@Lob
	@Column(name="file_image")
	private byte[] image;
	
	@Column(name="file_name",nullable=true,length=100)
	private String nameImage;
	@Column(name="file_type",nullable=true,length=30)
	private String typeImage;
	@Column(name="file_length",nullable=true)
	private Long length;
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getNameImage() {
		return nameImage;
	}
	public void setNameImage(String nameImage) {
		this.nameImage = nameImage;
	}
	public String getTypeImage() {
		return typeImage;
	}
	public void setTypeImage(String typeImage) {
		this.typeImage = typeImage;
	}
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}
}
