package WaitConcept.WaitConcept;

public class Demo1_Mock1 {

	public static void main(String[] args) {
		String s="page 23 of 100";
		String s1="";
		int len = s.length();
		for(int i=0;i<len;i++) {
			char v = s.charAt(i);
			if(v>='0' && v<='9') {

				System.out.println(v);
			}

		}
	}
}
