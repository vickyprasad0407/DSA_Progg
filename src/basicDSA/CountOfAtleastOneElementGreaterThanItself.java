package basicDSA;

public class CountOfAtleastOneElementGreaterThanItself {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr= {1,3,4};
		System.out.println(getCountOfAtleastOneMax(arr));
	}
	
	public static int getCountOfAtleastOneMax(int [] arr)
	{
		int max=arr[0];
		int count=0;
		for(int i=0;i<arr.length;i++)
		{ 
			if(max<arr[i])
			{
				max=arr[i];
				
			}
			else
			{
				count++;
			}
		}
		
		return count;
	}

}
