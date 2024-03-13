/**
 * 
 */
package utilities;

import java.io.Serializable;

/**
 * The QueueADT interface defines the methods that a queue data structure should implement.
 *
 * @param <E> The type of elements to be stored in the stack.
 */
public interface QueueADT<E> extends Serializable {
	
	
	/**
	 * Creates an empty Queue.
	 * 
	 * Precondition: None.
     * Postcondition: The queue is empty and ready to have elements added.
	 */
	 void createQueue();
	 
	 
	 /**
		 * The size method will return the current element count contained 
		 * in the Queue.
		 * 
		 * @return The current element count.
		 */
	 int size();
	 
	 
	 /**
	  * If the size of the Queue is equals to 0
	  * 
	  * @return If the size of the Queue is equal to 0.
	  * 
	  * */
	 boolean isEmpty();
	 
	 
	 /**
	  * Clears all elements inside the Queue
	  * 
	  * 
	  * 
	  * */
	 void dequeueAll();
	
	/**
	 * Appends the specified element to the end of this queue.
	 * 
	 * Precondition: An existing Queue object exists.
	 * Postcondition: toAdd is added onto the end of the queue, and the size is incremented by 1.
	 * 
	 * 
	 * @param toAdd
	 * 			Element to be appended to this Queue.
	 * @return true if element is appended successfully.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the queue
	 * 			implementation does not support having <code>null</code>
	 * 			elements.
	 */
	 boolean enqueue(E toAdd) throws NullPointerException;
	 
	 
	 /**
		 * Removes the first element from the Queue. 
		 * Returns the element that was removed from the list.
		 * 
		 * Precondition: An existing Queue object exists and at least one element inside of it.
		 * Postcondition: The first element is removed from the Queue, and the size is decremented by 1.
		 * 
		 * 
		 * @return The removed element.
		 */
	 
	 E dequeue();
	 
	 
	 /**
		 * 
		 * Accesses the first element from the Queue.
		 * Returns the element that was received at the front of the Queue.
		 * 
		 * Preconditions: An existing Queue Object exists.
		 * Postconditions: No changes are done.
		 * 
		 * 
		 * 
		 * @return The first element of the Queue.
		 */
	 
	 E peak();
	 
	 
		/**
		 * 
		 * Compares two Queues to check if they contain equal elements in the same order. 
		 * 
	  	 * @param that
		 * 			Another Queue object to be compared to check for matching elements in the same order.
		 * @throws NullPointerException
		 * 			If the specified element is <code>null</code> and the queue
		 * 			implementation does not support comparing <code>null</code>
		 * 			queues.
		 * 
		 * */
	 boolean equals(QueueADT<E> that) throws NullPointerException;
	 
	 
	 /**
		 * Returns an iterator over the elements in this Queue, in proper sequence.
		 * 
		 * @return An iterator over the elements in this Queue, in proper sequence.
		 * 			NB: The return is of type 
		 * 			<code>linearUtilities.Iterator<E></code>,
		 * 			not <code>java.util.Iterator</code>.
		 */
		public Iterator<E> iterator();	
	 
		
		
		/**
		 * Returns an array containing all of the elements in this Queue in proper
		 * sequence; the runtime type of the returned array is that of the specified
		 * Queue. Obeys the general contract of the
		 * <code>java.util.Collection.toArray(Object [])</code> method.
		 * The head of the queue corresponds to the first element of the array
		 * 
		 * @param toHold
		 *			The array into which the elements of this list are to be
		 * 			stored, if it is big enough; otherwise, a new array of the
		 * 			same runtime type is allocated for this purpose.
		 * @return An array containing the elements of this Queue.
		 * @throws NullPointerException
		 * 			If the specified array is <code>null</code>.
		 */
		public E[] toArray( E[] toHold ) throws NullPointerException;
		
		
		/**
		 * Returns an array containing all of the elements in this Queue in proper
		 * sequence. Obeys the general contract of the 
		 * <code>java.util.Collection.toArray()</code> method.
		 * The head of the queue corresponds to the first element of the array
		 * 
		 * @return An array containing all of the elements in this Queue in proper
		 * 			sequence.
		 */
		public Object[] toArray();
	 

}
