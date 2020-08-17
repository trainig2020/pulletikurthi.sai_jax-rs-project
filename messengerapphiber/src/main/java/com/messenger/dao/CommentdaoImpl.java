package com.messenger.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.messenger.model.Comment;
import com.messenger.util.HibernateUtil;

public class CommentdaoImpl implements CommentDao{

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Comment getComms(int messId) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from comment where message_messageId = :com_mess");
        
        query.addEntity(Comment.class);
        query.setParameter("com_mess",messId);
        Comment com=null;
List<Comment> comLis = query.list();
if(! comLis.isEmpty())
{
	

com = new Comment(comLis.get(0).getCommentId(),comLis.get(0).getComMessage(),comLis.get(0).getComCreated(),comLis.get(0).getComAuthor(),comLis.get(0).getComMesFk());
}
        session.getTransaction().commit();
   
		return com;
	}
	
	

	@Override
	public int saveComms(Comment comment) {
Session session = sessionFactory.openSession();

	    session.beginTransaction();
	    
	    session.save(comment);
	    session.getTransaction().commit();

		return 0;
	}

	@Override
	public int updateComms(Comment comment) {
		
		//java.sql.Date sqlDate = new java.sql.Date(comment.getComCreated().getTime());
Session session = sessionFactory.openSession();

//comment.setComCreated(sqlDate);
	    session.beginTransaction();
	    session.update(comment);
	    session.getTransaction().commit();
		return 0;
	}
	
	

	@Override
	public int deleComms(int messId, int commId) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("delete  from comment where commentId =:commentId and message_messageId =:comMessId");

        query.addEntity(Comment.class);
        query.setInteger("commentId", commId);
        query.setInteger("comMessId", messId);
        System.out.println("delete at dao "+" messId "+messId + "commId "+commId);
       query.executeUpdate();
       session.getTransaction().commit();
       System.out.println("deleted success");
        
		return 0;
	}



	@Override
	public Comment getComment(int messageId, int commentId) {
		Session session3=sessionFactory.openSession();
		session3.beginTransaction();
		SQLQuery query=session3.createSQLQuery("select * from Comment where commentId =:cid and message_messageId = :com_mess");
		query.setParameter("cid", commentId);
		query.setParameter("com_mess", messageId);
		query.addEntity(Comment.class);
		List<Comment> comment= query.list();
		Comment comment2=new Comment();
		for (Comment comment3 : comment) {
			comment2.setCommentId(comment3.getCommentId());
			comment2.setComAuthor(comment3.getComAuthor());
			comment2.setComCreated(comment3.getComCreated());
			comment2.setComMessage(comment3.getComMessage());	
		}
		session3.getTransaction().commit();
		return comment2;
	}
}
