package iVote;

import java.util.List;


public interface Question 
{
	public boolean isSingleChoice();
	
	public void setQuestion(String q);
	
	public String getQuestion();
	
	public void setAnswer(String a);
	
	public List<String> getAnswer();
}
