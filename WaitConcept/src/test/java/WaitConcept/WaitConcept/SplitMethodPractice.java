package WaitConcept.WaitConcept;

import java.util.Arrays;
import java.util.List;

public class SplitMethodPractice {

	public static void main(String[] args) {

		/*	String str="Hello Welcome to Akshara Academy. Use the password 'AksharaTraining' for Automation";
		String[]arr=str.split("'");
		String text=arr[1].split("'")[0];
		System.out.println(text);*/

		/*	String str="Use the Numbers 12321 for anything";
		String arr[]=str.split("1");
		String text=arr[1].split("1")[0];
		System.out.println(text); */

		String str="Use the Numbers 12321 for anything";
		String arr[]=str.split(" ");
		String text=arr[3];
		//	System.out.println(text);
		int sum=0;
		for(int i=0;i<text.length();i++) {
			char ch=text.charAt(i);
			int num=Character.getNumericValue(ch);
			sum=sum+num;

		}
		System.out.println(sum);
	}

}
