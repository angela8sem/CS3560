package iVote;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoice implements Question
{
	private String question;
	private List<String> answers = new ArrayList<String>();

	public boolean isSingleChoice()
	{
		return false;
	}

	public void setQuestion(String q)
	{
		this.question = q;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public void setAnswer(String a)
	{
		this.answers.add(a);
	}

	public List<String> getAnswer()
	{
		return answers;
	}
}