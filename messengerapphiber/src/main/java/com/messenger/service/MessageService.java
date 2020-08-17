package com.messenger.service;


import java.util.*;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.messenger.dao.MessageDao;
import com.messenger.dao.MessageDaoImpl;
import com.messenger.exception.DataNotFoundException;
import com.messenger.model.ErrorMessage;
import com.messenger.model.Message;

public class MessageService {
	
	MessageDao dao = new MessageDaoImpl();
	
	public List<Message> getAllMess(){
	
	List<Message> lisd = dao.getAllMessages();
		
	
	for (Message message : lisd) {
		System.out.println(message.getMessage());
	}
	
	
	return lisd;}
	
	
	
	//for pagination and filtering
	
	public List<Message> messagesbyYear(int year)
	{
		
		List<Message> messYea = new ArrayList<>();
		
		Calendar cal = Calendar.getInstance();
		List<Message> mess = dao.getAllMessages();
		for (Message message : mess) {
			
			cal.setTime(message.getCreated());
			
			if(cal.get(Calendar.YEAR)==year)
			{
				messYea.add(message);
			}
		}
		return messYea;
		
	}
	
	public List<Message> pagingMeth(int start,int size)
	{
		
		List<Message> mess = dao.getAllMessages();
		if(start+size>mess.size())
			return new ArrayList<Message>();
		
		return mess.subList(start, size);
		
	}
	
	public Message getMess(int messId)
	{
		/*
		 * ErrorMessage em = new ErrorMessage("not found", 404, "www.google.com");
		 * Response res =Response.status(Status.NOT_FOUND).entity(em).build();
		 */
		Message mess = dao.getMessage(messId);
		/*
		 * if(mess == null) { throw new WebApplicationException(res); }
		 */
		
		return mess;
	}
	
	
	public int saveMess(Message message)
	
	{
		
				dao.saveMessage(message);
				return 0;
	}
	
	
	public int updateMess(Message message)
	{
		dao.updateMessage(message);
		
		return 0;
	}
	
	public int deleMess(int messageId)
	{
		dao.deleteMessage(messageId);
		return 0;
	}

}





















/*
 * Message mess = new Message(1,"Hai",new Date(),"Udhay"); Message mess1 = new
 * Message(2,"Hello",new Date(),"Soorya"); Message mess2 = new
 * Message(3,"how are you",new Date(),"Ajith"); Message mess3 = new
 * Message(4,"good",new Date(),"vijay"); Message mess4 = new Message(5,"fun",new
 * Date(),"Ajmal"); Message mess5 = new Message(6,"run",new Date(),"kumar");
 * 
 * lisd.add(mess); lisd.add(mess2); lisd.add(mess3); lisd.add(mess4);
 * lisd.add(mess5);
 */