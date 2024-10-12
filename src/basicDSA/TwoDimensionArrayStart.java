package basicDSA;

//8
public class TwoDimensionArrayStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [][] A= {{10,20,25,15,12},{19,18,13,28,101},{15,5,6,7,34},{9,94,38,10,28},{6,7,8,12,55}};

		int [] A= {4,2,2,5,1};
		System.out.println(getSubArrayOfFivenLengthAndSum_Improved(A, 4, 6));
	}
	
	public static boolean search(int [][] A , int k)
	{
		int i=0;
		int j=A[0].length-1;
		while(i<A.length && j>=0)
		{
			if(A[i][j]==k)
				return true;
			else if(A[i][j]>k)
				j--;
			else if(A[i][j]<k)
				i++;
		}
		return false;
	}
	
	/**
	 * Given a square Matrix
	 * @param A
	 */
	public static void printOuterMostBoundaryInClockWiseDirection(int [][]A)
	{
		int n=A.length;
		int i=0;
		int j=0;
		for (int k = 1; k <= n-1; k++) {
			System.out.println(A[i][j]);
			j++;
		}
		
		for (int k = 1; i <= n-1 ; k++) {
			System.out.println(A[i][j]);
			i++;
		}
		
		for (int k = 1; k <= n-1; k++) {
			System.out.println(A[i][j]);
			j--;
		}
		
		for (int k = 1; k <= n-1; k++) {
			System.out.println(A[i][j]);
			i--;
		}
	}
	
	public static void printSpiralBoundary(int [][] A)
	{
		 int n=A.length;
		 int i=0,j=0;
		 while(n>1)
		 {
			 for (int k = 1; k <= n-1; k++) {
				System.out.println(A[i][j]);
				j++;
			}
			 
			 for (int k = 1; k <= n-1; k++) {
				 System.out.println(A[i][j]);
				 i++;
			}
			 
			 for (int k = 1; k <= n-1; k++) {
				 System.out.println(A[i][j]);
				 j--;
			}
			 
			 for (int k = 1; k <= n-1; k++) {
				 System.out.println(A[i][j]);
				 i--;
			}
			 i++;j++;n=n-2;
		 }
		 if(n==1)
			 System.out.println(A[i][j]);
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
	
	public static int getSubArrayOfFivenLengthAndSum(int [] A, int B ,int C)
	{
		int [] pref=getPrefixSum(A);
		for(int s=0;s<A.length;s++)
		{
			int [] res=new int[B];
			for(int e=s;e<A.length;e++)
			{
				int sum=0;
				if(e-s+1==B)
				{
					if(s==0)
						sum=pref[e];
					else
						sum=pref[e]-pref[s-1];
					if(sum==C)
						return 1;
				}
				else if(e-s+1>B)
					break;
				else
					continue;
			}
		}
		return 0;
	}
	
	public static int getSubArrayOfFivenLengthAndSum_Improved(int [] A, int B ,int C)
	{
		int sum=0;
		for(int i=0;i<A.length;i++)
		{
			sum+=A[i];
			if(i>=B)
				sum-=A[i-B];
			if(sum==C && i>=B-1)
				return 1;
		}
		return 0;
	}

}
