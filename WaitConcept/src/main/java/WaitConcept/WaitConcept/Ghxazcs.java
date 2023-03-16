package WaitConcept.WaitConcept;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ghxazcs {
	public static void main(String[] args) {
		int num = 8;
		int count = 0;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				count++;
			}
		}
		if (count > 0) {
			System.out.println("Number is not Prime");
		} else {
			System.out.println("Number is prime");
		}
	}
	
}
