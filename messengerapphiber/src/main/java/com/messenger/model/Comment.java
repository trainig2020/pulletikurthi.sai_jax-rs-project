package com.messenger.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table

public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	private String comMessage;
	private Date comCreated;
	private String comAuthor;
	@ManyToOne
	private Message message;
	
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComMessage() {
		return comMessage;
	}
	public void setComMessage(String comMessage) {
		this.comMessage = comMessage;
	}
	public Date getComCreated() {
		return comCreated;
	}
	public void setComCreated(Date comCreated) {
		this.comCreated = comCreated;
	}
	public String getComAuthor() {
		return comAuthor;
	}
	public void setComAuthor(String comAuthor) {
		this.comAuthor = comAuthor;
	}
	
	
	public Message getComMesFk() {
		return message;
	}
	public void setComMesFk(Message message) {
		this.message = message;
	}
	
	
	
	public Comment(int commentId, String comMessage, Date comCreated, String comAuthor, Message message) {
		super();
		this.commentId = commentId;
		this.comMessage = comMessage;
		this.comCreated = comCreated;
		this.comAuthor = comAuthor;
		this.message = message;
	}
	public Comment(int commentId, String comMessage, Date comCreated, String comAuthor) {
		super();
		this.commentId = commentId;
		this.comMessage = comMessage;
		this.comCreated = comCreated;
		this.comAuthor = comAuthor;
	}
	public Comment() {
		super();
	}
	

}
