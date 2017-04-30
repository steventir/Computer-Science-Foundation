import java.util.Arrays;

class UniqueString {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: UniqueString string");
			System.exit(1);
		}
	    boolean res = isUniqueChars(args[0]);
		System.out.println(res);
	}

	//if we only care about characters from a - z, or the actually ASCII
	// a-z -> can use a bit vector, ASCII :  128 characters, need boolean[]
	//Suppose we are only given a-z characters
	public static boolean isUniqueChars(String str) {
        //int has 32 bits, which is suitable for 26 letters
	    int checker = 0;

        for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';

			//check
			if ( (checker & (1 << val)) > 0 )
				return false;
			else {
				checker |= (1 << val);
			}

		}

		return true;
	}
}
