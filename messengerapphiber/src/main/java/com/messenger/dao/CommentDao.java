package com.messenger.dao;

import java.util.List;

import com.messenger.model.Comment;

public interface CommentDao {
	
	Comment getComms(int messId);
	
	Comment getComment(int messageId,int commentId);
	
	int saveComms(Comment comment);
	
	int updateComms(Comment comment);
	
	int deleComms(int messId,int commId);

}
