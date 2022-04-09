	package TD3_Complexité;

public class BoolPair {
	
	static int x = 0;

	public static int parité(int n) {
	    
	    if(n == 0){
	        x = 1;
	    }
	    else if(n == 1){
	        x = 0;
	    }
	    else{
	        x = parité(n - 2);
	    }
	    return n;
	    
	}
}
