package com.messenger.service;

import java.util.List;

import com.messenger.dao.ProfileDao;
import com.messenger.dao.ProfileDaoImpl;
import com.messenger.model.Profile;

public class ProfileService {

ProfileDao dao = new ProfileDaoImpl();
	
	public List<Profile> getAllProf(){
	
	List<Profile> lisd = dao.getAllProfiles();
		
	
	for (Profile profile : lisd) {
		System.out.println(profile.getFirstName());
	}
	
	
	return lisd;}
	
	
	public Profile getProf(String profName)
	{
		Profile prof = dao.getProfile(profName);
		return prof;
	}
	
	
	public int saveProf(Profile prof)
	
	{
		
				dao.savProfile(prof);
				return 0;
	}
	
	
	public int updateProf(Profile prof)
	{
		dao.updateProfile(prof);
		
		return 0;
	}
	
	public int deleProf(String profName)
	{
		dao.deleteProfile(profName);
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