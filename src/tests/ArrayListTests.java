/**
 * 
 */
package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Iterator;
import utilities.ListADT;
import utilities.ListADT;
import utilities.myDLL;
import utilities.myArrayList;

/**
 * 
 */
class MyArrayListTests 
{
	private ListADT<String> obj1;
	private ListADT<String> obj2;
	private myDLL<String> obj3;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception 
	{
		obj1 = new myArrayList<>();
		obj2 = new myArrayList<>();
		obj3 = new myDLL<>();
	}

	
	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	void testSizeEmpty() 
	{
		assertEquals(0, obj1.size());
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	void testSizeNotEmpty() 
	{
		obj1.add("A");
		assertEquals(1, obj1.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#clear()}.
	 */
	@Test
	void testClear() 
	{
		obj1.add("A");
		obj1.clear();
		assertEquals(0, obj1.size());
	}

	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEBegin() 
	{
		obj1.add("B");
		assertTrue(obj1.add(0,"A"));
		assertEquals(2, obj1.size());
		assertEquals("A", obj1.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEMiddle() 
	{
		obj1.add("A");
		obj1.add("C");
		assertTrue(obj1.add(1,"B"));
		assertEquals(3, obj1.size());
		assertEquals("B", obj1.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEEnd() 
	{
		obj1.add("A");
		assertTrue(obj1.add(1,"B"));
		assertEquals(2, obj1.size());
		assertEquals("B", obj1.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntENullPointer() 
	{
		assertThrows(NullPointerException.class, () -> obj1.add(0,null));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEOutOfBoundsPositive() 
	{
		assertThrows(IndexOutOfBoundsException.class, () -> obj1.add(-1, "A"));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEOutOfBoundsNegative() 
	{
		assertThrows(IndexOutOfBoundsException.class, () -> obj1.add(1, "A"));
	}


	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddIntECapacity() 
	{
		for(int i = 0; i < 1000; i++) 
		{
			assertTrue(obj1.add(0,"A"));
		}
		assertEquals(1000, obj1.size());
	}
	


	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddEEmpty() 
	{
		assertTrue(obj1.add("A"));
		assertEquals(1, obj1.size());
		assertEquals("A", obj1.get(obj1.size()-1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddENotEmpty() 
	{
		obj1.add("A");
		assertTrue(obj1.add("B"));
		assertEquals(2, obj1.size());
		assertEquals("B", obj1.get(obj1.size()-1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddENullPointer() 
	{
		assertThrows(NullPointerException.class, () -> obj1.add(null));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddECapacity() 
	{
		for(int i = 0; i < 1000; i++) 
		{
			assertTrue(obj1.add("A"));
		}
		assertEquals(1000, obj1.size());
	}
	
	
	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllArrayList() 
	{
		obj1.add("A");
		obj2.add("B");
		assertTrue(obj1.addAll(obj2));
		assertEquals(2, obj1.size());
		assertEquals("B", obj1.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllDLL() 
	{
		obj1.add("A");
		obj2.add("B");
		assertTrue(obj1.addAll(obj2));
		assertEquals(2, obj1.size());
		assertEquals("B", obj1.get(1));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllNullPointer() 
	{
		assertThrows(NullPointerException.class, () -> obj1.addAll(null));
	}


	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	void testGet() 
	{
		obj1.add("A");
		assertEquals("A", obj1.get(0));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveInt() 
	{
		obj1.add("A");
		obj1.add("B");
		obj1.remove(0);
		assertEquals(1, obj1.size());
		assertEquals("B", obj1.get(0));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveE() 
	{
		obj1.add("A");
		obj1.add("B");
		obj1.remove(0);
		assertEquals(1, obj1.size());
		assertEquals("B", obj1.get(0));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	void testSet() 
	{
		obj1.add("A");
		obj1.set(0, "B");
		assertEquals(1, obj1.size());
		assertEquals("B", obj1.get(0));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 */
	@Test
	void testIsEmpty() 
	{
		obj1.add("A");
		obj1.remove("A");
		assertTrue(obj1.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() 
	{
		obj1.add("A");
		assertTrue(obj1.contains("A"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() 
	{
		String[] objectTest = new String[10];
		obj1.add("A");
		obj1.add("B");
		objectTest = obj1.toArray(objectTest);
		assertEquals("A", objectTest[0]);
		assertEquals("B", objectTest[1]);
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 */
	@Test
	void testToArray() 
	{
		Object[] objectTest = new Object[10];
		obj1.add("A");
		obj1.add("B");
		objectTest = obj1.toArray();
		assertEquals("A", objectTest[0]);
		assertEquals("B", objectTest[1]);
	}

	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 */
	@Test
	void testIteratorEmpty() 
	{
		Iterator<String> it = obj1.iterator();
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> it.next());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 */
	@Test
	void testIteratorNotEmpty() 
	{
		obj1.add("A");
		obj1.add("B");
		Iterator<String> it = obj1.iterator();
		assertTrue(it.hasNext());
		assertEquals("A", it.next());
		assertEquals("B", it.next());
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> it.next());
	}
}