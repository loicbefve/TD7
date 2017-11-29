/**
 * 
 */
package heap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Loïc
 *
 */
public class HeapArray<E> implements Heap<E> {
	
	Object heap[];
	int capacity;
	int size;
	Comparator<? super E> comparator;
	

	/**
	 * Constructor of the HeapArray class
	 * @return an initialize HeapArray
	 */
	public HeapArray(int capacity, Comparator<? super E> comparator) {
		this.heap = new Object[capacity];
		this.capacity = capacity;
		this.size = 0;
		this.comparator = comparator;
	}

	
	/** Add specified element into this Heap, if there is enough space
	 * or if smaller than the current highest element
	 * 
	 * @return true if the element was successfully added
	 */
	public boolean insertElement(E e) {
		//Insertion of the element e at the end of the heap[]//
		if( this.isFull()) {
			System.out.println("Already empty!!");
			return false;
		}
		this.heap[size] = e;
		//Search if the value at the final position is at the good place and change the size
		return goodPlace( this.size++ );
	}
	
	
	/**
	 * Check if a value at the index given is at the good place
	 */
	@SuppressWarnings("unchecked")
	private boolean goodPlace(int index) {
		//Get the parent index
		if( index == 0) {
			return true;
		}
		else {
			int parentIndex = (index-1)/2;
			E parent = (E) this.heap[parentIndex];
			E toPlace = (E) this.heap[index];
			//If parent value is bigger than index value OK.
			int comp = this.comparator.compare( parent, toPlace );
			if( comp > 0 ) {
						return true;
			}
			//If not we switch
			else if (this.comparator.compare( parent, toPlace ) < 0) {
				E commute = (E) this.heap[parentIndex];
				this.heap[parentIndex] = toPlace;
				this.heap[index] = commute;
				return goodPlace( parentIndex );
			}
			System.out.println("Already inside, you can't do this!");
			return false;
		}
		
		
	}
	
	public boolean isFull() {
		return this.size == this.capacity;
	}
	
	@SuppressWarnings("unchecked")
	public E element() {
		if( this.isEmpty() ) {
			throw new NoSuchElementException();
		}
		else {
			return  (E) this.heap[0]; //TODO: Retourner vraiment un E
		}
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int size() {
		return this.size;
	}

	public Iterator<E> iterator() {
		return new HeapIterator();
	}
	
	//----------------Iterator Class ------------------//
		private class HeapIterator implements Iterator<E>{
			int pos = 0;
			
			@Override
			public boolean hasNext() {
				return pos < size-1;
			}

			@Override
			public E next() {
				if(this.hasNext()) {
					@SuppressWarnings("unchecked")
					E retour = (E) heap[pos];
					pos++;
					return retour;
				}
				else {
					throw new NoSuchElementException();
				}
			}
		}
		//--------------------------------------------------//
}
