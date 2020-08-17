package com.messenger.model;

public class Link {
	
	
	private int linkId;
	private String links;
	private String rel;
	
	private int messLinkFk;
	
	public String getLinks() {
		return links;
	}
	public void setLinks(String links) {
		this.links = links;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}	
	public int getLinkId() {
		return linkId;
	}
	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}
	public int getMessLinkFk() {
		return messLinkFk;
	}
	public void setMessLinkFk(int messLinkFk) {
		this.messLinkFk = messLinkFk;
	}
	
	
	
	public Link(int linkId, String links, String rel, int messLinkFk) {
		super();
		this.linkId = linkId;
		this.links = links;
		this.rel = rel;
		this.messLinkFk = messLinkFk;
	}
	public Link(String links, String rel) {
		super();
		this.links = links;
		this.rel = rel;
	}
	public Link() {
		super();
	}
	

}
