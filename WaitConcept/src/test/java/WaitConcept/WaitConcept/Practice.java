package WaitConcept.WaitConcept;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

		
		int countChar=0;
		int countDigit=0;	
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the String");
		String str = s.nextLine();
		for(int i=0;i<str.length();i++) {
		
			char ch = str.charAt(i);
			if(Character.isDigit(ch)) {
				countDigit++;
			}
			else if(Character.isAlphabetic(ch)) {
				countChar++;				
			}
		}
		if(countDigit>8) {
			System.out.println("Invalid number of digits");
		}
		else if(countChar>10){
			System.out.println("Invalid number of characters");
		}

	}

}
