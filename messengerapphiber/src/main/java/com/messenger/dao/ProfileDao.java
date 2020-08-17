package com.messenger.dao;

import java.util.List;

import com.messenger.model.Profile;

public interface ProfileDao {
	
	
	int savProfile(Profile profile);
	List<Profile> getAllProfiles();
	Profile getProfile(String profName);
	
	int updateProfile(Profile profile);
	int deleteProfile(String profName);
	

}
