import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;

public class MapV2<V> {
	/************
	 * Fields
	 ************/
	private int size; // # of elements in the array
	private int capacity; // maximum # of elements array can hold
	private ArrayList<LinkedList<HashNodeV2<V>>> table; //

	/**************
	 * Constructor
	 **************/
	public MapV2() { // default constructor
		this.table = new ArrayList<LinkedList<HashNodeV2<V>>>(); // create a new list
		this.capacity = 2; // first prime number
		this.size = 0; // no elements in the list

		for (int i = 0; i < this.capacity; i += 1) {
			this.table.add(null); // populate list with null values
		}
	}

	/***************
	 * Get capacity
	 ***************/
	public int getCapacity() {
		return this.capacity;
	}

	/***********
	 * Get size
	 ***********/
	public int getSize() {
		return this.size;
	}

	/****************
	 * Check if empty
	 ****************/
	public boolean isEmpty() {
		return (this.getSize() == 0);
	}

	/***********
	 * Hash key
	 ***********/
	private int hashKey(Complex key) { // hash the complex key
		return Complex.stringToHash(key.stringRep(), this.capacity);
	}

	/***************
	 * Add a bucket
	 ***************/
	public void add(Complex key, V value) { //
		int hashKey = hashKey(key); // get hash for key

		if (this.table.get(hashKey) == null) { // if null, make a new linked list here
			this.table.set(hashKey, new LinkedList<HashNodeV2<V>>());
		}

		LinkedList<HashNodeV2<V>> myList = this.table.get(hashKey); // get linked list at that hash key

		for (HashNodeV2<V> e : myList) { // for every element in the linked list
			if (e.getKey().isEqual(key)) {// if keys matched just update the value
				e.setValue(value);
				return;
			}
		}

		this.table.get(hashKey).add(new HashNodeV2<V>(key, value)); // add node with given (key, value) pair to linked list at that hash key

		this.size += 1; // increase size by 1
		needResize(); // need resize?
	}

	/******************
	 * Remove a bucket
	 ******************/
	public V remove(Complex key) {
		int hashKey = hashKey(key); // get hash for key
		HashNodeV2<V> toRemoveNode = null; // value for removed node
		LinkedList<HashNodeV2<V>> myList = this.table.get(hashKey); // get linked list at that hash key

		if (myList == null) {// if there's no linked list, nothing to delete
			return null;
		}

		for (HashNodeV2<V> e : myList) { // for every element in the linked list
			if (e.getKey().isEqual(key)) { // if the keys matched return the value
				toRemoveNode = e;
			}
		}

		if (toRemoveNode == null) // couldn't find matching key
			return null;

		else { // match found
			myList.remove(toRemoveNode); // remove the current node
			this.size -= 1; // decrease the size
			return toRemoveNode.getValue(); // get the value of the removed node
		}
	}

	/**********************
	 * Get a bucket at key
	 **********************/
	public V get(Complex key) { // get node's value given a key
		int hashKey = hashKey(key); // get hash for key
		LinkedList<HashNodeV2<V>> myList = this.table.get(hashKey); // get linked list at that hash key

		if (myList == null) { // if there's no linked list, nothing to retrieve
			return null;
		}

		for (HashNodeV2<V> e : myList) { // for every element in the linked list
			if (e.getKey().isEqual(key)) {// if the keys matched return the value
				return e.getValue();
			}
		}

		return null; // no keys matched so return null
	}

	/********************
	 * Resize array list
	 ********************/
	private void needResize() {
		if ((1.0 * this.size) / this.capacity > 0.7) { // If the size is >70% full, resize
			int prevCapacity = this.capacity; // reference to old capacity
			ArrayList<LinkedList<HashNodeV2<V>>> oldBucketArr = this.table; // reference to old array list
			this.table = new ArrayList<LinkedList<HashNodeV2<V>>>(); // create a new list
			this.capacity = nextPrime(this.size); // get the closest prime number to the size (# of elements)

			while (this.capacity <= prevCapacity) { // if the new capacity was <= to the old one, keep changing it until it satisfies the condition
				this.capacity = nextPrime(this.capacity);
			}

			this.size = 0; // size is 0 (new list)

			for (int i = 0; i < this.capacity; i += 1) { // populate list with null values for the new capacity
				this.table.add(null);
			}

			for (LinkedList<HashNodeV2<V>> e : oldBucketArr) { // for every linked list in the array list
				if (e != null) { // if the linked list is not empty iterate through the linked list
					for (HashNodeV2<V> f : e) { // for every node in the linked list
						if (f != null) { // if the node's aren't empty add them to the newly created list
							add(f.getKey(), f.getValue());
						}
					}
				}
			}
		}
	}

	/********************
	 * Get closest prime
	 ********************/
	private static int nextPrime(long n) {
		BigInteger b = new BigInteger(String.valueOf(n));
		return Integer.parseInt(b.nextProbablePrime().toString());
	}
}
