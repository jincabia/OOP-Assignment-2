package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;



public class myDLL<E> implements ListADT<E> {
	
	private myDLLNode<E> head, tail;
	private int size;
	
	public myDLL()
	{
		head=null;
		tail=null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head=tail=null;
		size = 0;
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
	    if (toAdd == null) {
	        throw new NullPointerException("Cannot add null element to the list.");
	    }

	    if (index < 0 || index > size) {
	        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
	    }

	    myDLLNode<E> newNode = new myDLLNode<>(toAdd);
	    myDLLNode<E> currentNode = head;
	    
	    if (size == 0) { // List is empty
	        head = tail = newNode;
	    } else if (index == 0) { // Adding at the beginning
	        newNode.setNext(head);
	        head.setPrev(newNode);
	        head = newNode;
	    } else if (index == size) { // Adding at the end
	        
	    	//goes to last in the index
	    	newNode.setPrev(tail);
	    	tail.setNext(newNode);
	    	tail = newNode;
	    	
	    	
	    } else { // Adding in the middle
	        myDLLNode<E> current = head;
	        for (int i = 0; i < index - 1; i++) {
	            current = current.getNext();
	        }
	        newNode.setNext(current.getNext());
	        newNode.setPrev(current);
	        current.getNext().setPrev(newNode);
	        current.setNext(newNode);
	    }
	    
	    size++;
	    return true;
	}


	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
	        throw new NullPointerException("Cannot add null element to the list.");
	    }
		myDLLNode<E> newNode = new myDLLNode<>(toAdd);
		
		
		if(size == 0)
		{
			head = tail = (newNode);
		}
		else
		{
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
			
		}
        size++;
		
		
		
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) {
	        throw new NullPointerException("Cannot add null elements to the list.");
	    }
		
		//ListADT use toArray
		//From Array add it to the Nodes
		E[] arr = (E[]) toAdd.toArray();
		int arrLength = arr.length;
		
		for(int i = 0; i < arrLength;i++)
		{
			add(arr[i]);
		}
		
		
		
		
		
		
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		
		if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
	    }
		myDLLNode<E> current = head;

		for(int i = 0; i != index && current.getNext()!=null;i++)
		{
			current = current.getNext();
			
		}
		return current.getElement();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		
		if (index < 0 || index > size || (index == 0 && size == 0) ) {
	        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
	    }
		
		
		
		myDLLNode<E> removedValue = null;
		
		if(index == 0) //remove first element
		{
			//remove the first element = head of the list
			removedValue = head;
			// get the first node (head) and find the next node afterwards
			if(head.getNext() != null)
			{
				
				head = head.getNext();
				head.setPrev(null);
				
			}
			else
			{
				head = null;
			
			}
		}
		
		//removing the end
		else if(index == this.size)
		{
			removedValue = tail;
			if(tail.getPrev()!= null)
			{
				tail = tail.getPrev();
				tail.setNext(null);
			}
			else
			{
				tail = null;
			}
			
		}
		else // somewhere in between 
		{
			myDLLNode<E> current = head;
	        for (int i = 0; i < index; i++) {
	            current = current.getNext();
	        }
	        myDLLNode<E> temp = current;
	        removedValue = temp;
	        
	        //A
	        current = current.getPrev();
	        
	        //A --> C
	        current.setNext(temp.getNext());
	        
//	        current.getPrev().setNext(current.getNext().getNext());
	        
	        //C
	        current = current.getNext();
	        
	        //A <-- C 
	        current.setPrev(temp.getPrev());
	        
	       
			
		}
		

		
		
		
		
		size--;
		
		return  removedValue.getElement();
		
		
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
	        throw new NullPointerException("Cannot add null element to the list.");
	    }
		
		myDLLNode<E> returnValue = null;
		
		if(this.size == 0) return null;
		
		if(this.size == 1)
		{
			returnValue = head;
			head = tail = null;
			size--;
			return returnValue.getElement();
			
			
		}
		
		myDLLNode<E> current = head;
		while(current.getNext() != null)
		{
			//get the element of the next one 
			if(current.getElement() == toRemove)
			{
				returnValue = current;
				myDLLNode<E> prevNode = current.getPrev();
				prevNode.setNext(current.getNext());
				current = current.getNext();
				current.setPrev(prevNode);
			}
			
		}
		
		size--;
		
		return returnValue.getElement();
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null) {
	        throw new NullPointerException("Cannot add null element to the list.");
	    }
		
		if (index < 0 || index > size || (index == 0 && size == 0) ) {
	        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
	    }
		
		E returnValue = null;
		
		if(index == 0)//change the head
		{
			returnValue = head.getElement();
			head.setElement(toChange);
			tail.setElement(toChange);
			
		}
		
		else if(index == size)
		{
			returnValue = tail.getElement();
			tail.setElement(toChange);
			
		}
		else
		{
			myDLLNode<E> current = head;
	        for (int i = 0; i != index; i++) {
	            current = current.getNext();
	        }
	        
	        returnValue = current.getElement();
	        current.setElement(toChange);
	        
		}
		
		
		return returnValue;
	}

	@Override
	public boolean isEmpty() {
		
		return size==0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
	        throw new NullPointerException("Cannot search null element to the list.");
	    }
		
		if(head==null) return false;
		else
		{
			myDLLNode<E> currentNode = head;
			for(int i = 0; i < size && currentNode.getNext()!=null;i++)
			{
				if(currentNode.getElement() == toFind) return true;
				currentNode = currentNode.getNext();
			}
			
		}
		
		
		
		return false;
		
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
	        throw new NullPointerException("Cannot use a null array to hold elements.");
	    }
		
		if(toHold.length < size)
		{
			toHold = (E[]) (Array.newInstance(toHold.getClass().getComponentType(), size));
		}
		
		myDLLNode<E> currentNode = head;
		
		for(int i = 0; i < size; i++)
		{
			toHold[i] = currentNode.getElement();
			currentNode = currentNode.getNext();
		}
		
		if(toHold.length>size)
		{
			toHold[size] = null;
		}
		
		return toHold;
	}

	@Override
	public Object[] toArray() {
		
		Object[] arr = new Object[this.size()];
		myDLLNode<E> currentNode = head;
		for(int i = 0; i < size; i++)
		{
			arr[i] = currentNode.getElement();
			currentNode = currentNode.getNext();
		}
		

		return arr;
	}

	public Iterator<E> iterator()
	{
		return new DLLIterator();
	}

	/*******************************
	 * INNER CLASSES
	 *********************************/
	private class DLLIterator implements Iterator<E>
	{
		// Attributes
		private E[] copyOfElements;
		private int pos;

		// Constructors
		@SuppressWarnings( "unchecked" )
		public DLLIterator()
		{
			copyOfElements = (E[]) ( new Object[size()] );
			myDLLNode<E> curr = head;

			for( int i = 0; i < size; i++ )
			{
				copyOfElements[i] = curr.getElement();
				curr = curr.getNext();
			}
		}

		
		@Override
		public boolean hasNext()
		{
			return pos < copyOfElements.length;
		}
		
		public boolean hasPrev()
		{
			return pos > 0 && pos < copyOfElements.length;
		}

		/**
		 * Returns the next element in the iteration.
		 * 
		 * @return The next element in the iteration.
		 * @throws NoSuchElementException If the iteration has no more elements.
		 */
		@Override
		public E next() throws NoSuchElementException
		{
			if(!hasNext()) throw new NoSuchElementException();
			E toReturn = copyOfElements[pos];
			pos++;
			return toReturn;
		}
		
		public E prev() throws NoSuchElementException
		{
			if(!hasPrev()) throw new NoSuchElementException();
			E toReturn = copyOfElements[pos];
			pos--;
			return toReturn;
		}
	}

}
