package basicDSA;

public class BitSetAndSubSeqence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A= {3,5,10};
		System.out.println(sumOfDifference(A));

	}
	
	public static boolean checkBit(long n , int i)
	{
		if((n&(1<<i))==0)
			return false;
		else
			return true;
	}
	
	public static int countBit1(int n)
	{
		int count=0;
		while(n>0)
		{
			int rem=n%2;
			if(rem==1)
				count++;
			n=n/2;	
		}
		return count;
	}
	
	public static int countBit2(int n)
	{
		int count=0;
		for(int i=0;i<=31;i++)
		{
			if(checkBit(n, i)==true)
				count++;
		}
		return count;
	}
	
	public static int unSetIthBit(int A, int B)
	{
		int n=1<<B;
		if((A&n)>0)
			A-=n;
	   return A;
	}
	
	public static int toggledTheItheBit(int A , int B)
	{
		return A^(1<<B);
	}

	public static long reverseBit(long A)
	{
		long rev=0 ;
		for(int i=0;i<32;i++)
		{
			if(checkBit(A, i)==true)
			{
			int k=32-i-1;
			rev=rev|(1L<<k);
			}
		}
		return rev;
	}
	
	public static boolean subSetSum(int [] A , int k)
	{
		int n=A.length;
		int tcs=(int)Math.pow(2, n);
		for(int i=0;i<tcs;i++)
		{
			int sum=0;
			for(int j=0;j<n;j++)
			{
				if(checkBit(i, j)==true)
					sum+=A[j];
			}
			if(sum==k)
				return true;
		}
		return false;
	}
	
	public static long sumOfDifference(int [] A)
	{
		int n=A.length;
		int tcs=(int)Math.pow(2,n);
		long mod=10000000007l;
		long sum=0;
		for(int i=0;i<tcs;i++)
		{
			for(int j=0;j<n;j++)
			{
				long big=A[0]%mod;
				long small=A[0]%mod;
				if(checkBit(i, j)==true)
				{
					if(big<A[j]%mod)
						big=A[j];
					if(small>A[j]%mod)
						small=A[j];
					sum=(sum+big-small);
				}
			}
		}
		return sum;
	}
}
