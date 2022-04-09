package myfirsttreeJava;

import java.util.Iterator;

public class SpanPathTreeIterator<T> implements Iterator<Object> {
	
	private final Tree<T> treeToIterate;
	
	private boolean isRootProcessed = false;
	private final Iterator<Tree<T>> itForest;
	private Iterator<T> itCurrentSubTree;

	public SpanPathTreeIterator(Tree<T> treeToIterator) {
		this.treeToIterator = treeToIterator;
		this.itForest = this.treeToIterate.getForest().iterator();
	}
	
	@Override
	public boolean hasNext(){
		if(treeToIterator.getHeight() != 0){
			return true;
		}
		return false;
	}
	
	@Override
	public T next(){
		return null;
	}
	

}
