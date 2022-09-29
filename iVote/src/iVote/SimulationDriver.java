package iVote;
import java.util.Random;

public class SimulationDriver 
{
	private static Question question1 = new SingleChoice();
	private static Question question2 = new MultipleChoice();
	private static Random rand = new Random();
	
	public static void main(String[] args) 
	{
		
		//generate students at least 10 and at most 100
		int num = rand.nextInt(100-10)+10;
		Student[] students = createNewStudents(num);
		
		//Create Questions 
		singleChoiceQuestion("Java is better than other programming languages.",students);
		multipleChoiceQuestion("Hello q2", students);
		
		//Display Student ID and their chosen answers for both questions
//		for(int i = 0 ; i < students.length; i++)
//		{
//			System.out.println("Student #"+ students[i].getID() + " answer is " + students[i].getAnswers());
//		}
//		System.out.println();
//		System.out.println();

		//Call Voting Service for Question1 and Question2 to calculate results and display Statistics
		VotingService voteQuestion1 = new VotingService (students, question1);
		VotingService voteQuestion2 = new VotingService (students, question2);
		
	}
	
	//create students 
	private static Student[] createNewStudents(int num)
	{
		Student students[] = new Student[num];
		for (int i = 0 ; i < num ; i++)
		{
			students[i] = new Student();
		}
		return students;
	}
	
	
	private static void singleChoiceQuestion(String q, Student[] students)
	{
		//Set the single choice question and randomly choose which answer is correct
		question1.setQuestion(q);
		int ans = rand.nextInt(2);
		if (ans == 0)
		{
			question1.setAnswer("True");
		}
		else
		{
			question1.setAnswer("False");
		}

		//generate random answers for students for single choice question
		for (int i = 0 ; i < students.length; i++)
		{
			int choice = rand.nextInt(2);
			if (choice == 0)
			{
				students[i].setAnwers("True");
			}
			else
			{
				students[i].setAnwers("False");
			}
		}
	}
	
	
	private static void multipleChoiceQuestion(String q, Student[] students)
	{
		//Set the multiple choice question
		question2.setQuestion(q);
		
		//Answer choices
		String answers[] = {"A", "B", "C", "D", "E"};
		
		//Randomly determine how many of the 5 choices are correct answers
		int howMany = rand.nextInt(5); 
		
		//with this loop, randomly choose which answers are correct 
		for (int i = 0 ; i <= howMany ; i++)
		{
			int randAns = rand.nextInt(5); 
			
			//Set question answers with an if statement for no duplicates
			if(!question2.getAnswer().contains(answers[randAns]))
			{
				question2.setAnswer(answers[randAns]);
			}
		}
		
		//generate answers for students for multiple choice question
		for (int i = 0 ; i < students.length; i++)
		{
			
			//Randomly determine how many answers this student will choose as the correct answer (1 through 5)
			int howManyAns = rand.nextInt(5);
			
			//with this loop, randomly choose which answers this student will choose
			for(int j = 0 ; j <= howManyAns ; j++)
			{
				int choice = rand.nextInt(5);
				
				//Set student answers with an if statement for no duplicates
				if(!students[i].getAnswers().contains(answers[choice]))
				{
					students[i].setAnwers(answers[choice]);
				}
			}		
			
			
		}
		
	}

}
