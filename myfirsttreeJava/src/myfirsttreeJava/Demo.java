package myfirsttreeJava;

public class Demo<T> {
	private T value;
	
	public Demo(T v){
		this.value = v;
	}
	
	public T getValue(){
		return this.value;
	}
	
	public <X> X faireUnTruc(X x){ return x;}
	
	public static void main(){
		Demo<String> d = new Demo<String>("Str");
		String s = d.getValue();
		Demo<Integer> d2 = new Demo<Integer>(34);
		//Exception e = d.faireUnTruc();
	}
}
