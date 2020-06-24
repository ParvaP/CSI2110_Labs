/**
 * Array Heap implementation of a priority queue
 * @author Lachlan Plant
 */
public class HeapPriorityQueue<K extends Comparable,V> implements PriorityQueue<K ,V> {

	private Entry[] storage; //The Heap itself in array form
	private int tail;        //Index of last element in the heap

	/**
	 * Default constructor
	 */
	public HeapPriorityQueue(){
		this(10);
	}

	/**
	 * HeapPriorityQueue constructor with max storage of size elements
	 */
	public HeapPriorityQueue(int size){
		this.storage = new Entry[size];
		this.tail = 0;
	}

	/****************************************************
	 *
	 *             Priority Queue Methods
	 *
	 ****************************************************/

	/**
	 * Returns the number of items in the priority queue.
	 * O(1)
	 * @return number of items
	 */
	public int size(){
		return tail;
	}

	/**
	 * Tests whether the priority queue is empty.
	 * O(1)
	 * @return true if the priority queue is empty, false otherwise
	 */
	public boolean isEmpty(){
		return tail == 0;
	}

	/**
	 * Inserts a key-value pair and returns the entry created.
	 * O(log(n))
	 * @param key     the key of the new entry
	 * @param value   the associated value of the new entry
	 * @return the entry storing the new key-value pair
	 * @throws IllegalArgumentException if the heap is full
	 */
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{

		if (tail == storage.length) {
			throw new IllegalArgumentException();
		}
		Entry ent = new Entry(key,value);
		storage[tail] = ent;
		upHeap(tail);
		tail++;

		return ent;

	}

	/**
	 * Returns (but does not remove) an entry with minimal key.
	 * O(1)
	 * @return entry having a minimal key (or null if empty)
	 */
	public Entry<K,V> min(){
		return (tail!=0)?storage[0]:null;
	}

	/**
	 * Removes and returns an entry with minimal key.
	 * O(log(n))
	 * @return the removed entry (or null if empty)
	 */
	public Entry<K,V> removeMin(){
		if (tail == 0) {
			return null;
		} else if (tail == 1) {
			return storage[--tail];
		}

		--tail;
		Entry rTemp = storage[0];
		swap(0, tail);
		downHeap(0);
		return rTemp;
	}  


	/****************************************************
	 *
	 *           Methods for Heap Operations
	 *
	 ****************************************************/

	/**
	 * Algorithm to place element after insertion at the tail.
	 * O(log(n))
	 */
	private void upHeap(int location){
		int head = location;
		while(storage[head].getKey().compareTo(storage[parent(head)].getKey()) < 0) {
			swap(head, parent(head));
			head = parent(head);
		}
	}

	/**
	 * Algorithm to place element after removal of root and tail element placed at root.
	 * O(log(n))
	 */
	private void downHeap(int location){
		int i = location;
		boolean flag = false;

		while (flag == false) {
			if (i*2+1 < tail && i*2+2 < tail) {
				if (storage[i*2+1].getKey().compareTo(storage[i*2+2].getKey()) < 0) {
					if (storage[i*2+1].getKey().compareTo(storage[i].getKey()) < 0) {
						swap(i,i*2+1);
						i = i*2+1;
						//System.out.println("Hello1");
					} else {
						flag = true;
						//System.out.println("Hello1");
					}
				} else {
					if (storage[i*2+2].getKey().compareTo(storage[i].getKey()) < 0) {
						swap(i,i*2+2);
						i = i*2+2;
						//System.out.println("Hello2");
					} else {
						flag = true;
						//System.out.println("Hello2");
					}
				}
			}else if (i*2+1 < tail) {
				if (storage[i*2+1].getKey().compareTo(storage[i].getKey()) < 0) {
					swap(i,i*2+1);
				}
				flag = true;
			} else {
				flag = true;
			}
		}
	}

	/**
	 * Find parent of a given location,
	 * Parent of the root is the root
	 * O(1)
	 */
	private int parent(int location){
		return (int)Math.floor((location - 1) / 2);
	}


	/**
	 * Inplace swap of 2 elements, assumes locations are in array
	 * O(1)
	 */
	private void swap(int location1, int location2){
		Entry temp = storage[location1];
		storage[location1] = storage[location2];
		storage[location2] = temp;
	}

}