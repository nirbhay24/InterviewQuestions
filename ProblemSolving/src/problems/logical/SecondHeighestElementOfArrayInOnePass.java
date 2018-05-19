package problems.logical;

public class SecondHeighestElementOfArrayInOnePass {

	public static void main(String[] args) {
		int[] a = {1,342,42,5,131,534,86,623,3,65,313,5,6,23,131,55,43,2,3,56};
		System.out.println(secondLargest(a));
 
	}

	private static int secondLargest(int[] a) {
		int max=Integer.MIN_VALUE;
		int max2=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>max)
			{
				max2= max;
				max=a[i];
			}
			else if(a[i]>max2)
			{
				max2=a[i];				
			}
		}		
		return max2;
	}

}
