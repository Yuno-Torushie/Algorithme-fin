package TD4_Complexit�;

public class Syracuse_R�cursive {
	
	public static int SyracuseRec(int n) {
		
		if(n==1) return (1);
		
		if (n%2==0) return(n/2);
		
		else return(3*n+1);
		
	}
}
