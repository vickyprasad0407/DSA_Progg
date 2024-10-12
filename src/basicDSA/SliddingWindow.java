package basicDSA;

//8
public class SliddingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] A= {3,9,4,-2,5,13,-7,8};
		int k=4;
		System.out.println(maxSumSubArray3(A,k));

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
	
	public static int maxSumSubArray1(int [] A , int k)
	{
	    int s=0;
	    int e=k-1;
	    int ans=Integer.MIN_VALUE;
	    while(e<A.length)
	    {
	    	int sum=0;
	    	for(int i=s;i<=e;i++)
	    	{
	    		sum+=A[i];
	    	}
	    	if(sum>ans)
	    		ans=sum;
	    	s++;
	    	e++;
	    }
	    return ans;
	}
	
	public static int maxSumSubArray2(int [] A,int k)
	{
		int s=0;
		int e=k-1;
		int ans=Integer.MIN_VALUE;
		int [] pref=getPrefixSum(A);
		while(e<A.length)
		{
			int sum=0;
			if(s==0)
				sum=pref[e];
			else 
				sum=pref[e]-pref[s-1];
			if(sum>ans)
				ans=sum;
			
			s++;
			e++;
		}
		return ans;
	}
	
	/**
	 * Slidding Window i.e. most optimized way.
	 * @param A
	 * @param k
	 * @return
	 */
	public static int maxSumSubArray3(int [] A, int k)
	{
		int sum=0;
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<k;i++)
		{
			sum+=A[i];
		}
		ans=sum;
		int s=1;
		int e=k;
		while(e<A.length)
		{
			sum=sum-A[s-1]+A[k];
			if(sum>ans)
				ans=sum;
			s++;
			e++;
		}
		return ans;
	}

}
