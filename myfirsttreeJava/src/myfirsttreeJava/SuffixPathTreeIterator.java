package myfirsttreeJava;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuffixPathTreeIterator<T> implements Iterator<Object> {
	
	private final Tree<T> treeToIterate;
	
	private boolean isRootProcessed = false;
	private final Iterator<Tree<T>> itForest;
	private Iterator<T> itCurrentSubTree;
	
	public SuffixPathTreeIterator(Tree<T> treeToIterator) {
		this.treeToIterate = treeToIterator;
		this.itForest = this.treeToIterate.getForest().iterator();
		this.itCurrentSubTree = null;
		this.isRootProcessed = false;
	}
	
	@Override
	public boolean hasNext(){
		return !this.isRootProcessed;
	}
	
	@Override
	public T next(){
		if (this.itCurrentSubTree != null && this.itCurrentSubTree.hasNext()) return this.itCurrentSubTree.next(); 
		
		if (this.itForest.hasNext()) {
			Tree<T> subTree = this.itForest.next();
			this.itCurrentSubTree = subTree.suffixPathIterator();
			return this.itCurrentSubTree.next();
		}
		
		if(!this.isRootProcessed) {
			this.isRootProcessed = true;
			return this.treeToIterate.getRootValue();
		}
		throw new NoSuchElementException();	
	}

}
