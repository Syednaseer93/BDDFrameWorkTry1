package WaitConcept.WaitConcept;

import java.util.HashMap;
import java.util.Map;

public class Demo {

	public static void main(String[] args) {

		String str = "naaseeeeerrr";
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch) + 1);
			} else {
				hm.put(ch, 1);
			}
		}
		int maxCount = 0;
		char maxChar = ' ';
		/*
		 * for(Map.Entry<Character, Integer> me :hm.entrySet()) {
		 * if(maxCount<me.getValue()) { maxCount=me.getValue(); maxChar=me.getKey(); } }
		 */
		// System.out.println(maxCount+" "+maxChar);
		System.out.println(hm);
	}

}
