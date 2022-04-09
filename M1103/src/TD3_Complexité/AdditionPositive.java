package TD3_Complexité;

public class AdditionPositive {
	
	public static int addition(int x, int y) {
		
		if(x<0 || y<0)return (0);
		
		else if(x >=0 && y>0){
				x=x+1;
				y=y-1;
				return addition(x,y);
		}
		
		else return (x);	
	}
}
