/**
* Represents a Pair of values.
*
* @author Zach T-Good
*/

public class Pair<FirstType, SecondType> {
	
	//the first element in the pair
	private FirstType first;
	private SecondType second;
	
	/**
	* Class constructor.
	*
	* @param first The first element in this Pair.
	* @param second The second element in this Pair.
	*/
	
	/**
	* Returns a String representation of this Pair.
	*
	*
	* @return A String, "(X,Y)", where X is the first element and Y is the second element.
	*/
	
	public String toString(){
		return "(" + this.first + ", " + this.second + ")";
	}
	
	public Pair(FirstType first, SecondType second){
		this.first = first;
		this.second = second;
	}
	
	/**
	* Sets the first element.
	*
	* @param newFirst The value to set the first element to.
	*/
	public void setFirst(FirstType newFirst){
		this.first = newFirst;
	}
	
	/**
	* Sets the second element.
	*
	* @param newSecond The value to set the second element to.
	*/
	public void setSecond(SecondType newSecond){
		this.second = newSecond;
	}
	
	/**
	* Returns the first element.
	*
	* @return The first element in this.
	*/
	public FirstType getFirst(){
		return this.first;
	}
	
	/**
	* Returns the second element.
	*
	* @return The second element in this.
	*/
	public SecondType getSecond(){
		return this.second;
	}
	
	/**
	* Tests whether two Pairs are equal.
	*
	* @param other Another pair that might be equivalent to this.
	* @return True if both the first element of this equals the first element of other
		and the second element of this equals the second element of the other, false otherwise.
		*/
	public boolean equals(Pair<FirstType, SecondType> other){
		boolean firstsEqual = this.getFirst().equals(other.getFirst());
		boolean secondsEqual = this.getSecond().equals(other.getSecond());
		return firstsEqual && secondsEqual;
	}
	
	/**
	* Returns whether this equals another object.
	*
	* @param obj The object to determine equivalence with this.
	* @return True if obj is a Pair with elements equivalent to this, false otherwise.
	*/
	public boolean equals (Object obj){
		try{
			Pair<FirstType, SecondType> other = (Pair<FirstType, SecondType>) obj;
			return this.equals(other);
		} catch (ClassCastException e){
			return false;
		}
	}
	
	/**
	* Returns a pair with the elements swapped.
	*
	* @return A new pair with the elements in reverse order.
	*/
	public Pair<SecondType, FirstType> getReverse(){
		return new Pair<SecondType, FirstType>(this.getSecond(), this.getFirst());
	}
	
	
	/**
	* Unit test.
	*
	* @param args Command-line parameters for this test. Currently unused.
	*/
	
	public static void main(String[] args){
		boolean allCorrect = true;
		
		String success = "Test completed successfully!";
		String failure = "Something went wrong!!!!!!!!!!!!";
		
		Pair<String, Integer> twoThings = new Pair<String, Integer>("Hi", new Integer(5));
		String output = twoThings.toString();
		System.out.println("twoThings: " + output);
		boolean isCorrect = output.equals("(Hi, 5)");
		allCorrect = allCorrect && isCorrect;
		System.out.println((isCorrect ? success : failure));
		
		//output = (String) twoThings.getFirst();
		
		output = twoThings.getFirst();
		isCorrect = output.equals("Hi");
		allCorrect = allCorrect && isCorrect;
		System.out.println((isCorrect ? success : failure));
		
		//further tests will go here.
		
		Pair<Integer, String> pair = new Pair<Integer, String>(6, "Hi");
		Integer integer = pair.getFirst();
		isCorrect = integer.equals(6);
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;
		
		Pair<String, Integer> things = new Pair<String, Integer>("Beluga", 56);
		
		//Testing the Second return
		
		Integer num = twoThings.getSecond();
		isCorrect = num.equals(5);
		allCorrect = allCorrect && isCorrect;
		System.out.println((isCorrect ? success : failure));
		//System.out.println(num);
		
		//Testing setFirst Method with Integer
		
		pair.setFirst(-124);
		integer = pair.getFirst();
		isCorrect = integer.equals(-124);
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;
		
		//Testing setFirst Method with String
		Pair<String, Integer> stinger = new Pair<String, Integer>("Buzz", 69);
		
		stinger.setFirst("Beedrill");
		isCorrect = stinger.getFirst().equals("Beedrill");
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;
		/*
		~failed testing~
		
		Pair<String, Integer> sting = new Pair<String, Integer>("camel", 0);
		pair.setFirst().toString("camel");	
		sting = pair.getFirst();
		isCorrect = sting.equals("camel");
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;
		
		*/
		
		//Step 25
		// Don't need: ~ isCorrect = sting.equals("camel", 0); 
		
		//Testing setSecond Method with Integer
		
		Pair<String, Integer> number = new Pair<String, Integer>("Wood", 8);
		
		number.setSecond(3);
		num = number.getSecond();
		isCorrect = num.equals(3);
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;
	
		//Testing setSecond Method with String
		Pair<Integer, String> stick = new Pair<Integer, String>(6, "Hello");
		
		stick.setSecond("Hi");
		isCorrect = stick.getSecond().equals("Hi");
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;

		//Part 27 Unit Test Code
		pair = new Pair<Integer, String>(16, "beluga");
		Pair<Integer,String> otherPair = new Pair<Integer, String>(16, "beluga");
		System.out.println("Now testing whether " + pair + " equals " + otherPair + ":");
		isCorrect = pair.equals(otherPair);
		System.out.println(isCorrect);
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;
		
		//Checks two integer-string pairs with the same values. ~returns true~
		pair = new Pair <Integer, String>(7, "hello");
		Pair<Integer, String> otherPear = new Pair<Integer, String>(7, "hello");
		System.out.println("Now testing whether " + pair + " equals " + otherPear + ":");
		System.out.println(isCorrect);
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;

		//Checks two integer-string pairs with different values. ~returns false~
		pair = new Pair <Integer, String>(7, "hello");
		Pair<Integer, String> otherOne = new Pair<Integer, String>(6, "hi");
		System.out.println("Now testing whether " + pair + " equals " + otherOne + ":");
		isCorrect = !pair.equals(otherOne);
		System.out.println(isCorrect);
		
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;

		//Checks two string-string pairs with same values. ~returns true~
		Pair<String, String> Pear = new Pair<String,String>("hi", "hello");
		Pair<String, String> otherHere = new Pair<String, String>("hi", "hello");
		System.out.println("Now testing whether " + Pear + " equals " + otherHere + ":");
		isCorrect = Pear.equals(otherHere);
		System.out.println(isCorrect);
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;

		
		//Two String-String pairs with different values ~returns false~
		Pair<String, String> Pears = new Pair<String,String>("hola", "bonjour");
		Pair<String, String> otherHair = new Pair<String, String>("hi", "hello");
		System.out.println("Now testing whether " + Pears + " equals " + otherHair + ":");
		isCorrect = !Pears.equals(otherHair);
		System.out.println(isCorrect);
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;

		
		
		//One integer-integer pair and one integer-string pair. ~returns false~
		pair = new Pair<Integer, String>(16, "Hi");
		otherPair = new Pair <Integer, String>(16, "Hi");
		System.out.println("Now testing whether " + pair + " equals " + otherPair + ":");
		isCorrect = ((Object) pair).equals(otherPair);
		System.out.println(isCorrect);
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;
		
		
		/*
		isCorrect = pair.equals((Object) otherPair);
		System.out.println(isCorrect);
		*/
		
		
		//Part 30 testing
		isCorrect = ((Object) pair).equals(otherPair);
		System.out.println(isCorrect);
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;

		//Part 31 Reverse Order <String, Integer>
		//twoThings = new Pair<String, Integer>("Tg", 6);
		Pair<String, Integer> clock = new Pair<String, Integer>("Hi", 0); 
		Pair<Integer, String> hands = new Pair<Integer, String>(0,"Hi");
		pair = clock.getReverse();
		isCorrect = ((Object) pair).equals(hands);
		System.out.println(pair);
		System.out.println(isCorrect);
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;
		
		//Part 31 Reverse Order <String, String>
		Pair<String, String> more = new Pair<String, String>("Hola", "Hello"); 
		Pair<String, String> next = new Pair<String, String>("Hello", "Hola");
		more = more.getReverse();
		System.out.println(more);
		isCorrect = ((Object) more).equals(next);
		System.out.println(isCorrect);
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;
		
		//Part 31 Reverse Order <Integer, Integer>
		Pair<Integer, Integer> squirt = new Pair<Integer, Integer>(1, 2); 
		Pair<Integer, Integer> moisture = new Pair<Integer, Integer>(2, 1);
		squirt = squirt.getReverse();
		System.out.println(squirt);
		isCorrect = ((Object) squirt).equals(moisture);
		System.out.println(isCorrect);
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;
		
		//Part 31 Reverse Order <Integer, String>
		Pair<Integer, String> wet = new Pair<Integer, String>(4, "Pig"); 
		Pair<String, Integer> moist = new Pair<String, Integer>("", 2); 
		clock = new Pair <String, Integer>("Pig", 4);
		moist = wet.getReverse();
		System.out.println(moist);
		isCorrect = ((Object) moist).equals(clock);
		System.out.println(isCorrect);
		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;
		
		
		//Reference from above code
		/*
		Pair<String, Integer> number = new Pair<String, Integer>("Wood", 8);
		
		number.setSecond(3);
		num = number.getSecond();
		isCorrect = num.equals(3);
		*/




		System.out.println((isCorrect ? success : failure));
		allCorrect = allCorrect && isCorrect;
		
		System.out.println((allCorrect ? "All tests were successful!" : "At least one test failed!"));
	}
	
}