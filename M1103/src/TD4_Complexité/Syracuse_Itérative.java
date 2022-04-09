package TD4_Complexité;

public class Syracuse_Itérative {
	
	public static int SyracuseIté(int n) {
		
		if(n==1) return (1);
		
		if (n%2==0) n=n/2;
		
		else n=3*n+1;
		
		return n;
	}

}
