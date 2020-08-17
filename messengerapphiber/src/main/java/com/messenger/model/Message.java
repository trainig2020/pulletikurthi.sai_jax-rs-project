package com.messenger.model;

import java.util.Date;
import java.util.List;

import javax.jws.Oneway;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table

public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageId;

	private String message;
	private Date created;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="author") private Profile author;
	 */

	private String author;
	@OneToMany(cascade=CascadeType.REMOVE)
	private List<Comment> comment;
	@Transient
	private List<Link> links;

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	/*
	 * public Profile getAuthor() { return author; } public void setAuthor(Profile
	 * author) { this.author = author; }
	 */

	@XmlTransient
	public List<Comment> getComment() {
		return comment;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public Message(int messageId, String message, Date created, String author, List<Comment> comment,
			List<Link> links) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.created = created;
		this.author = author;
		this.comment = comment;
		this.links = links;
	}

	/*
	 * public Message(int messageId, String message, Date created, Profile author) {
	 * super(); this.messageId = messageId; this.message = message; this.created =
	 * created; this.author = author; }
	 */
	public Message() {
		super();
	}

}
