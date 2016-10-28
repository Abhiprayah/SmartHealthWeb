package beans;

import java.io.PrintWriter;
import java.util.*;

//Moderator class inherits abstract class User
public class Moderator extends User{
	
	private String emergencyContact;
	private ArrayList<Qualification> qualifications;
	
	//Constructor for initialization of Moderator Object
	public	Moderator(String firstName, String lastName,String primaryEmail,
			String secondaryEmail, String password, String userId,
			Address address, String aboutMe, String picurl1,
			String picurl2, String picurl3, boolean hasQuit,String emergencyContact, ArrayList<Qualification> qualifications)
	{
		super(firstName, lastName, primaryEmail, secondaryEmail, password, userId, address, aboutMe, picurl1, picurl2, picurl3, hasQuit);
		this.emergencyContact = emergencyContact;
		this.userType="MOD";
		this.qualifications = qualifications;
	}
	
	//Setter for Emergency Contact
	public void setEmergencyContact(String emergencyContact)
	{
		this.emergencyContact = emergencyContact;
	}
	
	//Setter for Qualifications
	public void setQualifications(ArrayList<Qualification> qualifications){
		this.qualifications = qualifications;
	}
	
	public String getEmergencyContact(){
		return emergencyContact;
	}
	public ArrayList<Qualification> getQualifications(){
		return qualifications;
	}
	//functions for displaying Moderator's info, overrides base class User dispayProfileInfo method
	@Override
	public void displayProfileInfo()
	{
		super.displayProfileInfo();
		System.out.println("Emergency Contact No: " + this.emergencyContact);
		for(int i=0;i<this.qualifications.size();i++)
		{
			System.out.println("Qualifications are : " + this.qualifications.get(i).toString());
		}
	}
	
	public String displayQualifications(){
		String s = "";
		for(int i=0;i<this.qualifications.size();i++)
		{
			s += this.qualifications.get(i).getQualificationID();
			if(i != this.qualifications.size()-1) s += " ";
		}
		return s;
	}
	
	public void printProfileInfo(PrintWriter pw)
	{
		super.printProfileInfo(pw);
		pw.println("Emergency Contact No: " + this.emergencyContact);
		pw.println("</br>");
		pw.println("Qualifications are:&nbsp;");
		for(int i=0;i<this.qualifications.size();i++)
		{
			if(i!=this.qualifications.size() - 1){
				pw.println(this.qualifications.get(i).toString()+ ",&nbsp");
			}else{
				pw.println(this.qualifications.get(i).toString());
			}
		}
	}
}
