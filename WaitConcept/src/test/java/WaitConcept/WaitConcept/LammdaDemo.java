package WaitConcept.WaitConcept;

import java.util.Arrays;
import java.util.List;

interface Cab{
	void bookCab(String source,String destination);
}

public class LammdaDemo {

	public static void main(String[] args) {
		String arr[]= {"Eameer","Ali","Dadu","Basha","Chinki"};
		List<String>list=Arrays.asList(arr);
		list.stream().sorted().forEach(s->System.out.println(s));
	}
}



