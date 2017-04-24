import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;


public class RsaED {

		public static void main(String[] args)
		{
			
			char choice;
			String line = new String();
			String message = new String();
            KeyPair keys = new KeyPair();
            String finals = new String();
			
			try
			{
				
				printMenu(); //Display main menu
		    	InputStreamReader isr = new InputStreamReader (System.in);
		    	BufferedReader stdin = new BufferedReader (isr);
				Scanner in = new Scanner(System.in);
				do
				{
					line = stdin.readLine().trim();
		        	choice = line.charAt(0);
		        	choice = Character.toUpperCase(choice);
		        	
		        	if(line.length() == 1)
		        	{
		        		switch(choice)
		        		{
                                            
		        			case 'A': 
		        					RSA encrypt = new RSA();	
                                                                KeyPair key = encrypt.generateKeys();
																System.out.println("The generated public key is: " + key.getPublic());
																System.out.println("The generated modulus is: " + key.getMod());
																System.out.println("The generated private key is: " + key.getPrivate());
																message = stdin.readLine();	//Get message from user
                                                                finals = RSA.encrypt("hello world", key.getPublic(), key.getMod());
                                                                System.out.println("your encrypted message is " + finals); //display encrypted message
                                                                keys.setMod(key.getMod());
                                                                keys.setPrivate(key.getPrivate());
                                                                keys.setPublic(key.getPrivate());
                                                                //Generate primes and encrypt a message
																//Prime generation and encryption functionality to be added
		        				
		        				break;
		        		
		        		
		        		
		        			case 'B':
                                                    
                                                    System.out.println("Enter your public Key:");
                                                    line = stdin.readLine();
                                                    BigInteger publicKey = new BigInteger(line);
                                                    System.out.println("Enter your private Key:");
                                                    line = stdin.readLine();
                                                    BigInteger privateKey = new BigInteger(line);
                                                    
                                                                RSA mEncrypt = new RSA();	
                                                                KeyPair mKey = mEncrypt.generateKeys(publicKey,privateKey);
                                                                System.out.println(mEncrypt.encrypt("hello world", mKey.getPrivate(), mKey.getPublic()));
                                                               
                                                                //Manually enter primes and encrypt a message
		        					
		        					//encryption functionality 
		        				
		        				break;
		        		
		        			
		        			case 'C': 
                                                               	
                                                    
                                                    //KeyPair s = RSA.generateKeys();
													System.out.println("Please enter your private key: ");
													BigInteger priv = in.nextBigInteger();
													System.out.println("Please enter your modulus: ");
													BigInteger mod = in.nextBigInteger();
													System.out.println("Please enter the message you wish to decrypt: ");
													message = stdin.readLine(); //message input from user
                                                    System.out.println(RSA.decrypt(finals, keys.getPrivate(), keys.getMod()));//Decrypt a message
													//System.out.println(RSA.decrypt(message,priv,mod);//decrypt the users message
		        			
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
