import java.text.DecimalFormat;

public class main {

	public static void main(String[] args) {
		DecimalFormat format = new DecimalFormat("##.00");

		MapV2<Integer> myMap = new MapV2<Integer>();
		System.out.println("List of prime numbers from 1 to 100:");
		System.out.println(
				"2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97");
		System.out.println();
		System.out.println("Is the hash map empty?  " + myMap.isEmpty());
		System.out.println("How many elements are in the hash map?  " + myMap.getSize());
		System.out.println("What's the maximum capacity?  " + myMap.getCapacity());
		System.out.println("How full is the current array list?  "
				+ format.format((1.0 * myMap.getSize()) / myMap.getCapacity() * 100) + "%");

		myMap.add(new Complex(1, 20), 2);
		myMap.add(new Complex(2, 19), 4);
		myMap.add(new Complex(3, 18), 6);
		myMap.add(new Complex(4, 17), 9);
		myMap.add(new Complex(5, 16), 10);

		myMap.add(new Complex(6, -15), -12);
		myMap.add(new Complex(7, -14), -14);
		myMap.add(new Complex(8, -13), -16);
		myMap.add(new Complex(9, -12), -18);
		myMap.add(new Complex(10, -11), -20);

		myMap.add(new Complex(-11, 10), 22);
		myMap.add(new Complex(-12, 9), 24);
		myMap.add(new Complex(-13, 8), 26);
		myMap.add(new Complex(-14, 7), 28);
		myMap.add(new Complex(-15, 6), 30);

		myMap.add(new Complex(-16, -5), -32);
		myMap.add(new Complex(-17, -4), -34);
		myMap.add(new Complex(-18, -3), -36);
		myMap.add(new Complex(-19, -2), -38);
		myMap.add(new Complex(-20, -1), -40);

		System.out.println();
		System.out.println("Is the hash map empty?  " + myMap.isEmpty());
		System.out.println("How many elements are in the hash map?  " + myMap.getSize());
		System.out.println("What's the maximum capacity?  " + myMap.getCapacity());
		System.out.println("How full is the current array list?  "
				+ format.format((1.0 * myMap.getSize()) / myMap.getCapacity() * 100) + "%");
		System.out.println();

		System.out.println("Array will resize if we add 1 more element. . .");
		System.out.println("21 / 29 =  " + format.format(21.0 / 29 * 100) + "%");
		System.out.println("Adding another element. . .");
		myMap.add(new Complex(21, -21), 8999);
		
		System.out.println();
		System.out.println("How many elements are in the hash map?  " + myMap.getSize());
		System.out.println("What's the maximum capacity?  " + myMap.getCapacity());
		System.out.println("How full is the current array list?  "
				+ format.format((1.0 * myMap.getSize()) / myMap.getCapacity() * 100) + "%");
		System.out.println();

		System.out.println("What's at the key \"1 + 20i\" ?  " + myMap.get(new Complex(1, 20)));
		System.out.println("What's at the key \"10 - 11i\" ?  " + myMap.get(new Complex(10, -11)));
		System.out.println("What's at the key \"-13 + 8i\" ?  " + myMap.get(new Complex(-13, 8)));
		System.out.println("What's at the key \"-19 - 2i\" ?  " + myMap.get(new Complex(-19, -2)));
		System.out.println("What's at the key \"8999 + 2i\" ?  " + myMap.get(new Complex(8999, 2)));

		System.out.println();
		System.out.println("What's at the key \"3 + 18i\" ?  " + myMap.get(new Complex(3, 18)));
		System.out.println("Removing " + myMap.remove(new Complex(3, 18)) + " stored at \"3 + 18i\" ");
		System.out.println("What's at the key \"3 + 18i\" ?  " + myMap.get(new Complex(3, 18)));

		System.out.println();
		System.out.println("How many elements are in the hash map?  " + myMap.getSize());
		System.out.println("What's the maximum capacity?  " + myMap.getCapacity());
		System.out.println("How full is the current array list?  "
				+ format.format((1.0 * myMap.getSize()) / myMap.getCapacity() * 100) + "%");
		System.out.println();
	}
}
