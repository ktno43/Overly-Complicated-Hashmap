class HashNodeV2<V> {
	/************
	 * Fields
	 ************/
	private Complex key;
	private V value;

	/**************
	 * Constructor
	 **************/
	public HashNodeV2(Complex key, V value) {
		this.key = key;
		this.value = value;
	}

	/**********
	 * Get key
	 **********/
	public Complex getKey() {
		return this.key;
	}

	/************
	 * Get value
	 ************/
	public V getValue() {
		return this.value;
	}

	/**********
	 * Set key
	 **********/
	public void setKey(Complex key) {
		this.key = key;
	}

	/************
	 * Set value
	 ************/
	public void setValue(V value) {
		this.value = value;
	}
}
