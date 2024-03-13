package utilities;

import java.io.Serializable;


public class myDLLNode<E> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6501885257007023475L;
	private E element;
	private myDLLNode<E> prev, next;
	
	public myDLLNode(E elem, myDLLNode<E> prev, myDLLNode<E> next)
	{
		this.element = elem;
		this.prev = prev;
		this.next = next;
	}
	
	public myDLLNode(E elem)
	{
		this.element = elem;
	}
	
	public E getElement()
	{
		return element;
	}

	/**
	 * Method to set the of element.
	 * 
	 * @param element the new element of the node.
	 */
	public void setElement( E element )
	{
		this.element = element;
	}

	/**
	 * Method to return the value of next.
	 * 
	 * @return reference to the next node, null if there's no next node.
	 */
	public myDLLNode<E> getNext()
	{
		return next;
	}

	/**
	 * Method to set the value of next.
	 * 
	 * @param next reference to the next node to set.
	 */
	public void setNext( myDLLNode<E> next )
	{
		this.next = next;
	}
	
	/**
	 * Method to return the value of previous.
	 * 
	 * @return reference to the previous node, null if there's no previous node.
	 */
	public myDLLNode<E> getPrev()
	{
		return prev;
	}

	/**
	 * Method to set the value of previous.
	 * 
	 * @param previous reference to the previous node to set.
	 */
	public void setPrev( myDLLNode<E> prev )
	{
		this.prev = prev;
	}

	
}
