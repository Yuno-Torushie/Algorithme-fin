package myfirsttreeJava;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrefixPathTreeIterator<T> implements Iterator<Object> {
	
	private final Tree<T> treeToIterate;
	
	private boolean isRootProcessed = false;
	private final Iterator<Tree<T>> itForest;
	private Iterator<T> itCurrentSubTree;

	public PrefixPathTreeIterator(Tree<T> treeToIterator) {
		this.treeToIterate = treeToIterator;
		this.itForest = this.treeToIterate.getForest().iterator();
	}
	
	@Override
	public boolean hasNext(){
		return this.itForest.hasNext()
		|| ( this.itCurrentSubTree != null && this.itCurrentSubTree.hasNext())
		|| !this.isRootProcessed;
	}
	
	@Override
	public T next(){
		if(!this.isRootProcessed) {
			this.isRootProcessed = true;
			return this.treeToIterate.getRootValue();
		}
		
		if (this.itCurrentSubTree != null && this.itCurrentSubTree.hasNext()) return this.itCurrentSubTree.next(); 
		
		if (this.itForest.hasNext()) {
			this.itCurrentSubTree = this.itForest.next().prefixPathIterator();
			return this.itCurrentSubTree.next();
		}
		throw new NoSuchElementException();	
	}


}
