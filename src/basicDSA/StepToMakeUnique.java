package basicDSA;

import java.util.Arrays;

public class StepToMakeUnique {
 
	public static void main(String[] args) {
		int [] arr= {2,4,5};
		Arrays.sort(arr);
		int count=0;
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]==arr[i+1])
			{
				count++;
				arr[i+1]+=1;
			}
		}
        System.out.println(count);
	}
}
