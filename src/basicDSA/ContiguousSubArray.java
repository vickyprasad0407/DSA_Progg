package basicDSA;

import java.util.Arrays;

public class ContiguousSubArray {

	public static void main(String[] args) {

		int [] A= {1,2,1,4};
		int [][] Q= {{2,3,2},{1,4,5},{4,4,1}};
		int [] pm=getBeggerTotalAmount(A,Q);
		//int [] sm=getSuffixMax(A);
		System.out.println(Arrays.toString(pm));
	}
	
	/**
	 * Brute Force technique
	 * Special Case if all the element are 0 and 
	 * @param A
	 * @param Q
	 * @return
	 */
	public static int[] getContigous(int [] A , int [][] Q)
	{
		
		for(int i=0; i<Q.length;i++)
		{
			int L=Q[i][0];
			int R=Q[i][1];
			int val=Q[i][2];
			for(int j=L;j<=R;j++)
			{
				A[j]+=val;
			}
		}
		return A;
	}
	
	public static int[] getContigousOptimized(int [] A, int [][] Q)
	{
		for(int i=0;i<Q.length;i++)
		{
			int L=Q[i][0];
			int R=Q[i][1];
			int Val=Q[i][2];
			A[L]+=Val;
			if((R+1)<A.length)
			    A[R+1]+=-Val;
		}
		return getPrefixSum(A);
	}
	
	public static int [] getPrefixSum(int [] A)
	{
		int [] pref=new int[A.length];
		pref[0]=A[0];
		for(int i=1;i<A.length;i++)
		{
			pref[i]=pref[i-1]+A[i];
		}
		return pref;
	}
	
	public static int [] getPrefixMax(int [] A)
	{
		int [] pm=new int[A.length];
		pm[0]=A[0];
		 for(int i=1;i<A.length;i++)
		 {
			 pm[i]=Math.max(pm[i-1], A[i]); 
		 }
		 return pm;
	}
	
	public static int [] getSuffixMax(int [] A)
	{
		int [] sm=new int[A.length];
		sm[A.length-1]=A[A.length-1];
		for(int i=A.length-2;i>=0;i--)
		{
			sm[i]=Math.max(sm[i+1], A[i]);
		}
		return sm;
	}
	
	public static int rainWaterTrapping(int [] A)
	{
		int [] l=getPrefixMax(A);
		int [] r=getSuffixMax(A);
		int amount=0;
		for(int i=1;i<A.length-1;i++)
		{
			int unit=Math.min(l[i-1], r[i+1])-A[i];
			if(unit>0)
				amount+=unit;
		}
		return amount;
	}
	
	/**
	 * Kadan's Alogrithgum
	 * @param A
	 * @return
	 */
	public static int maxSumSubArray(int [] A)
	{
		int sum=0;
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<A.length;i++)
		{
			if(sum>0)
				sum+=A[i];
			else
				sum=A[i];
			if(sum>ans)
				ans=sum;
		}
		return ans;
	}
	
	public static int [] getBeggerTotalAmount(int [] arr,int [][] B)
	{
		//int [] arr=new int[N];
		for(int i=0;i<B.length;i++)
		{
			int L=B[i][0]-1;
			int R=B[i][1]-1;
			int amt=B[i][2];
			
			arr[L]+=amt;
			if((R+1)<arr.length)
			 arr[R+1]+=-amt;
		}
		System.out.println(Arrays.toString(arr));
		arr=getPrefixSum(arr);
		return arr;
	}

}
