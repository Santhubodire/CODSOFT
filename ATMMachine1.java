import java.util.Scanner;
class ATM
{
	Account ac;
	ATM(Account ac)
	{
		this.ac=ac;
	}
	public void withdraw(double amount)
	{
		if (amount>0)
		{
			if (amount<=ac.balance)
			{
				ac.balance-=amount;
				System.out.println("\nTransaction Successful !\nYou have successfully withdrawn the amount : Rs."+amount);
			}
			else
			{
				System.out.println("\nTransaction failed !\nInsufficient Balance , cannot withdraw amount.");
				System.out.println("\nYour Current Balance Amount is : Rs."+ac.balance); 
			}
		}
		else
		{
			System.out.println("Transaction Failed !");
			System.out.println("The Amount should not be neagtive and Zero.So,enter positive number and not equal to zero.");
		}
	}
	public void deposit(double amount)
	{
		if (amount>0)
		{
			ac.balance+=amount;
			System.out.println("\nYou have successfully deposited the amount Rs.: "+amount);
		}
		else
		{
			System.out.println("The Amount should not be neagtive and Zero.So,enter positive number and not equal to zero.");
		}
	}
	public void checkBalance()
	{
		System.out.println("\n\t\t---> ACCOUNT DETAILS <---");
		System.out.println("-> Account Holder Name : "+ac.name);
		System.out.println("-> Your Current Balance Amount is : Rs."+ac.balance);
	}
}
class Account
{
	static Account acc_list[] = new Account[10];
	static int i =0;
	double balance;
	String name;
	Account(String name,double balance)
	{
		this.name=name;
		this.balance=balance;
	}
	public static Account fetchAccount(String nm)
	{
		for (Account ac : acc_list)
		{
			if (ac.name.equals(nm))
			{
				return ac;
			}
		}
		Account dup = new Account("NONAME",0);
		return dup;
	}
}
class ATMMachine1
{
	public static void main(String args[])
	{
		System.out.println("\n\t\t------------->>>> ATM MACHINE SYSTEM <<<<-------------\n");
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			System.out.println("\n\t ** OPTIONS MENU **\n");
			System.out.println("1.Add Account\n2.Deposit Money\n3.Withdraw Money\n4.Check Balance\n5.Exit\n");
			System.out.print("Enter corresponding number from menu to perform corresponding operation : ");
			int opt = sc.nextInt();
			if (opt==1)
			{
				System.out.println("\n\t--->> Creating Account <<--- \n");
				if (Account.i<10)
				{
					Account.i+=1;
					System.out.print("Enter the your Name : ");
					String name = sc.next();
					System.out.print("Enter the Initial Amount for Depositing : Rs.");
					double amount = sc.nextDouble();
					Account obj = new Account(name,amount);
					Account.acc_list[(Account.i)-1]=obj;
					System.out.println("Account Created Successfully with Name :"+name);
				}
				else
				{
					System.out.println("Maximum Number of Accounts Created.Cannot create more than 10 Accounts.");
				}
			}
			else if (opt==2)
			{
				if (Account.i!=0)
				{
					System.out.print("Enter the amount to be Deposited : Rs.");
					double amount = sc.nextDouble();
					System.out.print("Enter the Name of the Account Holder : ");
					String nm = sc.next();
					Account ac_obj = Account.fetchAccount(nm);
					ATM atm = new ATM(ac_obj);
					if (ac_obj.name.equals("NONAME"))
					{
						System.out.println("Account does not Exist.");
					}
					else
					{
						atm.deposit(amount);
					}
				}
				else
				{
					System.out.println("No Accounts are created till now.");
				}
			}
			else if (opt==3)
			{
				if (Account.i!=0)
				{
					System.out.print("Enter the amount to be Withdrawn : Rs.");
					double amount = sc.nextDouble();
					System.out.print("Enter the Name of the Account Holder : ");
					String name = sc.next();
					Account ac_obj = Account.fetchAccount(name);
					ATM atm = new ATM(ac_obj);
					if (ac_obj.name.equals("NONAME"))
					{
						System.out.println("Account does not Exist.");
					}
					else
					{
						atm.withdraw(amount);
					}
				}
				else
				{
					System.out.println("No Accounts are created till now.");
				}
			}
			else if (opt==4)
			{
				if (Account.i!=0)
				{
					System.out.print("Enter the Name of the Account Holder : ");
					String name = sc.next();
					Account ac_obj = Account.fetchAccount(name);
					ATM atm = new ATM(ac_obj);
					if (ac_obj.name.equals("NONAME"))
					{
						System.out.println("Account does not Exist.");
					}
					else
					{
						atm.checkBalance();
					}
				}
				else
				{
					System.out.println("No Accounts are created till now.");
				}
			}
			else if (opt==5)
			{
				System.out.println("Exiting the Program.... ");
				break;
			}
			else
			{
				System.out.println("You entered invalid Number.Please try again .");
			}
		}
	}
}