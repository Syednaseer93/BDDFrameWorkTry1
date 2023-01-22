package WaitConcept.WaitConcept;

class Enc2{

	private int x;
	public Enc2(int x){
		this.x=x;
	}
	public  void setter(String bx,int x) {
		if(bx.equalsIgnoreCase("naseer")) {
			this.x=x;
		}
		else {
			System.out.println("Unauthorized");
		}
	}
	public int getter(String bx) {

		if(bx.equalsIgnoreCase("Naseer")) {
			return x;
		}
		else {
			return 0;
		}	
	}
}
public class Enc {

	public static void main(String[] args) {
		Enc2 e=new Enc2(100);
e.setter("Naseer", 300);
	System.out.println(e.getter("Naseer"));


	}
}

