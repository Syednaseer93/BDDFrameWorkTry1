package WaitConcept.WaitConcept;

public class VarArgs {

	String[] setMultipleData(String... values) {
		return values;
	}
	
	public static void main(String[] args) {
		VarArgs v=new VarArgs();
	String[] str=	v.setMultipleData("Naseer");
	for(String val:str) {
		System.out.print(val+ " ");
	}
		
	}

}
