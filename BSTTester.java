package assign08;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTTester {
	BinarySearchTree<String> bst = new BinarySearchTree<String>(); //balanced BST of height 3, even sides

	@BeforeEach
	void setUp() throws Exception {
		bst.add("h");
		bst.add("d");
		bst.add("l");
		bst.add("b");
		bst.add("f");
		bst.add("j");
		bst.add("n");
		bst.add("a");
		bst.add("c");
		bst.add("e");
		bst.add("g");
		bst.add("i");
		bst.add("k");
		bst.add("m");
		bst.add("o");
	}

	@Test
	void add() {
		BinarySearchTree<String> oneAdd = new BinarySearchTree<String>();
		assertTrue(oneAdd.add("a"));
		assertEquals(oneAdd.size(), 1);
		assertTrue(oneAdd.add("b"));
	}
	
//	@Test
//	void clear() {
//		bst.clear();
//		assertEquals(0, bst.size());
//	}
//
//	@Test
//	void findHeight() {
//		assertEquals(4,bst.findHeight());
//	}
//	
//	@Test
//	void contains() {
//		assertTrue(bst.contains("a"));
//		assertTrue(bst.contains("h"));
//		assertTrue(bst.contains("o"));
//
//	}
//	
//	@Test
//	void containsAll() {
//		ArrayList<String> items = new ArrayList<String>();
//		items.add("a");
//		items.add("b");
//		items.add("c");
//		items.add("d");
//		items.add("e");
//		items.add("f");
//		items.add("g");
//		items.add("h");
//		items.add("i");
//		items.add("j");
//		items.add("k");
//		items.add("l");
//		items.add("m");
//		items.add("n");
//		items.add("o");
//		assertTrue(bst.containsAll(items));
//		items.add("p");
//		assertFalse(bst.containsAll(items));
//	}
//	
//	
//	
//	@Test
//	void first() {
//		System.out.println(bst.toArrayList().toString());
//		assertEquals("a", bst.first());
//	}
//	
//	@Test
//	void last() {
//		assertEquals("o", bst.last());
//
//	}
//
//	@Test
//	void toArrayList() {
//		BinarySearchTree<String> tree = new BinarySearchTree<String>();
//		tree.add("2");
//		tree.add("1");
//		tree.add("3");
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("1");
//		list.add("2");
//		list.add("3");
//		assertEquals(tree.toArrayList(), list);
//	}
	@Test
	void remove() {
		assertTrue(bst.remove("a"));//leaf
		assertTrue(bst.remove("h"));//root with two
		assertTrue(bst.remove("b"));//one side
		assertTrue(bst.remove("n"));//TODO fix, removes L instead of n?
		bst.generateDot("src/assign08/testFile.txt");
		BinarySearchTree<String> test = new BinarySearchTree<String>();
		test.add("1");
		assertTrue(test.remove("1"));
		assertFalse(test.remove("c"));

		
		
		
	}
}
