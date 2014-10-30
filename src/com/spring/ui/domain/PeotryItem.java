package com.spring.ui.domain;

import java.io.Serializable;

public class PeotryItem  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	
	private String content;
	
	private String image_url;
	
	private long time;
	
	private String source;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "PeotryItem [title=" + title + ", content=" + content
				+ ", image_url=" + image_url + ", time=" + time + ", source="
				+ source + "]";
	}
	
	
	
}
