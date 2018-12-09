package com.dpk.inheritance;

class Sample {
	void send() {
		System.out.println("Sample send");
	}
}

class GrandParent {
	void send() {
		System.out.println("Sample send");
	}
}

class Parent extends GrandParent{
	
	void compose() {
		System.out.println("Parent compose");
		this.send();
	}
	
	void send() {
		System.out.println("Parent send");
	}
	
}


public class Child extends Parent{

	void send() {
		System.out.println("Child send");
	}
	
	void chat() {
		System.out.println("Child Chat");
	}
	
	public static void main(String[] args) {

		/******** Trick-1 ********/
		/* You can not cast an object to another object which is incompatible i.e. which is not in the inheritance chain. 
		  Below code resuults in compile time error. */
		//Sample child = (Sample) new Child();
		
		/******** Trick-2 ********/
		/* You can try to cast parent class object to Child class but at runtime it will throw ClassCastException */
		//Child child = (Child) new Parent();
		
		/******** Trick-3 ********/
		/* Execution depends on type of object hence below code will print 
		    Parent compose
			Child send 
		*/
		Child child = new Child();
		child.compose();
		
		/* As Execution depends on type of object hence below code will print 
	    	Parent compose
			Parent send 
		*/
		Parent parent = new Parent();
		parent.compose();

		/******** Trick-4 ********/
		/* Parent class object will not be able to call child class method */
		Parent parent1 = new Parent();
		//parent1.chat(); // This will not work 
		
		/******** Trick-5 ********/
		/* If the type is Parent class but object is child class then it will be able to call only parent class methods
		 * To allow this to call child class method downcasting is required */
		Parent parent2 = new Child();
		// parent2.chat();  // Even this will not work
		((Child) parent2).chat(); // This will work
		
		/******** Trick-6 ********/
		/* Irrespective of the type of object in case of non static method, The method selection is always from the class of the object */
		/* Both the code below print Child Send */
		Parent child1 = new Child();
		Parent child2 = (Parent)new Child();
		child1.send();
		child2.send();
		
	}

}
