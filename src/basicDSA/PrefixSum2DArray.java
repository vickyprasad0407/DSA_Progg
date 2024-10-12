package basicDSA;

public class PrefixSum2DArray {

	public static void main(String[] args) {

		int [][] A= {{1,2},{4,4}};
		int [][] Q= {{1,2,2,4}};
		System.out.println(getSearched(A,3));
		//getSumOfAllQueries2Doptimised1(A, Q);
//		int[][] pref = getPrefixSum2D(A);
//
//		for (int i = 0; i < pref.length; i++) {getSumOfAllSubMatrixSum 
//			for (int j = 0; j < pref[0].length; j++) {
//				System.out.print(pref[i][j]+" ");
//			}
//			System.out.println();
//		}
	}
	
	public static int [][] getPrefixSum2D(int [][] A)
	{
		int [][] pref=new int [A.length][A[0].length];
		for(int i=0;i<pref.length;i++)
		{
			for(int j=0;j<pref[0].length;j++)
			{
				if(j==0)
			    pref[i][j]=A[i][j];
				else
					pref[i][j]=pref[i][j-1]+A[i][j];
			}
		}
		
		for(int i=1;i<pref.length;i++)
		{
			for(int j=0;j<pref[0].length;j++)
			{
					pref[i][j]=pref[i-1][j]+pref[i][j];
			}
		}
		return pref;
	}
	
	public static void getSumOfAllQueries2D(int [][] A, int [][] Q)
	{
		for(int k=0;k<Q.length;k++)
		{
		    int x1=Q[k][0];
		    int y1=Q[k][1];
		    int x2=Q[k][2];
		    int y2=Q[k][3];
		    int sum=0;
		    for(int i=x1;i<=x2;i++)
		    {
		    	for(int j=y1;j<=y2;j++)
		    	{
		    		sum+=A[i][j];
		    	}
		    }
		    System.out.println(sum);
		    
		}
	}
	
	public static void getSumOfAllQueries2Doptimised1(int [][] A, int [][] Q)
	{
		int [][] ps=getPrefixSum2D(A);
		for(int k=0;k<Q.length;k++)
		{
			int x1=Q[k][0];
			int y1=Q[k][1];
			int x2=Q[k][2];
			int y2=Q[k][3];
			int sum=0;
			sum+=ps[x2][y2];
			if(x1>0)
				sum-=ps[x1-1][y2];
			if(y1>0)
				sum-=ps[x2][y1-1];
			if(x1>0 && y1>0)
				sum+=ps[x1-1][y1-1];
			
			System.out.println(sum);
		}
	}
	
	public static int getMaxSubmatrixSumForRowSortedColumnSorted(int [][] A)
	{
		int [][] ps=getPrefixSum2D(A);
		int ans=Integer.MIN_VALUE;
		int n=A.length;
		int m=A[0].length;
		int x2=n-1;
		int y2=m-1;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				int x1=i;
				int y1=j;
				int sum=0;
				sum+=ps[x2][y2];
				if(x1>0)
					sum-=ps[x1-1][y2];
				if(y1>0)
					sum-=ps[x2][y1-1];
				if(x1>0 && y1>0)
					sum+=ps[x1-1][y1-1];				
				if(sum>ans)
					ans=sum;
			}
		}
		return ans;
	}
	
	public static int getSumOfAllSubMatrixSum(int [][] A)
	{
		int n=A.length;
		int m=A[0].length;
		int sum=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				int freq=(i+1)*(j+1)*(n-i)*(m-j);
				sum+=freq*A[i][j];
			}
		}
		return sum;
	}
	/**
	 * Last Question of 9 lecture
	 * @param A
	 * @param B
	 * @return
	 */
	public static int getSearched(int [][] A , int B)
	{
		int n=A.length;
		int m=A[0].length;
		int i=0,j=m-1;
		int ans=-1;
		while(i<n && j>=0)
		{
			int val=0;
			if(A[i][j]==B)
			{
				ans= (i+1)*1009+(j+1);
				j--;
			}
			else if(A[i][j]>B)
				j--;
			else if(A[i][j]<B)
				i++;
		}
		return ans;
	}

}
