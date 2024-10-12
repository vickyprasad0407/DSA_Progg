package basicDSA;

public class PerfectSquare {

	public static void main(String[] args) {

		int A=0;
		int result=getPerfectSqare(A);
		if(result==-1)
			System.out.println("Not a perfect Square");
		else
			System.out.println("Perfect square is "+result);
	}
	
	public static int getPerfectSqare(int n)
	{
		int result=-1;
		if(n<0) 
			n=n*-1;
		if(n==1)
			return 1;
		if(n==0)
			return 0;
		for(int i=2;i*i<=n;i++)
		{
			if(i*i==n)
				return i;
		}
		return -1;
	}

}
