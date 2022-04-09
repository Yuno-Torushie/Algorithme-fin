package myfirsttreeJava;

import java.util.List;

public interface Tree {
	
	Object getRootValue();
	
	List<Tree> getForest();
	
	int getHeight();
	
	float getAvgHeight();
}