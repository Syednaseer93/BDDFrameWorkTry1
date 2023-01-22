package WaitConcept.WaitConcept;

public class Demo2_Mock1 {

	public static void main(String[] args) {

		String rev="";
		String orgStr="ABC";

		int len = orgStr.length();
		for(int i=len-1;i>=0;i--) {
			rev=rev+orgStr.charAt(i);
		}
		if(orgStr.equalsIgnoreCase(rev)) {
			System.out.println("the Orignal String is "+orgStr);
			System.out.println("The Reverse String is "+rev);
			System.out.println("Both are matched");
		}
		else {
			System.out.println("Not Matched");
		} 
	}

}
