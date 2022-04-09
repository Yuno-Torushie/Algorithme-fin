package myfirsttreeJava;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Treelmpl<T> implements Tree<T> {
	
	private T value;
	private final List<Tree<T>> forest;
	
	public Treelmpl() {
		this.forest = new ArrayList<>();
	}
	
	public Treelmpl(T value) {
		this.value = value;
		this.forest = new ArrayList<>();
	}
	
	public Treelmpl(T value, List<Tree<T>> forest) {
		this.value = value;
		if(forest == null) {
			throw new IllegalStateException("Forest cannot be null");
		}
		this.forest = forest;
	}
	
	@Override
	public T getRootValue() {
		return this.value;
	}

	public void setRootValue(T value) {
		this.value = value;
	}
	
	@Override
	public List<Tree<T>> getForest() {
		return this.forest;
	}

	@Override
	public int getHeight() {
		if(this.forest.isEmpty()) return 0;
		int maxHeight = 0;
		for(Tree<T> tree : this.forest) {
			int height = tree.getHeight();
			if(height > maxHeight) maxHeight = height;
		}
		return maxHeight+1;
	}

	@Override
	public int getNumNodes() {
		if(this.forest.isEmpty()) {
			return 1;
		}
		int total = 0;
		for(Tree<T> t : this.forest) {
			total += t.getNumNodes();
		}
		return total + 1;
	}

	@Override
	public int getNumLeaves() {
		if(this.forest.isEmpty()) return 1;
		int nbLeaves = 0;
		for(Tree<T> tree : this.forest)
			nbLeaves += tree.getNumLeaves();
		return nbLeaves;
	}
	
	@Override
	public AvgHeightInfo getAvgHeight(){
		if(this.forest.isEmpty()) return new AvgHeightInfo(0F,1);
		float balancedTotal = 0;
		int numLeaves = 0;
		for(Tree<T> tree : this.forest){
			AvgHeightInfo ahi = tree.getAvgHeight();
			balancedTotal +=ahi.getAvgHeight() * ahi.getNumLeaves();
			numLeaves += ahi.getAvgHeight();
		}
		return new AvgHeightInfo(1F + balancedTotal / numLeaves, numLeaves);
	}

	@Override
    public void fillValuesPrefixPath(List<T> filler) {
        filler.add(this.value);
        for (Tree<T> t : this.forest){
            t.fillValuesPrefixPath(filler);
        }
    }

    @Override
    public void fillValuesSuffixPath(List<T> filler) {
        for (Tree<T> t : this.forest){
            t.fillValuesSuffixPath(filler);
        }
        filler.add(this.value);
    }

    @Override
    public void fillValuesSpanPath(List<T> filler) {
        final Deque<Tree<T>> file = new LinkedList<>();
        file.addLast(this);

        while(file.isEmpty()){
            final Tree<T> t = file.removeFirst();
            file.addAll(t.getForest()); //ajoute tous les fils de t
            filler.add(t.getRootValue());
        }
    }

	@Override
	public Iterator<T> iterator() {
		return this.prefixPathIterator();
	}
	
	@Override
	public Iterator<T> prefixPathIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Iterator<T> suffixPathIterator(){
		return null;
	}

	@Override
	public Iterator<T> spanPathIterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
