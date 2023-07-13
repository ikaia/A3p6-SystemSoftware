import java.util.Scanner;

	public class A3p6 {

	public static void main(String[] args) {
		
		int m=Integer.parseInt(args[0]);//Command Line for input m
		int n=Integer.parseInt(args[1]);//Command Line for input n
		
		if (m % 12 != 0) { //m is assumed to be a multiple of 12
			System.err.println("Have to be a multiple of 12");  
			System.exit(0);
		}
		if (!(n >= 2 && n <= 4)) {//n is an integer between 2 and 4 inclusive
			System.err.println("n needs be between 2-4");
			System.exit(0);
		}
		int[][] Matrices = new int[5][m];//Create and store 5 by m 2D integer array for matrices 
		
		for (int i = 0; i < Matrices.length; i++){ //Generate a for-loop
		    for (int j = 0; j < Matrices[i].length; j++){

			Matrices[i][j]=(int) (1+(79-1)*Math.random());//Generate 5m random integer between 1 and 79		
		}
	}
		System.out.print("Using "+ n +" threads.\nOriginal array:\n");
		int line=0;
		for(int i = 0; i < Matrices.length; i++){//Print start for-loop
		    for (int j = 0; j < Matrices[i].length; j++){

		System.out.print(Matrices[i][j]);
		line++;
		if(line%m==0) {
			System.out.println();//Last number no comma
		}
		else {
			System.out.print(",");//Add commas 
		}
		}
	}
	
		int divide = m/n; //Divide this update tasks evenly
		int Lowbound = 0; 	
		int Upperbound = divide; 
		method1 at[] = new method1[n];//Create array to hold task objects
		Thread arrayThread[] = new Thread[n];//Create array to hold Thread objects
	
		
		for(int i = 0; i < n; i++) { //Make threads
			at[i]=new method1(Matrices,Lowbound,Upperbound);
			arrayThread[i]=new Thread(at[i]);//Create each individual Thread object
			arrayThread[i].start();//Start the Thread
			Lowbound += divide;	
			Upperbound += divide;
		}	
		  

		for(int i=0 ; i < n; i++) { //Try catch(InterruptedException e)
			try {
				arrayThread[i].join();//Wait for all threads to finish
			}
			catch (InterruptedException e) {
				System.out.println(arrayThread[i].getName() + "failed to join.");
			}
		}
		
		line = 0;
		System.out.print("Updated array:\n");
		for(int i = 0; i < Matrices.length; i++){//Print outcome for updated array
		    for (int j = 0; j < Matrices[i].length; j++){

		System.out.print(Matrices[i][j]); 
		line++;
		if(line%m==0) {
			System.out.println();//Last number no comma
		}
		else {
			System.out.print(",");//Add commas
		}
		}
	}
		
	}

	
	static class method1 implements Runnable{//Initializing method using static
		private int[][] Matrices;
		private int Ubound;
		private int Lbound;
		
		public method1(int[][]a,int b,int c) {//Initializing method1
			Matrices = a;
			Lbound = b;
			Ubound = c;
	}
		@Override
		public void run() { //Need in order to run
		
			for(int i=0;i<Matrices.length;i++) {
				for (int j=Lbound;j<Ubound; j++){
				Matrices[i][j] = Matrices[i][j]%19; //Take the remainder after division by 19
				
			}
		}	
	}
		
		
}
	}

