package TD3_Complexité;

public class SommeDeN {
	
	static int sum;
	static int x;
		
	public static int addNum (int arr[], int n){
         if(n > arr.length){
             return 0;
         }
         else if(n == 1){
             return arr[0];
         }
         else{
        	 n = arr[n-1] + addNum(arr, n-1);
            return n;
         }

       }
      
}

