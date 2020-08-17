package com.messenger.controller;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.messenger.model.Comment;
import com.messenger.model.Message;
import com.messenger.service.CommentServicce;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	
	CommentServicce cServ = new CommentServicce();
	
	@POST
	public Response saveCom(@PathParam("messageId") int messId,Comment comment)
	{
		
		
		if(comment == null || messId==0)
		{
			return Response.status(Status.NOT_FOUND).entity("Enter correct details ").build();
			
		}else {
			
			Message mess = new Message();
			mess.setMessageId(messId);
			comment.setComCreated(new Date());;
		comment.setComMesFk(mess);	
		
		cServ.saveCom(comment);
		
		return Response.status(Status.OK).entity("Saved comment ssuccessfully").build();}
	}
	@GET
	@Path("/{commentId}")
	public Response getComment(@PathParam("messageId") int messId,@PathParam("commentId") int commentId)
	{
		
		
		Comment Com = cServ.getComment(messId, commentId);
		return Response.status(Status.OK).entity(Com ).build();
	}
	
	
	@GET
	public Response getComms(@PathParam("messageId") int messId)
	{
		
		System.out.println("mess id at comment controller"+messId);
		
		Comment lisCom = cServ.getAllComms(messId);
		
		if(lisCom == null)
		{
			return
					Response.status(Status.NOT_FOUND).entity("Data empty! please add data" ).build();
		}
		return
		Response.status(Status.OK).entity(lisCom ).build();
	}
	
	@PUT
	@Path("/{commentId}")
	public Response updateComm(@PathParam("messageId") int messageId,@PathParam("commentId") int commentid,Comment comment)
	{
		
		if(comment == null)
		{
			return Response.status(Status.NOT_FOUND).entity("Enter correct details ").build();
		}
		else
		{
			Message mess = new Message();
			mess.setMessageId(messageId);
		comment.setCommentId(commentid);
		comment.setComMesFk(mess);
		comment.setComCreated(new Date());
		
		
		cServ.updateComm(comment);
		
			}
		return Response.status(Status.OK).entity( "Updated successfully").build();
			
	}
	
	@DELETE
	@Path("/{commentId}")
	public Response deleComm(@PathParam("messageId") int messageId,@PathParam("commentId") int commentid)
	{
		System.out.println("controller mess id"+messageId + "comment id "+commentid);
		if(messageId>0 && commentid>0)
		{
		cServ.deleComm(messageId, commentid);
		
		return Response.status(Status.OK).entity( "Deleted Successfully").build();
		}
		else
		{
			return Response.status(Status.NOT_FOUND).entity("Enter correct details ").build();
		}
	
	}
	
}
