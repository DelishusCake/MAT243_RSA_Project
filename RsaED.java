import java.io.*;
import java.math.BigInteger;


public class RsaED {

		public static void main(String[] args)
		{
			
			char choice;
			String line = new String();
                        KeyPair keys = new KeyPair();
                        String finals = new String();
			
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
                                            
		        			case 'A': 
		        					RSA encrypt = new RSA();	
                                                                KeyPair key = encrypt.generateKeys();
                                                                finals = RSA.encrypt("hello world", key.getPrivate(), key.getPublic());
                                                                System.out.println(finals);
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
                                                                System.out.println(RSA.decrypt(finals, keys.getPrivate(), keys.getMod()));//Decrypt a message
		        			
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
