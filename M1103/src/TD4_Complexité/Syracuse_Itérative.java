package TD4_Complexit�;

public class Syracuse_It�rative {
	
	public static int SyracuseIt�(int n) {
		
		if(n==1) return (1);
		
		if (n%2==0) n=n/2;
		
		else n=3*n+1;
		
		return n;
	}

}
