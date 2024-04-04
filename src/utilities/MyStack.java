package utilities;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyStack<E> implements StackADT<E>
{

	private static final long serialVersionUID = 2357999674110532529L;
	private myArrayList<E> stack;

	public MyStack() 
	{
		stack = new myArrayList<E>();
	}

	@Override
	public int size() 
	{
		return stack.size();
	}

	@Override
	public void clear() 
	{
		stack.clear();
	}

	@Override
	public boolean push(E toAdd)throws NullPointerException
	{
		return stack.add(toAdd);
	}

	@Override
	public int search(E toFind) throws NullPointerException 
	{
		if(toFind == null)
			throw new NullPointerException();
		for(int i = 0; i < stack.size(); i++) 
		{
			if(stack.get(i) == toFind) return i;
		}
		return -1;
	}

	@Override
	public E peek() throws EmptyStackException 
	{
		if(stack.isEmpty())
			throw new EmptyStackException();
		return stack.get(stack.size()-1);
	}

	@Override
	public E pop() throws EmptyStackException 
	{
		if(stack.isEmpty())
			throw new EmptyStackException();
		return stack.remove(stack.size()-1);
	}

	@Override
	public boolean isEmpty() 
	{
		return stack.isEmpty();
	}

	@Override
	public Iterator<E> iterator() 
	{
		return (Iterator<E>)new ArrayBasedIterator();
	}
	
	
	private class ArrayBasedIterator implements Iterator<E>
	{
 
		private E[] copyOfElements;
		private int pos;
		
		@SuppressWarnings("unchecked")
		public ArrayBasedIterator()
		{
			copyOfElements = (E[]) new Object[size()];
			System.arraycopy(stack.toArray(), 0, copyOfElements, 0, copyOfElements.length);
		}
		@Override
		public boolean hasNext()
		{
			return pos < copyOfElements.length;
		}
 
		@Override
		public E next() throws NoSuchElementException
		{
			if(pos == copyOfElements.length)
				throw new NoSuchElementException();
			return copyOfElements[pos++];
		}
		
	}
}