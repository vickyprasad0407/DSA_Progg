package basicDSA;

import java.util.Arrays;

public class ArraySumBy2DAsInteger {

	public static void main(String[] args) {
		int [] A= {2,2,2};
		int [][] B= {{0,0},{1,2}};
		int [] result=getSum(A,B);
		System.out.println(Arrays.toString(result));
	}
	
	public static int [] getSum(int [] A , int [][] B )
	{
		int [] result=new int [B.length];
		
		for(int i=0;i<B.length;i++)
		{
			int sum=0;
			for(int j=B[i][0];j<=B[i][1];j++)
			{
				sum+=A[j];
			}
			result[i]=sum;
		}
		return result;
	}
}
