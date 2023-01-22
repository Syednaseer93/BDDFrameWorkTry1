package WaitConcept.WaitConcept;

public class Demo3_Mock1 {

	public static void main(String[] args) {
		String str="Page 23 of 10111";
		int sum=0;
		int length = str.length();

		for(int i=0;i<length;i++) {
			int var = str.charAt(i);
			if(var>='0' && var<='9') {
				int n=var-48;
				sum=sum+n;
			}
		}
		System.out.println(sum);
	}
}
