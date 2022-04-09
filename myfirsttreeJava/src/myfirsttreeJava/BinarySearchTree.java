package myfirsttreeJava;

import java.util.NoSuchElementException;

public interface BinarySearchTree<T extends Comparable<T>> extends Tree<T>{
	
	/**
	 * Return the left subTree or null
	 * @return
	 */
	BinarySearchTree<T> getLeftSubTree();
	
	/**
	 * Return the right subTree or null
	 * @return
	 */
	BinarySearchTree<T> getRightSubTree();
	
	/**
	 * Return true if value is in the tree, false otherwise
	 * @param value the value
	 * @return the search result
	 */
	Boolean contains(T value);
	
	/**
	 * Return a value in a tree. If the value already exists, the value will be inserted to its right.
	 * @param value
	 */
	void insertValue(T value);
	
	/**
	 * delete a value from tree
	 * @param value
	 * @throws NoSuchElementException if the value does not exist
	 */
	void deleteValue(T value) throws NoSuchElementException;
}
