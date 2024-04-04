/**
 * 
 */
package utilities;

/**
 * 
 */
public class MyQueue<E> implements QueueADT<E>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5029569235075201378L;
	private myDLL<E> queue;

    public MyQueue() {
        queue = new myDLL<>();
    }

	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		if(toAdd == null)
		{
			throw new NullPointerException("Error in enqueue");
		}
		queue.add(toAdd);		
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException("Error in dequeue");
		return(queue.remove(0));
	}

	@Override
	public E peek() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException("Error in peek");
		return(queue.get(0));
	}

	@Override
	public void dequeueAll() {
		queue.clear();
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return queue.iterator();
	}

	@Override
	public boolean equals(QueueADT<E> that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return queue.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if(holder == null)
		{
			throw new NullPointerException("Error in toArray(holder)");
		}
		
		holder = queue.toArray(holder);
		
		
		
		return holder;
	}

	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return queue.size();
	}

	//This was an optional method 
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}


	

}
