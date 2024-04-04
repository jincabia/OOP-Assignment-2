/**
 * 
 */
package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Iterator;
import utilities.MyStack;


/**
 * 
 */
class MyStackTests 
{
	private MyStack<String> obj1;
	private MyStack<String> obj2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception 
	{
		obj1 = new MyStack<String>();
		obj2 = new MyStack<String>();
	}

	/**
	 * Test method for {@link implementations.MyStack#size()}.
	 */
	@Test
	void testSize() 
	{
		assertEquals(0, obj1.size());
	}

	/**
	 * Test method for {@link implementations.MyStack#clear()}.
	 */
	@Test
	void testClear() 
	{
		obj1.push("A");
		obj1.clear();
		assertEquals(0, obj1.size());
	}

	/**
	 * Test method for {@link implementations.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPushEmpty() 
	{
		assertThrows(NullPointerException.class, () -> obj1.push(null));
	}
	
	/**
	 * Test method for {@link implementations.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPushNotEmpty() 
	{
		obj1.push("A");
		assertEquals(1, obj1.size());
		assertEquals("A", obj1.peek());
	}

	/**
	 * Test method for {@link implementations.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearch() 
	{
		obj1.push("B");
		obj1.push("A");
		assertEquals(2, obj1.size());
		assertEquals(0, obj1.search("B"));
		assertEquals(1, obj1.search("A"));
	}

	/**
	 * Test method for {@link implementations.MyStack#peek()}.
	 */
	@Test
	void testPeekEmpty() 
	{
		assertThrows(EmptyStackException.class, () -> obj1.peek());
	}
	
	/**
	 * Test method for {@link implementations.MyStack#peek()}.
	 */
	@Test
	void testPeekNotEmpty() 
	{
		obj1.push("B");
		assertTrue(obj1.push("A"));
		assertEquals(2, obj1.size());
		assertEquals("A", obj1.peek());
	}

	/**
	 * Test method for {@link implementations.MyStack#pop()}.
	 */
	@Test
	void testPopEmpty() 
	{
		assertThrows(EmptyStackException.class, () -> obj1.pop());
	}
	
	/**
	 * Test method for {@link implementations.MyStack#pop()}.
	 */
	@Test
	void testPopNotEmpty() 
	{
		obj1.push("A");
		obj1.push("B");
		obj1.pop();
		assertEquals(1, obj1.size());
		assertEquals("A", obj1.peek());
	}

	/**
	 * Test method for {@link implementations.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmpty() 
	{
		assertTrue(obj1.isEmpty());
	}
	
	/**
	 * Test method for {@link implementations.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmptyNot() 
	{
		obj1.push("A");
		assertFalse(obj1.isEmpty());
	}
	
	/**
	 * Test method for {@link implementations.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmptyPushPop() 
	{
		obj1.push("A");
		obj1.pop();
		assertTrue(obj1.isEmpty());
	}

	/**
	 * Test method for {@link implementations.MyStack#iterator()}.
	 */
	@Test
	void testIteratorEmpty() 
	{
		Iterator<String> it = obj1.iterator();
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> it.next());
	}
	
	/**
	 * Test method for {@link implementations.MyStack#iterator()}.
	 */
	@Test
	void testIteratorNotEmpty() 
	{
		obj1.push("A");
		obj1.push("B");
		Iterator<String> it = obj1.iterator();
		assertTrue(it.hasNext());
		assertEquals("A", it.next());
		assertEquals("B", it.next());
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> it.next());
	}

}