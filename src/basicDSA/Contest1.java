package basicDSA;

import java.util.Arrays;

//6

public class Contest1 {

	public static void main(String[] args) {
        char [] A= {'a','m','a','t','e','u','r','s','h','i','p'};
        int [][] B= {{0,3},{4,8},{5,5},{3,9}};
        int []ans=getCountOfVowelInRange(A , B);
        //System.out.println(ans);
        System.out.println(Arrays.toString(ans));
	}
	/**
	 * This method is used to return max Size Sub-Array with only non-negative element
	 * @param A
	 * @return
	 */
	public static int [] getMaxSize(int [] A)
	{
		int sp=-1 ; int msp=-1;
		int len=0; int mlen=0;
		
		for(int i=0 ;i<A.length;i++)
		{
			if(A[i]>=0)
			{
				if(len==0)
				   sp=i;
				len++;
			}
			else
			{
				sp=-1;
				len=0;
			}
			if(len>mlen)
			{
				msp=sp;
				mlen=len;
			}
		}
		int [] res=new int [mlen];
		int k=0;
		for(int i=msp;i<msp+mlen;i++)
		{
			res[k]=A[i];
			k++;
		}
		
		return res;
	}
	
	/**
	 * Given an Array , in one operation we can make ele=-1
	 * Min no of operation required to make B the max of Array
	 * @param A
	 * @param B
	 * @return
	 */
	public static int getMinimumStep(int [] A , int B)
	{
		boolean temp=false;
		int step=0;
		for (int i = 0; i < A.length; i++) {
			if(A[i]>B)
			{
				A[i]=-1;
				step++;
			}
			else if(A[i]==B)
				temp=true;
		}
		if(temp==false)
			return -1;
		else 
		   return step;
	}
	
	public static int[] getCountOfVowelInRange(char [] A , int [][] B)
	{
		int [] prefCount=getPrefVowelCount(A);
		int [] count=new int [B.length];
		
		for(int i=0 ;i<B.length ;i++)
		{
			int L=B[i][0];
			int R=B[i][1];
			if(L==0)
				count[i]=prefCount[R];
			else
				count[i]=prefCount[R]-prefCount[L-1];
		}
		
		return count;
	}
    
	public static int [] getPrefVowelCount(char []A)
	{
		int [] prefCount=new int[A.length];
		int count=0;
		char ch=A[0];
		if(ch=='a' || ch=='e' || ch=='i'|| ch=='o' || ch=='u')
			prefCount[0]=1;
		else
			prefCount[0]=0;
		for (int i = 1; i < prefCount.length; i++) {
			int temp=0;
			ch=A[i];
			if(ch=='a' || ch=='e' || ch=='i'|| ch=='o' || ch=='u')
			  temp=1;
			prefCount[i]=prefCount[i-1]+temp;
		}
		return prefCount;
	}
}
