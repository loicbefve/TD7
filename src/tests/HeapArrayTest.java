/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

import heap.HeapArray;

/**
 * @author Loïc
 *
 */
public class HeapArrayTest {
	
	/**
	 * Test method for {@link heap.HeapArray#insertElement(java.lang.Object)}.
	 */
	@Test
	public void testInsertElement() {
		HeapArray<Integer> testArray = new HeapArray<Integer>(10, new Comparator<Integer>(){
			public int compare(Integer n1 , Integer n2){
				return n1-n2;
			}
		});
		 //Insert of a number OK
		assertTrue(testArray.insertElement(10));
		//Insert of the same return false because already inside
		for( int i = 0 ; i<9 ; i++) {
			int randInt = -10000 + (int)(Math.random() * 10000);
			assertTrue(testArray.insertElement(randInt));
		}
		//Insert another one return false
		assertFalse(testArray.insertElement(10));
		
		
		
	}

	/**
	 * Test method for {@link heap.HeapArray#element()}.
	 */
	@Test
	public void testElement() {
		HeapArray<Integer> testArray = new HeapArray<Integer>(100, new Comparator<Integer>(){
			public int compare(Integer n1 , Integer n2){
				return n1-n2;
			}
		});
		testArray.insertElement(15);
		testArray.insertElement(1);
		testArray.insertElement(5);
		testArray.insertElement(23);
		//the first element must be the bigger here 23
		assertTrue(testArray.element() == 23);
		
		//50?
		testArray.insertElement(50);
		assertTrue(testArray.element() == 50);
		
		
		
	}

	/**
	 * Test method for {@link heap.HeapArray#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		HeapArray<Integer> testArray = new HeapArray<Integer>(100, new Comparator<Integer>(){
			public int compare(Integer n1 , Integer n2){
				return n1-n2;
			}
		});
		assertTrue(testArray.isEmpty());
	}

	/**
	 * Test method for {@link heap.HeapArray#size()}.
	 */
	@Test
	public void testSize() {
		HeapArray<Integer> testArray = new HeapArray<Integer>(100, new Comparator<Integer>(){
			public int compare(Integer n1 , Integer n2){
				return n1-n2;
			}
		});
		//Cas 0:
		assertTrue(testArray.size() == 0);
		testArray.insertElement(15);
		assertTrue(testArray.size() == 1);
		testArray.insertElement(1);
		assertTrue(testArray.size() == 2);
	}
	
	@Test
	public void testIsFull() {
		HeapArray<Integer> testArray = new HeapArray<Integer>(1, new Comparator<Integer>(){
			public int compare(Integer n1 , Integer n2){
				return n1-n2;
			}
		});
		testArray.insertElement(15);
		
		assertTrue(testArray.isFull());
		
	}

}
