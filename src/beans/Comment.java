package beans;

public class Comment extends UserPost{

	public Comment(String username, String timeCreated, String textEntry, String photoLocation, String linkLocation,
			String videoLocation) {
		super(username, timeCreated, textEntry, photoLocation, linkLocation, videoLocation);
	}

	public String display(){
		String ret ="<p>";
		String indentation = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		ret += indentation + "Username:&nbsp;" + getUsername();
		ret += "<br />";
		ret += indentation + "Time Created:&nbsp;" + getTimeCreated();
		ret += "<br />";
		ret += indentation + "Text:&nbsp;" + getTextEntry();
		ret += "<br />";
		ret += indentation + "Photo:&nbsp;" + getPhotoLocation();
		ret += "<br />";
		ret += indentation + "Link:&nbsp;" + getLinkLocation();
		ret += "<br />";
		ret += indentation + "Video:&nbsp;" + getVideoLocation();
		ret += "</p>";
		return ret;
	}
}
