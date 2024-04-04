
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.EmptyQueueException;
import utilities.Iterator;
import utilities.MyQueue;
import utilities.QueueADT;

class QueueTest {

    private QueueADT<String> queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueue<>();
    }

    @Test
    void testEnqueue() {
        queue.enqueue("A");
        assertEquals(1, queue.size());
    }

    @Test
    void testSizeEmpty() {
        assertEquals(0, queue.size());
    }

    @Test
    void testClearEmpty() {
        queue.enqueue("A");
        queue.dequeueAll();
        assertEquals(0, queue.size());
    }

    @Test
    void testClearElements() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.dequeueAll();
        assertEquals(0, queue.size());
    }

    @Test
    void testDequeue() {
        assertThrows(EmptyQueueException.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    void testPeek() {
        assertThrows(EmptyQueueException.class, () -> {
            queue.peek();
        });
    }

    @Test
    void testIsEmptyTrue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void testIsEmptyFalse() {
        queue.enqueue("A");
        assertFalse(queue.isEmpty());
    }

    @Test
    void testIteratorEmpty() {
        Iterator<String> it = queue.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    void testIteratorFull() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        Iterator<String> it = queue.iterator();
        assertTrue(it.hasNext());
        assertEquals("A", it.next());
        assertEquals("B", it.next());
        assertEquals("C", it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void testIteratorNoSuchElementException() {
    	//this test has an error since iterator isnt there yet, just creates null
        Iterator<String> it = queue.iterator();
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void testEquals() {
        QueueADT<String> anotherQueue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        assertFalse(queue.equals(anotherQueue));
    }

    @Test
    void testToArray() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        Object[] array = queue.toArray();
        assertEquals(3, array.length);
    }

    @Test
    void testToArrayWithHolder() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        String[] holder = new String[3];
        //this is running an error since holder is just has null elements
        queue.toArray(holder);
        assertEquals("A", holder[0]);
        assertEquals("B", holder[1]);
        assertEquals("C", holder[2]);
    }
}
