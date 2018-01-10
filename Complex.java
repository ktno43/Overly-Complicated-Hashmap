public class Complex {
	/************
	 * Fields
	 ************/
	private double real;
	private double imaginary;

	/***************
	 * Constructors
	 ***************/
	public Complex() {
		this.real = 0.0;
		this.imaginary = 0.0;
	}

	public Complex(double real, double img) {
		this.real = real;
		this.imaginary = img;
	}

	/**************************
	 * Complex number toString
	 **************************/
	protected String stringRep() {
		String result = "";

		if (imaginary > 0) {
			result += real + " + " + imaginary + "i";
		}

		else {
			result += real + " - " + imaginary + "i";
		}

		return result;
	}

	/******************
	 * Complex to hash
	 ******************/
	protected static int stringToHash(String input, int offset) {
		int output = 0;

		// For every character convert it to ASCII then modulo it by array size
		for (int i = 0; i < input.length(); i += 1) {
			output += String.valueOf(input.charAt(i)).codePointAt(0);
			output *= 128;
			output %= offset; // to avoid overflow
		}

		return output;
	}

	/*******************
	 * Compare if equal
	 *******************/
	protected boolean isEqual(Complex a) {
		return ((this.real == a.real) && (this.imaginary == a.imaginary));
	}
}
