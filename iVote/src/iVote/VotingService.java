package iVote;

public class VotingService 
{
	private int a=0, b=0, c=0, d=0, e=0, ansTrue=0 , ansFalse=0;
	//private Student[]students;
	private Question question;
	
	public VotingService(Student[] students, Question question)
	{
		//this.students = students;
		this.question = question;
		
		//print the number of students that participated
		System.out.println("Number of students participacted: " + students.length);
		
		//if question is a single choice question, get students' answers 
		//and count how many students answered true and how many answered false.
		if(question.isSingleChoice())
		{
			for(int i = 0 ; i < students.length; i++) 
			{
				if(students[i].getAnswers().get(0) == "True")
				{
					ansTrue++;
				}
				else
				{
					ansFalse++;
				}
			}
			
			//print the statistics of the single choice question and answers
			printStatsSingle();
			
			System.out.println("\n--------------------------------------\n");
		}
		
		//if question is a multiple choice question, get students' answers based on how many answers each student has
		//and count how many students answered A and/or B and/or C etc...
		else
		{
			for(int i = 0 ; i < students.length; i++) 
			{
				int numAns = students[i].getAnswers().size();
				for(int j = 1 ; j < numAns ; j++)
				{
					if(students[i].getAnswers().get(j) == "A")
					{
						a++;
					}
					if(students[i].getAnswers().get(j) == "B")
					{
						b++;
					}
					if(students[i].getAnswers().get(j) == "C")
					{
						c++;
					}
					if(students[i].getAnswers().get(j) == "D")
					{
						d++;
					}
					if(students[i].getAnswers().get(j) == "E")
					{
						e++;
					}
				}
			}
			
			//print the statistics of the multiple choice question and answers
			printStatsMultiple();
		}
	}
	
	public void printStatsSingle()
	{
		System.out.println("\nQuestion 1: \n" + question.getQuestion());
		System.out.println("True or False?");
		System.out.println("Correct Answer: "+ question.getAnswer());

		System.out.println("\nStatistics for Question 1: ");
		System.out.println("True: " + ansTrue + " votes.");
		System.out.println("False: " + ansFalse + " votes.");
	}
	
	public void printStatsMultiple()
	{
		System.out.println("\nQuestion 2: \n" + question.getQuestion());
		System.out.println("A. ");
		System.out.println("B. ");
		System.out.println("C. ");
		System.out.println("D. ");
		System.out.println("E. ");
		System.out.println("Correct Answer: "+ question.getAnswer());
		
		System.out.println("\nStatistics for Question 2: ");
		System.out.println("A: " + a + " votes.");
		System.out.println("B: " + b + " votes.");
		System.out.println("C: " + c + " votes.");
		System.out.println("D: " + d + " votes.");
		System.out.println("E: " + e + " votes.");
	}
}
