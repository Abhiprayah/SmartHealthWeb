package models;

import java.util.ArrayList;

import beans.Address;
import beans.Qualification;

public interface UpdateInterface {

	public void updateHelper(String table, String field, String newval, String userName);
	
	public void updateAddressHelper(Address address, String userID);
	
	public void updateModeratorQualificationHelper(ArrayList<Qualification> qualifications, String userID);
	
}
