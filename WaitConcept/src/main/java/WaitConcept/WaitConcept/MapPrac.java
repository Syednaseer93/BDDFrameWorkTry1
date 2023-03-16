package WaitConcept.WaitConcept;

import java.util.Arrays;

public class MapPrac {
	public static void main(String[] args) {
		int [] arr = {4,3,2,5,1,6};
		int temp=0;
		for(int i=0;i<=arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<arr[j]) 
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(arr[1]);
	
	}
}
