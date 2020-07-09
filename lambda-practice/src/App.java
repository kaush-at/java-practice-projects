
public class App {

	public static void main(String[] args) {

		Human tom = new Human();
		//tom.walk();
		walker(tom);
		
		Robot shelly = new Robot();
		//shelly.walk();
		walker(shelly);
		
	/*
	 * 2nd note -
	 * if we invoke walker() method inside here it expects  instance of a class that implement walkable interface
	 * (object ekak expect karanawane) walker(Walkable walkableEntity)  walkable interface eka implemment karapu
	 * 
	 * instead of creating an instance of an class such as human robot i can create a brand new object
	 *  walker(new Walkable(){ - instance of that interface/ derivative(kisiwakin upan) of that interface
	 *  
	 *  })
	 * 
	 */
		
		
		//************************ annonymus class **********************************
	/*
	 * You can't have a particular functionality be segregated(wiyuktha) or pulled away from a class definition.
	 * this is the only way to do it before java 8	(use anonymous class)
	 */
		// Robot shelly = new Robot(); mehema hadanawa wenuwata 
		// new walkable || new Robot yanadi lesata on the fly object eka hadala passa karai
		// on the fly here we are creating this walkable class implementation
		walker(new Walkable(){ // we are not creating Human, Robot kind of specific classes(we don't care what it is we just want walkable 
							   // entity (now this behavior is not tied to any class definition such as a human or robot)
			@Override
			public void walk() {
				System.out.println("Custom object walking....");
				
			}
		
		});
		
		//************************* Use lambda expression **************************
		
		// So what is the lambda expression really - They are block of code used to implement a method defined by a functional interface.
		// (functional interface ekaka define karala tiyena method implement(liyanna) karanna ganna block of codes)
		
		// this syntax is very succinct(luhudu/ sanshikptha) this is shorten version of anonymous class
		walker(()-> System.out.println("Custom object walking..."));  // - this is an anonymous implementation of an abstract method listed in the functional interface
		
		//************ we can write lambda expression like this too ********************
		Walkable blockOfCode = ()->{
			System.out.println("Another object is wolking.....");
			System.out.println("The object tripped..");
		};
		walker(blockOfCode);
		
		/*
		 * IMPORTANT - NOTE
		 * 
		 * functional interface - interface that have only one abstract method
		 * 
		 * lambda expression type should be a functional interface type & we can pass lambda expression in to a function BUT that function should accept functional interface
		 * 
		 * lambda are closely related to interface and the concept of a functional interface
		 * 
		 * when you define a functional interface make sure to use @functionalInterface annotation
		 * (because someone else come and change it that method not a functional interface anymore - because of this annotation eclipse is going to complain)
		 * 
		 */
		
	}
	
	/*
	 * 1st note - 
	 * If we keep like this bellow method can only walk human
	 * 
	 * if we need to walk human any thing through the walker we need to do 2 things
	 * 		1. create a parent class common for both of Human and Robot and pass that parent type in to walker
	 * 			 public static void walker(Parent parent){
	 * 
	 * 		2. create an interface and both Human and Robot implements that interface
	 * 			then we can pass Walkable type into walker method
	 * 			
	 * This is known as polymorphism	
	 */
	
//	public static void walker(Human human) {
//		human.walk();
//	}
	
	// now we can pass tom and shelly to walker method 
	public static void walker(Walkable walkableEntity) {
		walkableEntity.walk();
	}
	

}
