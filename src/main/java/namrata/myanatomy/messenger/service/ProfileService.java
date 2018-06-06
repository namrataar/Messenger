package namrata.myanatomy.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import namrata.myanatomy.messenger.database.DatabaseClass;
import namrata.myanatomy.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("namrata", new Profile(1L, "namrata", "Namrata", "Arora"));
		profiles.put("namrata1", new Profile(1L, "namrata1", "Namrataa", "Aroraa"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values()); 
	}
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile (Profile profile)
	{
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
}
