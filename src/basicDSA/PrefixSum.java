package basicDSA;

import java.util.Arrays;

public class PrefixSum {

	public static void main(String[] args) {

		int [] arr= {1,2,3,4,5};
		int [][] Q= {{1,3}};
		//getRangeSumQuery(arr,Q);
		//int [] pref=getPrefixSum(arr);
		//System.out.println(Arrays.toString(pref));
		//int result=getEquilibriumIndex(arr);
		//System.out.println(result);
		
		/*
		 * int[] val1 = getPrefixSum(arr); int[] val2 = inPlacePrefixSum(arr);
		 * System.out.println(Arrays.toString(val1));
		 * System.out.println(Arrays.toString(val2));
		 */
		
		int [] ans=getProductArrayPuzzle(arr);
		System.out.println(Arrays.toString(ans));
		
	}
	
	public static int [] getPrefixSum(int[] A)
	{
		int [] pref=new int [A.length];
		pref[0]=A[0];
		for(int i=1;i<A.length;i++)
		{
		   pref[i]=pref[i-1]+A[i];	
		}
		return pref;
	}
	
	public static int [] inPlacePrefixSum(int [] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
			arr[i]+=arr[i-1];
		}
		return arr;
	}
	
	public static void getRangeSumQuery(int [] A , int [][] Q)
	{
		int [] pref=getPrefixSum(A);
		for(int i=0;i<Q.length;i++)
		{
			int L=Q[i][0];
			int R=Q[i][1];
			if(L>=A.length||R>=A.length)
				break;
			if(L==0)
				System.out.println(pref[R]);
			else
				System.out.println(pref[R]-pref[L-1]);
		}
	}
	
	public static int getEquilibriumIndex(int [] A)
	{
		int ls=0;int rs=0;
		int [] pref=getPrefixSum(A);
		for(int i=0;i<A.length;i++)
		{
			if(i==0)
				ls=0;
			else
			  ls=pref[i-1];
			rs=pref[A.length-1]-pref[i];
			if(ls==rs)
				return i;
		}
		return -1;
	}
	
	public static int[] getProductArrayPuzzle(int []A)
	{
		/*
		 * int productOfArrayElement=getProductOfArrayElement(A); int [] res=new
		 * int[A.length]; for(int i=0;i<A.length;i++) {
		 * res[i]=productOfArrayElement/A[i]; } return res;
		 */		
		int n=A.length;
		int [] proPrefix=new int[A.length];
		int [] proSuffix=new int[A.length];
		proPrefix[0]=A[0];
		proSuffix[n-1]=A[n-1];
		for(int i=1;i<n;i++)
		{
			proPrefix[i]=proPrefix[i-1]*A[i];
		}
		for(int i=n-2;i>0;i--)
		{
			proSuffix[i]=proSuffix[i+1]*A[i];
		}
		int [] res=new int[n];
		for (int i = 0; i < res.length; i++) {
			if(i==0)
				res[i]=proSuffix[i+1];
			else if(i==n-1)
			    res[i]=proPrefix[i-1];
			else
				res[i]=proPrefix[i-1]*proSuffix[i+1];
			
		}
		return res;
	}
	
	public static int getProductOfArrayElement(int [] A)
	{
		int pro=1;
		for(int i=0;i<A.length;i++)
		{
			pro=pro*A[i];
		}
		return pro;
	}

}
