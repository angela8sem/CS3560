package iVote;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;


public class Student 
{
	
	private List<String> answers = new ArrayList<String>();
	private UUID studentID;
	
	public Student()
	{
		setID(UUID.randomUUID());
	}
	
	public void setID(UUID id)
	{
		this.studentID = id;
	}
	
	public UUID getID()
	{
		return this.studentID;
	}
	
	public void setAnwers(String ans)
	{
		this.answers.add(ans);
	}
	
	public List<String> getAnswers()
	{
		return answers;
	}
}
