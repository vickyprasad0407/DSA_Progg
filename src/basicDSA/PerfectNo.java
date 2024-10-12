package basicDSA;

public class PerfectNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int n=128;
	  int sum=0;
      for(int i=1;i<=Math.sqrt(n);i++)
      {
    	  if(n%i==0)
    	  {
    		  if(i==n/i)
    			  sum+=i;
    		  else
    			  sum=sum+i+n/i;
    	  }
      }
      if(sum-n==n)
    	  System.out.println("perfect no");
      else
    	  System.out.println("Not a perfect no");
	}

}
