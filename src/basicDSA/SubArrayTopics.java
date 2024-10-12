package basicDSA;

public class SubArrayTopics {

	public static void main(String[] args) {
		int [] A= {1,2,3};
		getTotalSumOfAllTheSubArray2(A);

	}
	 
	public static int [] getPrefixSum(int [] A)
	{
		int[] prefSum=new int[A.length];
		prefSum[0]=A[0];
		for (int i = 1; i < prefSum.length; i++) {
			prefSum[i]=prefSum[i-1]+A[i];
		}
		return prefSum;
	}
	
	public static void getSubArray1(int [] A)
	{
		for (int s = 0; s < A.length; s++) {
			for (int e=s; e< A.length; e++) {
              for(int k=s;k<=e;k++)
              {
            	  System.out.print(A[k]+" ");
              }
              System.out.println();
			}
		}
	}
	
	public static void getPrintSumOfEverySubArray1(int [] A)
	{
		 for (int s = 0; s < A.length; s++) {
			for (int e = s; e < A.length; e++) {
				int sum=0;
				for (int k = s; k <=e; k++) {
					sum+=A[k];
				}
				System.out.println(sum);
			}
		}
	}
	
	public static void getPrintSumOfEverySubArray2(int [] A)
	{
		int [] pref=getPrefixSum(A);
		for(int s=0;s<A.length;s++)
		{
			for(int e=s;e<A.length;e++)
			{
				if(s==0)
				   System.out.println(pref[e]);
				else
					System.out.println(pref[e]-pref[s-1]);
			}
		}
	}
	
	public static void getPrintSumOfEverySubArray3(int [] A)
	{
		int n=A.length;
		for(int s=0;s<n;s++)
		{
			int sum=0;
			for(int e=s;e<n;e++)
			{
				sum+=A[e];
				System.out.println(sum);
			}
		}
	}
	
	public static void getTotalSumOfAllTheSubArray(int [] A)
	{
		int n=A.length;
		int ts=0;
		for(int s=0;s<n;s++)
			
		{
			int sum=0;
			for(int e=s;e<n;e++)
			{
				sum+=A[e];
				ts+=sum;
			}
			
		}
		System.out.println(ts);
	}
	
	public static void getTotalSumOfAllTheSubArray2(int [] A)
	{
		int n=A.length;
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum+=A[i]*(i+1)*(n-i);
		}
		System.out.println(sum);
	}

}
