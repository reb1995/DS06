import java.util.Random;

public class RBSTTest {

	public static void main(String [] args) {
		int [] arr = new int[120];
		Random rand = new Random();
		
		int N = 100;
		
		// Create a random array of numbers between 0 and 99.
		arr[0] = 0;
		for (int i = 1; i < N; i++) {
			int loc = rand.nextInt(i);
			arr[i] = arr[loc];
			arr[loc] = i;
		}

		// Insert the array into a RBST. Since the rank is between 1 and n instead of 0 and n-1, we need to add 1 to i to get the actual rank.
		RBST T = new RBST();
		for (int i = 0; i < N; i++) {
			T.insertNormal(arr[i], i+1);
			//T.insert(arr[i], i+1); // Comment insertNormal and uncomment this line once you have implemented insert.
		}
		
		
		// Check if you got the correct output.
		System.out.println("Printing the sequence as stored in the array");
		for (int i = 0; i < N; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		System.out.println("Printing the sequence as stored in the RBST");
		T.print();

		// Insert a bunch of 100s at 10 random locations, both in the array and the RBST.
		for (int i = 0; i < 10; i++) {
			int loc = rand.nextInt(N+i);

			// Insert 100 at that location in the array.
			for (int j = N+i; j > loc; j--)
				arr[j] = arr[j-1];
			arr[loc] = 100;

			// Insert 100 at that location in the BST.
			T.insertNormal(100, loc+1);
			//T.insert(100, loc+1); // Comment insertNormal and uncomment this line once you have implemented insert.
		}

		// Print both the array and the RBST and check if they are the same sequence.
		System.out.println("Printing the sequence as stored in the array");
		for (int i = 0; i < N+10; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		System.out.println("Printing the sequence as stored in the RBST");
		T.print();
				
		// Insert 5 200s at the beginning.
		for (int i = 0; i < 5; i++) {
			int loc = 0;
			for (int j = N+10+i; j > loc; j--)
				arr[j] = arr[j-1];
			arr[loc] = 200;	

			T.insertNormal(200, 1);
			//T.insert(200, 1);		// Comment insertNormal and uncomment this line once you have implemented insert.
		}
		// Insert 5 300s at the end.
		for (int i = 0; i < 5; i++) {
			int loc = N+15+i;
			arr[loc] = 300;	

			T.insertNormal(300, T.getSize()+1);
			//T.insert(300, T.getSize()+1);	// Comment insertNormal and uncomment this line once you have implemented insert.
		}

		// Check if you got the correct output.
		System.out.println("Printing the sequence as stored in the array");
		for (int i = 0; i < N+20; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		System.out.println("Printing the sequence as stored in the RBST");
		T.print();

		
		/* // Uncomment these once you have implemented select.

		System.out.println("Printing the sequence using the select operation");
		for (int i = 1; i <= T.getSize(); i++) {
			Node x = T.select(i);
			System.out.print(x.getTeam() + " ");
		}
		System.out.println();

		*/

		/*	// Uncomment this multi-line comment once you have tested insertNormal, and have completed split.
				// Do not attempt to execute these without thoroughly testing either insertNormal or insert. 
				// Once you have tested insertNormal, you may comment them again when you are implementing and testing
				// insert. Then after you have thoroughly tested insert, you may uncomment again.

				
		// Do a couple of splits in the middle.
		RBST [] S;
		S = T.split( 50);
		System.out.println("Splitting T at rank 50");
		System.out.println("Printing the left side of the split.");
		S[0].print();
		System.out.println("Printing the right side of the split.");
		S[1].print();
		
		RBST [] R;
		R = S[0].split(25);
		System.out.println("Splitting left side at rank 25");
		System.out.println("Printing the left side of the second split.");
		R[0].print();
		System.out.println("Printing the right side of the split.");
		R[1].print();

		// Do a split at the beggining and end.
		RBST [] U = R[0].split(R[0].getSize()-1);
		System.out.println("Splitting the above left side again on the last index.");
		System.out.println("Printing the left side of the third split.");
		U[0].print();
		System.out.println("Printing the right side of the split.");
		U[1].print();

		RBST [] V = U[0].split(1);
		System.out.println("Splitting the above left side again on the first index.");
		System.out.println("Printing the left side of the third split.");
		V[0].print();
		System.out.println("Printing the right side of the split.");
		V[1].print();

		*/
	}
}
