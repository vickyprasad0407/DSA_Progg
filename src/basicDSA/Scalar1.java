package basicDSA;

//Online Java Compiler
//Use this editor to write, compile and run your Java code online
import java.util.*;
public class Scalar1 {
public static void main(String[] args) {
   System.out.println(getCountFact(100));
   System.out.println(isPrime(11));
   int [] arr={1,2,3,4,5,6,7,8,9};
   //getReversed(arr);
   //System.out.println(Arrays.toString(arr));
   //getPartReversed(arr, 1, 3);
   //System.out.println(Arrays.toString(arr));
   getRotatedFromFirst(arr,4);
   System.out.println(Arrays.toString(arr));
}

public static int getCountFact(int n)
{
 int count=0;
   for(int i=1 ; i<=Math.sqrt(n) ; i++)
   {
      if(n%i==0)
      {
         if(i==n/i)
         {
         count++;
         }
         else
         {
         count+=2;
         }
      }
      
   }
   return count;
}

public static boolean isPrime(int n)
{
    if(n==1)
    return true;
   int count=getCountFact(n);
   if(count==2)
    return true;
    else
    return false;
}

public static void getReversed(int [] arr)
{
 int a=0;
 int b=arr.length-1;
 while(a<b)
 {
   int temp=arr[a];
   arr[a]=arr[b];
   arr[b]=temp;
   a++;b--;
 }
}

public static void getPartReversed(int [] arr, int s , int l)
{
 while(s<l)
 {
   int temp=arr[s];
   arr[s]=arr[l];
   arr[l]=temp;
   s++;l--;
 }
}

public static void getRotatedFromLast(int [] arr , int k)
{
  int size=arr.length;
  k=k%size;
  System.out.println(size+"......"+k);
  getReversed(arr);
  getPartReversed(arr,0,k-1);
  getPartReversed(arr,k,size-1);
}

public static void getRotatedFromFirst(int [] arr , int k)
{
   int size=arr.length;
   k=k%size;
   getPartReversed(arr,0,k-1);
   getPartReversed(arr,k,size-1);
   getReversed(arr);
}


}
