//---------------->>>>>>>>NUMBER GAME <<<<<<<<<<<<<----------------
import java.util.*;
class NumberGame
{
	int rounds=0;
	int attempts;
	int num;
	int i;
	int best=102;
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();	
	NumberGame()
	{
		num = rand.nextInt(101)+1;
		rounds=1;
	}
	public void start()
	{
		System.out.println("\n<<---------Number Game----------->>\n\n");
		System.out.println("--------->>> ROUND -"+rounds+" ------->>>");
		attempts=0;
		num = rand.nextInt(101)+1;
		while (true)
		{
			System.out.print("Enter the guess between 1 and 100 : ");
			attempts+=1;
			int guess = sc.nextInt();
			if (guess==num)
			{
				System.out.println("Hurrah!,you got it .\n");
				System.out.println("\n\t***Your Score***");
				System.out.println("-> No. of attempts made are : "+attempts);
				if (attempts<best)
				{
					best=attempts;
				}
				break;
			}
			else if (guess<num)
			{
				System.out.println("The guess is low.");
			}
			else
			{
				System.out.println("The guess is High.");
			}
		}
		System.out.print("Enter '1' for attempting another round or Enter any number except '1' for exiting the program: ");
		int ro = sc.nextInt();
		if (ro==1)
		{
			rounds+=1;
			start();
		}
		else
		{
			System.out.println("\t****Overall Score****");
			System.out.println("-> Total number of rounds played are : "+rounds);
			System.out.println("-> The Best score from all rounds is : "+best);
			System.out.println("-> Exiting the program...");
			
		}
	}
}
class GameOn
{
	public static void main(String args[])
	{
		NumberGame obj = new NumberGame();
		obj.start();
	}
}