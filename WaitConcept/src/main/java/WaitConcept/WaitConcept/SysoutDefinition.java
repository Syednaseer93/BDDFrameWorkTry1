package WaitConcept.WaitConcept;
//System: It is a final class defined in the java.lang package.
//out: This is an instance of PrintStream type, which is a public and static member field of the System class.
//println(): As all instances of PrintStream class have a public method println(),
//hence we can invoke the same on out as well. 
//It prints any argument passed to it and adds a new line to the output. We can assume that System.out represents the Standard Output Stream.



class CoffeeMachine {
	static Expresso e=new Expresso();
}
class Expresso{
	void makeCoffee() {
		System.out.println("Make coffee");
		
	}
}

public class SysoutDefinition {
	public static void main(String[] args) {
		CoffeeMachine.e.makeCoffee();
	}
}