package io.nm.lambdas;

public class Greeter 
{
	public void greet(Greeting greeting)
	{
		greeting.perform();
	}
	
	public static void main(String[] args) 
	{
		Greeter greeter = new Greeter();

		System.out.println("+++++++++With Class Level Implementation ++++++++++");
		Greeting greeting = new HelloWorldGreeting();
		greeter.greet(greeting);
		
		System.out.println();
		System.out.println("################With Lambda Expression##############");
		Greeting messageToGreet = () -> System.out.println("Hello Lambda");
		greeter.greet(messageToGreet);
		
		//TYPE INFERENCE EXAMPLE
		greeter.greet(()-> System.out.println("No Worries"));
		
		printLambda((s,r) -> s.length() + r.length());
		
		
		//Backward Compatibility with RUNNABLE interface, major reason why lambda were not given any new Functional Type.
		Thread thread = new Thread(() -> System.out.println("Thread is running"));
		thread.start();
		
	}
	
	public static void printLambda(StringLambda def)
	{
		System.out.println(def.lengthCalc("Hello Lambda", "abc"));
	}
	
}

interface StringLambda
{
	public int lengthCalc(String s, String b);
}
