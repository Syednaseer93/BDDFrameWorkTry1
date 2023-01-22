package WaitConcept.WaitConcept;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsArrayList {

	public static void main(String[] args) {
	 List<String> list=new ArrayList<String>();
	 list.add("Junaid");
	 list.add("Hamdan");
	 list.add("Jaffer");
	 list.add("Sidra");
	 
	 Long var=list.stream().filter(s->s.endsWith("r")).count();
	 System.out.println(var);
	
	
	}

}
