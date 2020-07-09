
public class App2MorePracticeLambda {

	public static void main(String[] args) {
		// method 1-conversion
		// this is how we convert the below sayHello to lambda expression 
		// 1 ) create ()-> System.out.println("Hello there...");
		// 2 ) assign this in to functional interface type  LambdaInterface var = ()-> System.out.println("Hello there...");
		
		LambdaInterface helloVar = ()-> System.out.println("Hello there...");
		helloVar.someMethod();
		
		// method 2-conversion
		// how do we convert sum method into lambda expression
		//So what is the lambda expression really - They are block of code used to implement a method defined by a functional interface.
		// in here both of LmabdaInterface and Walkable type cannot be use because those we cannot pass arguments
		LambdaExWitParam sumVar2 = (a, b)-> a+b;
		System.out.println(sumVar2.calculation(3, 7));
		
		// method 3-conversion
		// 3rd method lambda implementation
		// godak welawata mata peena widiyata interface hadanne parameter pass karana eka saha return value eka anuwa type eka gnna
		// pahala athi method kabda eka athulet define karanawa e widiyatama
		LambdaExWitParam devide = (a, b)->{
			if(a==0) {
				return 0;
			}
			return a/b;
		};
		System.out.println(devide.calculation(10, 2));
		
		// method 4-conversion to lambda expression
		LambdaWithStringPassing reverseString = (string)->{
			String result = "";
			for (int i = 0; i < string.length(); i++) {
				result = string.charAt(i)+result;
			}
			return result;
		};
		System.out.println(reverseString.handleString("Hello"));
		
		// method 5-conversion to lambda expression
		LambdaParseSingleInteger factorialEx = (number)->{
			int result = 1;
			for (int i = 1; i <= number; i++) {
				result = result * i;
			}
			return result;
		};
		System.out.println(factorialEx.parseSingleInt(5));
		 
	}
	
	/*
	 * end of main method
	 */
	 
	/*
	 * What is real benefit of using lambda expressions
	 * 
	 * it is not just about using less code to do something
	 * lambdas allows us to disassociate a set of instructions from an object
	 * 
	 * In java everything is an object and if you want to run some kind of functionality that functionality needs to be a 
	 * part of an object or part of a class.
	 * lambda breaks that association where we can create these non associated methods or functions
	 * lambda allows this seperation of behavior from an object
	 * 
	 * you can have blocks of code that no longer need to be associated with a given object
	 * 
	 * these block of code can pass arround as arguments to other methods 
	 * 
	 * it allows for more succinct(luhudu/keti) code / right less line of code
	 * (but you might think we have to create interface for create lambda expressions)
	 * yes good NEWS
	 * 		java 8 comes with bunch of functionalInterfaces (built in functionalInterfaces)
	 * 					that we can use in our program
	 * 
	 *  we are switching the object oriented programming to the way of functional programming by using lambda expression
	 *  (this is the main function in java 8) 
	 *  the real reason is to compete with other programming languages in data processing
	 *  
	 *  other languages are actually better performing bulk operations on series of data.
	 *  in java you have to do it with collection it does make it very easy but you have to do it in object oriented way
	 *  and that could there are a lot of code involved in for that
	 *  
	 *  using lambda to do bulk operations on collections is far more succinct 
	 *  
	 *  (lambda expression hadunwa dunnet work with collection of data in a far more succinct and expressive way to 
	 *  compete with other programming languages ) / code is more readable and expressive when using collections with lambdas
	 *  
	 */
	
	
	/*
	 * 	we can make our interfaces more generic 
	 * 	factorialEx = (number) & reverseString = (string) => both of this methods we pass some type and return the same type
	 *	we can create that interface like this
	 * 			
	 * 			public interface MyGenerics<T> {
	 *              public T handleString(T t);
	 *		    }
	 * 
	 * then we can use commonly instead of above two interface (for both the lambda expression)
	 * 		ex/
	 * 			MyGenerics<String> factorialEx = (number){} 
	 * 
	 */
	
	
	// 1 -method
	public static void  sayHello() {
		System.out.println("Hello there...");
	}
	
	// 2 -method
	public int sum(int arg1, int arg2) {
		return arg1+arg2;
	}

	// 3 -method
	public int nonZeroDevide(int arg1, int arg2) {
		if(arg1==0) {
			return 0;
		}
		return arg1/arg2;
	}
	
	// 4 - method
	public String reverse(String str) {
		String result = "";
		for (int i = 0; i < str.length()-1; i++) {
			result = str.charAt(i)+result;
		}
		return result;
	}
	
	// 5 - method
	public int factorial(int num) {
		int result = 1;
		for (int i = 1; i <= num; i++) {
			result = result * i;
		}
		return result;
	}
	
}
