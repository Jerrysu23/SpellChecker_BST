package assign08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;


/**
 * 
 * This class was created for  
 * 
 * @author JUNLIN SU && 
 *
 * @param <Type>
 */




public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type>{
	
	/**
	 * Represents a (generic) node in a binary tree.
	 */
	private class BinaryNode<T> {

		public T element;

		public BinaryNode<T> left;

		public BinaryNode<T> right;
		
		/**
		 * Creates a new BinaryNode object.
		 * 
		 * @param element - data element to store at this node
		 */
		@SuppressWarnings("unused")
		public BinaryNode(T element) {
			this(element, null, null);
		}

		/**
		 * Creates a new BinaryNode object.
		 * 
		 * @param element - data element to store at this node
		 * @param leftChild - this node's left child
		 * @param rightChild - this node's right child
		 */
		public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}

		/**
		 * @return a string containing all of the edges in the tree rooted at "this"
		 *         node, in DOT format
		 */
		@SuppressWarnings("unused")
		public String generateDot() {
			String ret = "\tnode" + element + " [label = \"<f0> |<f1> " + element + "|<f2> \"]\n";
			if(left != null)
				ret += "\tnode" + element + ":f0 -> node" + left.element + ":f1\n" + left.generateDot();
			if(right != null)
				ret += "\tnode" + element + ":f2 -> node" + right.element + ":f1\n" + right.generateDot();

			return ret;
		}
	}

	private BinaryNode<Type> root;
	
	private int size;

	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually inserted); otherwise, returns false
	 */
	@Override
	public boolean add(Type item) {
		BinaryNode<Type> temp = root;
		if(temp == null) {
			root = new BinaryNode<Type>(item, null, null);
			size++;
			return true;
		}
		while(temp != null) {
			int cmp = item.compareTo(temp.element);
			if(cmp < 0) {
				if(temp.left == null) {
					temp.left = new BinaryNode<Type>(item, null, null);
					size++;
					return true;
				}
				else{
					temp = temp.left;
				}
			}
			else if(cmp > 0) {
				if(temp.right == null) {
					temp.right = new BinaryNode<Type>(item, null, null);
					size++;
					return true;
				}
				else{
					temp = temp.right;
				}
			}
			else
				return false;
		}
			
		return false;
	}

	/**
	 * Ensures that this set contains all items in the specified collection.
	 * 
	 * @param items - the collection of items whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         any item in the input collection was actually inserted); otherwise,
	 *         returns false
	 */
	@Override
	public boolean addAll(Collection<? extends Type> items) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Removes all items from this set. The set will be empty after this method
	 * call.
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Determines if there is an item in this set that is equal to the specified
	 * item.
	 * 
	 * @param item - the item sought in this set
	 * @return true if there is an item in this set that is equal to the input item;
	 *         otherwise, returns false
	 */
	@Override
	public boolean contains(Type item) {
		BinaryNode<Type> temp = root;
		if(temp == null) 
			return false;
		while(temp != null) {
			int cmp = item.compareTo(temp.element);
			if(cmp > 0) {
				if(temp.right == null)
					return false;
				else
					temp = temp.right;
			}
			else if(cmp < 0) {
				if(temp.left == null)
					return false;
				else
					temp = temp.left;
			}
			else
				return true;
		}
		return false;
	}

	/**
	 * Determines if for each item in the specified collection, there is an item in
	 * this set that is equal to it.
	 * 
	 * @param items - the collection of items sought in this set
	 * @return true if for each item in the specified collection, there is an item
	 *         in this set that is equal to it; otherwise, returns false
	 */
	@Override
	public boolean containsAll(Collection<? extends Type> items) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the first (i.e., smallest) item in this set.
	 * 
	 * @throws NoSuchElementException if the set is empty
	 */
	@Override
	public Type first() throws NoSuchElementException {
		if(isEmpty())
			throw new NoSuchElementException();
		
		return null;
	}

	/**
	 * Returns true if this set contains no items.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the last (i.e., largest) item in this set.
	 * 
	 * @throws NoSuchElementException if the set is empty
	 */
	@Override
	public Type last() throws NoSuchElementException {
		if(isEmpty())
			throw new NoSuchElementException();
		
		return null;
	}

	/**
	 * Ensures that this set does not contain the specified item.
	 * 
	 * @param item - the item whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually removed); otherwise, returns false
	 */
	@Override
	public boolean remove(Type item) {
		BinaryNode<Type> temp = root;
		BinaryNode<Type> curNode = temp;
		BinaryNode<Type> removedNode = temp;
		boolean hasLeft = false;
		if(temp == null)
			return false;
		while(removedNode != null) {
			int cmp = item.compareTo(removedNode.element);
			if(cmp < 0) {
				hasLeft = true;
				curNode = removedNode;
				removedNode = removedNode.left;
			}
			else if(cmp > 0) {
				hasLeft = false;
				curNode = removedNode;
				removedNode = removedNode.right;
			}
			else {
				//when it is a leaf
				if(removedNode.left == null && removedNode.right == null) {
					if(removedNode == temp) {
						temp = null;
						size--;
					}
					else if(hasLeft) {
						curNode.left = null;
						size--;
					}
					else {
						curNode.right = null;
						size--;
					}
				}
				//when there is only a left node
				else if(removedNode.left != null && removedNode.right == null) {
					if(removedNode == temp) {
						temp = null;
						size--;
					}
					else if(hasLeft) {
						curNode.left = removedNode.left;
						size--;
					}
					else {
						curNode.right = removedNode.left;
						size--;
					}
				}
				//when there is only a right node
				else if(removedNode.left == null && removedNode.right != null) {
					if(removedNode == temp) {
						temp = null;
						size--;
					}
					else if(hasLeft) {
						curNode.left = removedNode.right;
						size--;
					}
					else {
						curNode.right = removedNode.right;
						size--;
					}
				}
				//when there are left and right nodes
				else if(removedNode.left != null && removedNode.right != null) {
					if(removedNode.right.left == null) {
						removedNode.element = removedNode.right.element;
						removedNode.right = removedNode.right.right;
						size--;
						return true;
					}
					
				}
			}
		}
		return false;
	}

	/**
	 * Ensures that this set does not contain any of the items in the specified
	 * collection.
	 * 
	 * @param items - the collection of items whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         any item in the input collection was actually removed); otherwise,
	 *         returns false
	 */
	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the number of items in this set.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns an ArrayList containing all of the items in this set, in sorted
	 * order.
	 */
	@Override
	public ArrayList<Type> toArrayList() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
