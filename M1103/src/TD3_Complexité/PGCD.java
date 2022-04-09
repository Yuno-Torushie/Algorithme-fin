package TD3_Complexité;

public class PGCD {
	
	public static int  pgcd( int A , int B ) {
		 
        if(A == B ) return A ;
        
        else{
        	if ( A > B ) return pgcd(A- B ,B);
        	else return pgcd( A , B-A );
        }
		
	}
	
}
