package com.example.demo.forms;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;


import lombok.Data;

@Data

public class ItemForm implements Serializable {
	private static final long serialVersionUID = -6647247658748349084L;


	private long id;

	@NotBlank
	@Size(max = 20)
	private String name;

	@NotBlank

	private String Price;

	@NotBlank
	@Size(max = 400)
	private String content;


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

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void clear() {
		name = null;
		Price = null;
		content = null;
	}




}