	package TD3_Complexit�;

public class BoolPair {
	
	static int x = 0;

	public static int parit�(int n) {
	    
	    if(n == 0){
	        x = 1;
	    }
	    else if(n == 1){
	        x = 0;
	    }
	    else{
	        x = parit�(n - 2);
	    }
	    return n;
	    
	}
}
