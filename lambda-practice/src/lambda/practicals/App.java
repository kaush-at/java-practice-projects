package lambda.practicals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<Car> cars = Arrays.asList(
				new Car("Toyota","Camry", "White", 27000),
				new Car("Toyota","CVR", "Black", 21000),
				new Car("Honda","Accord", "red", 23000),
				new Car("Honda","Civic", "black", 20000),
				new Car("Jeep","XL-R", "mat-black", 33000),
				new Car("Mitshubishi","Lancer", "blue", 17000),
				new Car("Toyota","Primio", "White", 37000));
		
//		printCarsPriceRange(cars, 12000, 23000);
//		printCarsByColor(cars, "Red");
		
		/*
		 * With the lambda expression we no need to invoke above methods
		 * instead of calling above two methods seperately we can call printCars function
		 */
		
		// inside here we have two options
		// 1. create anonymous class definition
		// 2. we can define lambda expression
		
//		 1. Anonymous class definition for printing cars on price
		printCars(cars,new CarCondition() {
			
			@Override
			public boolean test(Car car) {
				
				return car.getPrice() >= 18000 && car.getPrice() <= 25000;
			}
		});
		
		// 1. Anonymous class definition for printing cars on color
		printCars(cars,new CarCondition() {
			
			@Override
			public boolean test(Car car) {
				
				return car.getColor().equalsIgnoreCase("Blue");
			}
		});
		
//		2. using lambda expressions for those two
		// print cars on price
		printCars(cars, (Car car)-> car.getPrice() >= 18000 && car.getPrice() <= 25000);
		
		// 2. 
		printCars(cars,(c)->c.getColor().equalsIgnoreCase("Blue"));
		
	}
	
	
	
/*
 * now we no need these two guys - we only need print car method and we pass another function as its condition

	// print car by price range
	public static void printCarsPriceRange(List<Car> cars, int low, int high) {
		for(Car c : cars) {
			if(c.getPrice() >= low && c.getPrice() <= high) {
				c.printCar();
			}
		}
	}
	
	// print car by color
	public static void printCarsByColor(List<Car> cars, String color) {
		for(Car c : cars) {
			if(c.getColor().equalsIgnoreCase(color)) {
				c.printCar();
			}
		}
	}
 */
	
	
	/*
	 * instead of having these two methods we can write one generic method
	 * 
	 * 
	 */
	public static void printCars(List<Car> cars, CarCondition condition) {
		
		for (Car car : cars) {
			if(condition.test(car)) {
				car.printCar();
			}
		}
	}
	
	/*
	 * Now we have generic function.
	 *  1). next we need to create FunctionalInterface for carCondition (instead of having seperate interface i will create interface in 
	 *  here inside this file)
	 */
	
	
}	
	/*
	 * rather than having so many methods is there any way to provide one method to the user??
	 *  pass in to that method their own conditions
	 *  
	 *  Then lambdas comes to help us to solve this - then we can reduce lines of codes
	 *  
	 *  we could just have one method and allow the user to be able to use lambdas and create their own methods
	 *  
	 */
	 
@FunctionalInterface
interface CarCondition{
	public boolean test(Car car); 
}

/*
 * if we need above first list accept any object list instead of car list  we can change 
 *
 *       interface CarCondition<T>{
 *			public boolean test(T t); 
 *		  }
 *		and so on
 * 
 * 
 * we can use java predefine 
 * public static void printCars(List<Car> cars, predicate<Car> condition) {
 * 
 * it is in java.util.function.Predicate
 * 	in this function package there are a lot of predefine different different functionalInterfaces that we can use within our code
 * 	so we dont have to define our own interfaces
 * predicate eke test eka tiyenwa according to predicate we can change the above code
 * 
 * if you need to go through those interfaces you can find it through 
 * 		docs.oracle.com -> package.java.util.function
 * 
 * 
 * interface Function<T, R> T - type of input to the function  R - type of the result of the function
 *  abstract method inside of that - R apply(T t)
 *   if you go to Function interface we can see default method implementations 
 *   before java 8 it is not possible to do default method implementation but after java8 it is possible
 *   they did this because they need to do this to support the functional programming abilities
 *   
 *   and also they introduce stream api in java 8
 *   without this default method implementation we cannot use stream api
 *   
 *   // according to our example
 *   Function<Car, String> priceAndColor = (c)->{
 *   	return "Price "+c.getPrice() +" color: "+ c.getColor();
 *   }
 *   if this on the same line we can get rid of the parentheses on the lambda expression
 *   
 *   if we want to utilize(prayojanayata gannawa) the priceAndColor variable
 *   we can use 
 *   	String car1 = priceAndColor.apply(cars.get(0))  -> cars.get(0) means car object
 *   sysout(car1) 
 *   priceAndColor ekata anuwa e result eka apply karanawa 1st car ekata list eke tiyena
 *   
 *   so you dont need to write every functionalInterface for your every lambda expression. you can find whole bunch of 
 *   functional interfaces in java.util.function package 
 */






