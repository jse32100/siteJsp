package com.book.model;

public class BookDTO {
	
	private int num;
	private String title;
	private String writer;
	private int price;
	private String publisher;
	private String description;
	private String filename;
	private String category;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title == null ? "" : title.trim();
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer == null ? "" : writer.trim();
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher == null ? "" : publisher.trim();
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDescription() {
		return description == null ? "" : description.trim();
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFilename() {
		return filename == null ? "" : filename.trim();
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getCategory() {
		return category == null ? "" : category.trim();
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
	
}
