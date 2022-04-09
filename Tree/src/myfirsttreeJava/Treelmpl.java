package myfirsttreeJava;

import java.util.ArrayList;
import java.util.List;

public class Treelmpl implements Tree {
	
	private Object value;
	private final List<Tree> forest;
	
	public Treelmpl() {
		this.forest = new ArrayList<>();
	}
	
	public Treelmpl(Object value) {
		this.value = value;
		this.forest = new ArrayList<>();
	}
	
	public Treelmpl(Object value, List<Tree> forest) {
		this.value = value;
		if(forest == null) {
			throw new IllegalStateException("Forest cannot be null");
		}
		this.forest = forest;
	}
	
	@Override
	public Object getRootValue() {
		return this.value;
	}

	public void setRootValue(Object value) {
		this.value = value;
	}
	
	@Override
	public List<Tree> getForest() {
		return this.forest;
	}

	public int getHeight() {
		if(this.forest.isEmpty()) return 0;
		int max = 0;
		for(Tree tree : forest) {
			int height = 0;
			height = tree.getHeight();
			
			if(height > max) max = height;
		}
		return max+1;
	}

	@Override
	public float getAvgHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
