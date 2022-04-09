package myfirsttreeJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {

	private T rootValue;
	
	private BinarySearchTreeImpl<T> leftSubTree;
	
	private BinarySearchTreeImpl<T> rightSubTree;
	
	public BinarySearchTreeImpl(T rootValue) {
		this.rootValue = rootValue;
	}
	
	@Override
	public T getRootValue() {
		return this.rootValue;
	}
	
	protected void setRootValue(T rootValue) {
		this.rootValue = rootValue;
	}

	@Override
	public List<Tree<T>> getForest() {
		List<Tree<T>> l = new ArrayList<>(); 
		if(this.leftSubTree != null) l.add(this.leftSubTree);
		if(this.rightSubTree != null) l.add(this.rightSubTree);
		return Collections.unmodifiableList(l);
	}
	
	@Override
	public int getHeight() {
		if(this.leftSubTree == null && this.rightSubTree == null) return 0;
		return 1 + Math.max(this.leftSubTree != null ? this.leftSubTree.getHeight() : 0, 
				this.rightSubTree != null ? this.rightSubTree.getHeight() : 0 );
	}
	
	@Override
	public int getNumNodes() {
		return 1 + (this.leftSubTree != null ? this.leftSubTree.getHeight() : 0) + 
				(this.rightSubTree != null ? this.rightSubTree.getHeight() : 0 );
	}
	
	@Override
	public int getNumLeaves() {
		if (this.leftSubTree == null && this.rightSubTree == null) {
			return 1;
		}
		return (this.leftSubTree != null ? this.leftSubTree.getHeight() : 0) + 
				(this.rightSubTree != null ? this.rightSubTree.getHeight() : 0 );
	}
	
	@Override
	public myfirsttreeJava.Tree.AvgHeightInfo getAvgHeight(){
		if ( this.leftSubTree == null &&this.rightSubTree == null) {
			return new AvgHeightInfo(0F, 1);
		}
		float hMoy = 0F; //(hMoyLeft + nbLL + hMoyRight + nbLR) / (nbLL + nbLR)
		int numLeaves = 0;
		if(this.leftSubTree != null) {
			AvgHeightInfo info = this.leftSubTree.getAvgHeight();
			hMoy += info.getAvgHeight() * info.getNumLeaves();
			numLeaves += info.getNumLeaves();
		}
		if(this.rightSubTree != null) {
			AvgHeightInfo info = this.rightSubTree.getAvgHeight();
			hMoy += info.getAvgHeight() * info.getNumLeaves();
			numLeaves += info.getNumLeaves();
		}
		return new AvgHeightInfo(1F + hMoy / numLeaves, numLeaves);
	}

	@Override
	public void fillValuesPrefixPath(List<T> filler) {
		filler.add(this.rootValue);
		if(this.leftSubTree != null) {
			this.leftSubTree.fillValuesPrefixPath(filler);
		}
		if(this.rightSubTree != null) {
			this.rightSubTree.fillValuesPrefixPath(filler);
		}
		
	}

	@Override
	public void fillValuesSuffixPath(List<T> filler) {
		if(this.leftSubTree != null) {
			this.leftSubTree.fillValuesPrefixPath(filler);
		}
		if(this.rightSubTree != null) {
			this.rightSubTree.fillValuesPrefixPath(filler);
		}
		filler.add(this.rootValue);
		
	}

	@Override
	public void fillValuesSpanPath(List<T> filler) {
        final Deque<BinarySearchTree<T>> file = new LinkedList<>();
        file.addLast(this);
        
        while(file.isEmpty()){
            final BinarySearchTree<T> t = file.removeFirst();
            filler.add(t.getRootValue()); //ajoute tous les fils de t
            if(this.leftSubTree != null) {
            	file.addLast(t.getLeftSubTree());
            }
            if(this.rightSubTree != null) {
            	file.addLast(t.getRightSubTree());
            }
        }

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return this.prefixPathIterator();
	}
	
	public BinarySearchTree<T> getLeftSubTree() {
		return this.leftSubTree;
	}
	
	public BinarySearchTree<T> getRightSubTree() {
		return this.rightSubTree;
	}
	
	public T getMax() {
		if(this.rightSubTree == null) return this.getRootValue();
		return this.rightSubTree.getMax();
	}
	private boolean isLeaf() {
		return this.leftSubTree == null && this.rightSubTree == null;
	}
	
	@Override
	public Boolean contains(T value) {
		final int res = this.getRootValue().compareTo(value);
		if(res == 0)
			return true;
		if(res < 0)
			return this.getRightSubTree() != null ? this.getRightSubTree().contains(value) : false;
		else 
			return this.getLeftSubTree() != null ? this.getLeftSubTree().contains(value) : false;
	}

	@Override
	public void insertValue(T value) {
		final int res = this.getRootValue().compareTo(value);
		if(res < 0)
			if(this.getRightSubTree() == null)
				this.rightSubTree = new BinarySearchTreeImpl<>(value);
			else this.rightSubTree.insertValue(value);
		else if(res > 0)
			if(this.getLeftSubTree() == null)
				this.leftSubTree = new BinarySearchTreeImpl<>(value);
			else this.leftSubTree.insertValue(value);
	}

	@Override
	public void deleteValue(T value) throws NoSuchElementException {
        int res = this.rootValue.compareTo(value);
        //Si pas de sag, pas de sad
        if(this.leftSubTree == null && this.rightSubTree == null) {
            // CAS 1 : pas de sag, pas de sad, value != racine => rien
            if(res != 0) {
                throw new NoSuchElementException();
            } else {
            // CAS 2 : pas de sag, pas de sad, value == racine => exception
                throw new IllegalStateException("Impossible de supprimer l'unique noeud de l'arbre");
            }
        }
        if(res == 0) {
            if ( this.leftSubTree != null) {
                // CAS 3 : sag, value == racine => Remplacer racine par + gd noeud puis delete noeud
                T valMax = this.leftSubTree.getMax();
                this.deleteValue(valMax);
                this.rootValue = valMax;
            } else {
                // CAS 4 : sad, value == racine => Remplacer racine par - gd noeud puis delete noeud
                T valMin = this.rightSubTree.getMax();
                this.deleteValue(valMin);
                this.rootValue = valMin;
            }
        } else if (res > 0) { // La valeur Ã  supprimer est plus petite que moi
            if (this.leftSubTree == null) {
                throw new NoSuchElementException(); // CAS 5a : pas de sag, value < racine => Exception
            } 
            if (this.leftSubTree.isLeaf() && this.leftSubTree.getRootValue().equals(value)) {
                // CAS 6 : sag, value < racine => recursion sur sag
                this.leftSubTree = null;
            } else {
                // CAS 7 : sad, value < racine => recursion sur sad
                this.leftSubTree.deleteValue(value);
            }
        } else {
            if (this.rightSubTree == null) {
                throw new NoSuchElementException(); // CAS 5a : pas de sag, value < racine => Exception
            } 
            if (this.rightSubTree.isLeaf() && this.rightSubTree.getRootValue().equals(value)) {
                // CAS 6 : sag, value < racine => recursion sur sag
                this.rightSubTree = null;
            } else {
                // CAS 7 : sad, value < racine => recursion sur sad
                this.rightSubTree.deleteValue(value);
            }
        }
        
        
        
        /*if(!this.contains(value)) {
            throw new NoSuchElementException();
        }
        for(Tree<T> tree : this.getForest()) {
            if(tree.getValue().compareTo(value) == 0) {
                tree.getForest();
                deleteValue(this.rootValue);
            }
        }*/
    }

	@Override
	public Iterator<T> prefixPathIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> suffixPathIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> spanPathIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
