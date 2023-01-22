package WaitConcept.WaitConcept;

import java.util.HashMap;
import java.util.Map;

public class Arradgd {

	public static void main(String[] args) {
		String str="aabbcccdddd";
		HashMap<Character,Integer> hm=new HashMap<>();
		char[]arr=str.toCharArray();
		for(char ch:arr) {
			if(hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch)+1);
			}
			else {
				hm.put(ch, 1);
			}
		}
		int maxCount=0;
		char maxChar=' ';
		for(Map.Entry<Character,Integer> me:hm.entrySet()) {
			if(maxCount<me.getValue()) {
				maxCount=me.getValue();
				maxChar=me.getKey();
			}
		}
		System.out.println(maxCount);
		System.out.println(maxChar);
	}
}


