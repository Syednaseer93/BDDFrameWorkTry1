package WaitConcept.WaitConcept;

public class Encapsulation {

	private int a;
	private int b;

	public void setSum(int a,int b,String user) {
		if(user.equals("Naseer")) {
			this.a=a;
			this.b=b;	 
		}
	}
	public int getSum() {	
		return a+b;
	}
	public static void main(String[] args) {
		Encapsulation e=new Encapsulation();
		e.setSum(10, 20,"Naseer");
		System.out.println(e.getSum());
	}
}
