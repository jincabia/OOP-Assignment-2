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
import utilities.myDLL;
import utilities.myArrayList;

/**
 * 
 */
class myDLLUnitTest {
	
	private myDLL<String> dll1;
	private myDLL<String> dll2;
	private myArrayList<String> myArr;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		dll1 = new myDLL<>();
		dll2 = new myDLL<>();
		myArr = new myArrayList<>();

	}

	/**
	 * Test method for {@link utilities.myDLL#size()}.
	 */
	@Test
	void testSizeOneElement() {
		dll1.add("A");
		assertEquals(1,dll1.size());
	}
	
	/**
	 * Test method for {@link utilities.myDLL#size()}.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0,dll1.size());
	}

	/**
	 * Test method for {@link utilities.myDLL#clear()}.
	 */
	@Test
	void testClearEmpty() {
		dll1.clear();
		assertEquals(0,dll1.size());
	}
	
	/**
	 * Test method for {@link utilities.myDLL#clear()}.
	 */
	@Test
	void testClearElements() {
		dll1.add("A");
		dll1.add("A");
		dll1.add("A");
		assertEquals(3, dll1.size());
		dll1.clear();
		assertEquals(0,dll1.size());
	}

	/**
	 * Test method for {@link utilities.myDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEBeggining() {
		
		dll1.add("B");
		assertTrue(dll1.add(0,"A"));
		assertEquals("A", dll1.get(0));
		assertEquals(2,dll1.size());
		
		
//		assertTrue(list1.add(0,"A"));
//		assertEquals(2,list1.size());
//		assertEquals("A", list1.get(0));
		
	}
	
	/**
	 * Test method for {@link utilities.myDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEMiddle() {
		dll1.add("A");
		dll1.add("C");
		assertTrue(dll1.add(1,"B"));
		assertEquals("B", dll1.get(1));
		assertEquals(3,dll1.size());
	}
	
	/**
	 * Test method for {@link utilities.myDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEEnd() {
		dll1.add("A");
		dll1.add("B");
		dll1.add(dll1.size(),"C");
//		assertTrue();
		assertEquals("C", dll1.get(2));
		assertEquals(3,dll1.size());
	}
	
//	NullPointerException, IndexOutOfBoundsExceptio
	
	/**
	 * Test method for {@link utilities.myDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntENullPointerException() {
		assertThrows(NullPointerException.class, ()-> dll1.add(0,null));
	}
	
	/**
	 * Test method for {@link utilities.myDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEIndexOutOfBoundsExceptionNegative() {
		assertThrows(IndexOutOfBoundsException.class, ()-> dll1.add(-1,"A"));
	}
	
	
	
	/**
	 * Test method for {@link utilities.myDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEIndexOutOfBoundsExceptionPositive() {
		assertThrows(IndexOutOfBoundsException.class, ()-> dll1.add(20,"A"));

	}

	/**
	 * Test method for {@link utilities.myDLL#add(java.lang.Object)}.
	 */
	@Test
	void testAddEEmpty() {
		dll1.add("A");
//		assertTrue(dll1.add("A"));
		assertEquals(1, dll1.size());
		assertEquals("A",dll1.get(dll1.size()-1));
	}
	
	
	/**
	 * Test method for {@link utilities.myDLL#add(java.lang.Object)}.
	 */
	@Test
	void testAddENotEmpty() {
		dll1.add("A");
		assertTrue(dll1.add("B"));
		assertEquals(2,dll1.size());
		assertEquals("B",dll1.get(dll1.size()-1));
	}
	
	
	/**
	 * Test method for {@link utilities.myDLL#add(java.lang.Object)}.
	 */
	@Test
	void testAddENullPointerException() {
		assertThrows(NullPointerException.class, ()-> dll1.add(0,null));

	}
	

	/**
	 * Test method for {@link utilities.myDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllEmptyList() {
		dll2.add("A");
		dll2.add("B");
		dll1.addAll(dll2);
		assertEquals(2,dll1.size());
		assertEquals("B",dll1.get(dll1.size()-1));
		
		
	}
	
	/**
	 * Test method for {@link utilities.myDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllFullList() {
		
		dll2.add("C");
		dll2.add("D");
		
		dll1.add("A");
		dll1.add("B");
		
		dll1.addAll(dll2);
		assertEquals(4,dll1.size());
		assertEquals("D",dll1.get(dll1.size()-1));
		
	}

	/**
	 * Test method for {@link utilities.myDLL#get(int)}.
	 */
	@Test
	void testGetBeggining() {
		dll1.add("A");
		dll1.add("B");
		assertEquals("A",dll1.get(0));
	}
	
	/**
	 * Test method for {@link utilities.myDLL#get(int)}.
	 */
	@Test
	void testGetMiddle() {
		dll1.add("A");
		dll1.add("B");
		dll1.add("C");

		assertEquals("B",dll1.get(1));
	}
	
	/**
	 * Test method for {@link utilities.myDLL#get(int)}.
	 */
	@Test
	void testGetEnd() {
		dll1.add("A");
		dll1.add("B");
		dll1.add("C");

		//maybe -1?
		assertEquals("C",dll1.get(dll1.size()-1));
	}
	
	/**
	 * Test method for {@link utilities.myDLL#get(int)}.
	 */
	@Test
	void testGetIndexOutOfBoundsPositive() {
		assertThrows(IndexOutOfBoundsException.class, ()-> dll1.get(20));
	}
	
	/**
	 * Test method for {@link utilities.myDLL#get(int)}.
	 */
	@Test
	void testGetIndexOutOfBoundsNegative() {
		assertThrows(IndexOutOfBoundsException.class, ()-> dll1.get(-1));
	}
	/**
	 * Test method for {@link utilities.myDLL#get(int)}.
	 */
	@Test
	void testGetIndexOutOfBoundsZero() {
		assertThrows(IndexOutOfBoundsException.class, ()-> dll1.get(0));
	}
	
	

	/**
	 * Test method for {@link utilities.myDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntBeggining() {
		dll1.add("A");
		dll1.add("B");
		dll1.add("C");
		String removed = dll1.remove(0);
		assertEquals("A",removed);
		assertEquals("B",dll1.get(0));
		assertEquals(2,dll1.size());
	}
	
	/**
	 * Test method for {@link utilities.myDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntMiddle() {
		dll1.add("A");
		dll1.add("B");
		dll1.add("C");
		String removed = dll1.remove(1);
		assertEquals("B",removed);
		assertEquals("C",dll1.get(1));
		assertEquals(2,dll1.size());
	}
	
	/**
	 * Test method for {@link utilities.myDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntEnd() {
		dll1.add("A");
		dll1.add("B");
		dll1.add("C");
		String removed = dll1.remove(dll1.size());
		assertEquals("C",removed);
		assertEquals("B",dll1.get(dll1.size()-1));
		assertEquals(2,dll1.size());
	}
	
	/**
	 * Test method for {@link utilities.myDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntOutOfBoundsZero() {
		assertThrows(IndexOutOfBoundsException.class, ()-> dll1.remove(0));	}
	
	/**
	 * Test method for {@link utilities.myDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntOutOfBoundsNegative() {
		assertThrows(IndexOutOfBoundsException.class, ()-> dll1.remove(-1))	;
	}
	
	/**
	 * Test method for {@link utilities.myDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntOutOfBoundsPositve() {
		assertThrows(IndexOutOfBoundsException.class, ()-> dll1.remove(20));	
	}

	/**
	 * Test method for {@link utilities.myDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveESucess() {
		dll1.add( "A" );
		String actual = dll1.remove( "A" );
		assertEquals( "A", actual );
	}
	
	void testRemoveENullPointer() {
		try
		{
			dll1.remove( null );
			fail( "Remove method failed to throwNullPointerException." );
		}
		catch( NullPointerException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for {@link utilities.myDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetBeggining() {

		dll1.add("B");
		dll1.add("B");
		dll1.add("C");
		dll1.set(0, "A");
		assertEquals("A", dll1.get(0));
		assertEquals(3, dll1.size());

	}
	
	/**
	 * Test method for {@link utilities.myDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetMiddle() {
		dll1.add("A");
		dll1.add("A");
		dll1.add("C");
		dll1.set(1, "B");
		assertEquals("B", dll1.get(1));
		assertEquals(3, dll1.size());
	}
	/**
	 * Test method for {@link utilities.myDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetEnd() {
		dll1.add("A");
		dll1.add("B");
		dll1.add("B");
		dll1.set(2, "C");
		assertEquals("C", dll1.get(2));
		assertEquals(3, dll1.size());
	}

	/**
	 * Test method for {@link utilities.myDLL#isEmpty()}.
	 */
	@Test
	void testIsEmptyTrue() {
		assertTrue(dll1.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.myDLL#isEmpty()}.
	 */
	@Test
	void testIsEmptyFalse() {
		dll1.add("A");
		assertFalse(dll1.isEmpty());
	}

	/**
	 * Test method for {@link utilities.myDLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		dll1.add("A");
		dll1.add("B");
		dll1.add("C");
		assertTrue(dll1.contains("B"));
		

	}
	
	/**
	 * Test method for {@link utilities.myDLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsNullPointer() {
		assertThrows(NullPointerException.class, ()-> dll1.contains(null));
	}

	/**
	 * Test method for {@link utilities.myDLL#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		dll1.add("A");
		dll1.add("B");
		dll1.add("C");
		String[] testArr = new String[dll1.size()];
		dll1.toArray(testArr);
		assertEquals("A", testArr[0]);
		assertEquals("B",testArr[1]);
		assertEquals("C",testArr[2]);
		assertEquals(3,testArr.length);

	}
	
	/**
	 * Test method for {@link utilities.myDLL#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNullPointer() {
		assertThrows(NullPointerException.class, ()-> dll1.toArray(null));
	}

	/**
	 * Test method for {@link utilities.myDLL#toArray()}.
	 */
	@Test
	void testToArray() {
		dll1.add("A");
		dll1.add("B");
		dll1.add("C");

		String[] testArr = new String[dll1.size()];
		dll1.toArray(testArr);
		assertEquals("A",testArr[0]);
		assertEquals("B",testArr[1]);
		assertEquals("C",testArr[2]);


		
		
		
	}

	/**
	 * Test method for {@link utilities.myDLL#iterator()}.
	 */
	@Test
	void testIteratorEmpty() {
		Iterator<String> it = dll1.iterator();
		assertFalse(it.hasNext());
	}
	
	/**
	 * Test method for {@link utilities.myDLL#iterator()}.
	 */
	@Test
	void testIteratorFull() {
		dll1.add("A");
		dll1.add("B");
		dll1.add("C");
		Iterator<String> it = dll1.iterator();
		assertTrue(it.hasNext());
		assertEquals("A",it.next());
		assertEquals("B",it.next());
		assertEquals("C",it.next());
		assertFalse(it.hasNext());
		

		
	}
	
	/**
	 * Test method for {@link utilities.myDLL#iterator()}.
	 */
	@Test
	void testIteratorNoSuchElementException() {
		Iterator<String> it = dll1.iterator();

		assertThrows(NoSuchElementException.class, () -> it.next());

	}

}
