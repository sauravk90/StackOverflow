package testScripts;

interface Mobile
{
	void call();
	void message();
}

class BlackDuck implements Mobile
{
	public void call()
	{
		System.out.println("Calling");
	}

	public void message()
	{
		System.out.println("Messaging");
	}
}

public class Tutorial
{
	public static void main(String args[])
	{
		BlackDuck obj=new BlackDuck();
		obj.call();
		obj.message();
	}
}

