package myfirsttreeJava;

import java.util.Iterator;
import java.util.List;

public interface Tree<T> extends Iterable<T> {
	
	T getRootValue();
	
	List<Tree<T>> getForest();
	
	int getHeight();
	
	int getNumNodes();
	
	int getNumLeaves();
	
	AvgHeightInfo getAvgHeight();
	
	/**
	 * Remplit la liste filler avec mes vameirs des noeuds
	 * selon un parcours en prfondeur prefixe
	 * @param filler la liste à remplir
	 */
	void fillValuesPrefixPath(List<T> filler);
	
	/**
	 * Remplit la liste filler avec mes vameirs des noeuds
	 * selon un parcours en prfondeur suffixe
	 * @param filler la liste à remplir
	 */
	void fillValuesSuffixPath(List<T> filler);
	
	/**
	 * Remplit la liste filler avec mes vameirs des noeuds
	 * selon un parcours en largeur
	 * @param filler la liste à remplir
	 */
	void fillValuesSpanPath(List<T> filler);
	
	
	static class AvgHeightInfo{
		private final float avgHeight;
		private final int numLeaves;
		
		public AvgHeightInfo(float avgHeight, int numLeaves){
			this.avgHeight = avgHeight;
			this.numLeaves = numLeaves;
		}
		
		public float getAvgHeight(){
			return avgHeight;
		}
		public int getNumLeaves(){
			return numLeaves;
		}
	}
	
	Iterator<T> iterator();
	Iterator<T> prefixPathIterator();
	Iterator<T> suffixPathIterator();
	Iterator<T> spanPathIterator();
	
}
