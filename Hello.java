package com.v2;

public class Hello {

	//instance  variable  object creation is needed for 
	
	int i =10 ; // instance variabe  // instance  Heap memory   objects
	static int  k =18; //static  //class area  method area   u need no to create any object 
	public static void main(String[] args) {
		Hello hello = new Hello();
   System.out.println(hello.i);
      int j=15; //local variable  //stack
      System.out.println(Hello.k);  // static  String organisation = "wipro"
      
      System.out.println(j);

	}

	

}
