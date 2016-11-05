package beans;

import java.util.ArrayList;

public class Post extends UserPost{
	
	private final int ID;
	private ArrayList<Comment> comments;
	private double rating;
	
	public Post(String username, String timeCreated, String textEntry, String photoLocation, String linkLocation,
			String videoLocation, ArrayList<Comment> comments, double rating, int ID) {
		super(username, timeCreated, textEntry, photoLocation, linkLocation, videoLocation);
		this.comments = comments;
		this.rating = rating;
		this.ID = ID;
	}
	
	public String display(){
		String ret = "";
		String indentation = "<br />";
		ret += "<p>";
		ret += "Post ID: " + ID;
		ret += indentation + "Rating: " + rating;
		ret += indentation + "Username: " + getUsername();
		ret += indentation + "Time Created: " + getTimeCreated();
		ret += indentation + "Text: " + getTextEntry();
		ret += indentation + "Photo: " + getPhotoLocation();
		ret += indentation + "Link: " + getLinkLocation();
		ret += indentation + "Video: " + getVideoLocation();
		ret += indentation;
		ret += "<input name=\"rating\" type=\"radio\" value=\"1\" />";
		ret += "<input name=\"rating\" type=\"radio\" value=\"2\" />";
		ret += "<input name=\"rating\" type=\"radio\" value=\"3\" />";
		ret += "<input name=\"rating\" type=\"radio\" value=\"4\" />";
		ret += "<input name=\"rating\" type=\"radio\" value=\"5\" />";
		ret += "<input name=\"RatingSubmit\" type=\"submit\" value=\"Rate\"";
		ret += indentation;
		ret += indentation;
		ret += "<label id=\"Label1\">Enter Comment:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>";
		ret += "<input name=\"comment\" type=\"text\" style=\"width: 400px\" />";
		ret += indentation;
		ret += "<label id=\"Label1\">Enter Photo Link:&nbsp;&nbsp;&nbsp;&nbsp;</label>";
		ret += "<input name=\"photoLocation\" type=\"text\" style=\"width: 400px\" />";
		ret += indentation;
		ret += "<label id=\"Label1\">Enter Video Link:&nbsp;&nbsp;&nbsp;&nbsp;</label>";
		ret += "<input name=\"videoLocation\" type=\"text\" style=\"width: 400px\" />";
		ret += indentation;
		ret += "<label id=\"Label1\">Enter Link Location:</label>";
		ret += "<input name=\"linkLocation\" type=\"text\" style=\"width: 400px\" />";
		ret += indentation;
		ret += "<input name=\"CommentSubmit\" type=\"submit\" value=\"Comment\" />";
		ret += "</p>";
		ret += "<p><strong>Comments:</strong></p>";
		for(Comment c : comments){
			ret += c.display();
		}
		return ret;
	}
	
	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void addComments(Comment comment) {
		this.comments.add(comment);
	}

	public double getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getID() {
		return ID;
	}
}
