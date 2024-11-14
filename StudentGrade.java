// -------------------->>> STUDENT GRADE CALCULTOR <<--------------
import java.util.Scanner;
class StudentMarks
{
	int total_marks;
	int avg_percent;
	int total_sub;
	StudentMarks(int[] marks,int n)
	{
		total_sub=n;
		for(int m : marks)
		{
			total_marks+=m;
		}
	}
	public double avgPercent()
	{
		avg_percent=((total_marks/total_sub));
		return avg_percent;
	}
	public char grade()
	{
		if (90<avgPercent() && avgPercent()<=100)
		{
			return 'A';
		}
		else if (80<avgPercent() && avgPercent()<=90)
		{
			return 'B';
		}
		else if (70<avgPercent() && avgPercent()<=80)
		{
			return 'C';
		}
		else if (60<avgPercent() && avgPercent()<=70)
		{
			return 'D';
		}
		else if (50<avgPercent() && avgPercent()<=60)
		{
			return 'E';
		}
		else
		{
			return 'F';
		}
	}
	public void displayResults()
	{
		System.out.println("\n\t------->> YOUR SCORE <<-------\n");
		System.out.println("-> Total No. of Subjects are :- "+total_sub);
		System.out.println("-> Total No. of Marks obtained are :- "+total_marks);
		System.out.println("-> The Average Percentage obtained is :- "+avgPercent()+"%");
		System.out.println("-> By Analysis Grade obtained by the Student is :- "+grade());
	}
}
class StudentGrade
{
	public static void main(String args[])
	{
		System.out.println("\n\t\t----->> Student Grade calculator <<-----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the No. of Subjects : ");
		int subs = sc.nextInt();
		int marks[] = new int[subs];
		for (int i=0;i<subs;i++)
		{
			System.out.print("Enter the Marks(out of 100) obtained in Subject-"+(i+1)+":");
			int m = sc.nextInt();
			if (m<=100 && m>=0)
			{
				marks[i]=m;
			}
			else
			{
				System.out.println("You have entered marks above 100 or below hundered.So,please entere between 0 and 100.");
				i-=1;
			}
		}
		StudentMarks obj = new StudentMarks(marks,subs);
		obj.displayResults();
	}
}