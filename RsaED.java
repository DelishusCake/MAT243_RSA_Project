import java.io.*;


public class RsaED {

		public static void main(String[] args)
		{
			
			char choice;
			String line = new String();
			
			try
			{
				
				printMenu(); //Display main menu
		    	InputStreamReader isr = new InputStreamReader (System.in);
		    	BufferedReader stdin = new BufferedReader (isr);
				do
				{
					line = stdin.readLine().trim();
		        	choice = line.charAt(0);
		        	choice = Character.toUpperCase(choice);
		        	
		        	if(line.length() == 1)
		        	{
		        		switch(choice)
		        		{
		        			case 'A': //Generate primes and encrypt a message
		        						
		        					//Prime generation and encryption functionality to be added
		        				
		        				break;
		        		
		        		
		        		
		        			case 'B': //Manually enter primes and encrypt a message
		        					
		        					//encryption functionality 
		        				
		        				break;
		        		
		        			
		        			case 'C': //Decrypt a message
		        			
		        					//Decryption functionality be added
		        				
		        				break;
		        				
		        			case 'Q': //Stop the loop and quit
		        			
		        				break;
		        			
		        		}
		        	}
			    
				}
				while(choice != 'Q');
			}//end of try
			
			catch(Exception e)
			{
				System.out.println("IO Exception");
			}
		  }
		
		public static void printMenu()
		{
			System.out.println("\n\n\n");
			System.out.print("RSA Encrypt Decrypt\n"+
							 "-----------------------\n"+
							 "Please choose an option\n"+
							 "-----------------------\n" +
							 "A. Generate primes and create encrypt a message\n"+
							 "B. Enter Primes manually and encrypt a message\n"+
							 "C. Decrypt a message\n" +
							 "Q. Quit\n\n");
		}
}
