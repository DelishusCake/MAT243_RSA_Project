import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;

public class RsaED
{
	public static void main(String[] args)
	{
		try
		{
			char choice;

			printMenu(); //Display main menu
			InputStreamReader isr = new InputStreamReader (System.in);
			BufferedReader stdin = new BufferedReader (isr);
			Scanner in = new Scanner(System.in);
			do
			{
				String line = stdin.readLine().trim();
				choice = line.charAt(0);
				choice = Character.toUpperCase(choice);
				
				if(line.length() == 1)
				{
					switch(choice)
					{			
						case 'A': 
							KeyPair key = RSA.generateKeys();
							System.out.println("The generated public key is: " + key.getPublic());
							System.out.println("The generated modulus is: " + key.getMod());
							System.out.println("The generated private key is: " + key.getPrivate());
                                                        System.out.println("Enter your message: ");
							String message = stdin.readLine().trim();	//Get message from user
							String finals = RSA.encrypt(message, key.getPublic(), key.getMod());
							System.out.println("your encrypted message is " + finals); //display encrypted message
							//Generate primes and encrypt a message
                                                        printMenu();
						break;
						case 'B':		
							System.out.println("Enter your public Key:");
							BigInteger publicKey = in.nextBigInteger();
							System.out.println("Enter your private Key:");
							BigInteger privateKey = in.nextBigInteger();
							System.out.println("Enter the modulus:");
							BigInteger modulus = in.nextBigInteger();
							System.out.println("Enter your message: ");
                                                        String message2 = stdin.readLine().trim();
							KeyPair mKey = new KeyPair(publicKey, privateKey, modulus);
							String finals2 = RSA.encrypt(message2, mKey.getPrivate(), mKey.getPublic());
                                                        System.out.println("your encrypted message is " + finals2);
                                                        printMenu();
							//Manually enter primes and encrypt a message
							//encryption functionality 
							break;
						case 'C': 
							System.out.println("Please enter your private key: ");
							BigInteger priv = in.nextBigInteger();
							System.out.println("Please enter your modulus: ");
							BigInteger mod = in.nextBigInteger();
							System.out.println("Please enter the message you wish to decrypt: ");
							message = stdin.readLine().trim(); //message input from user
                                                        System.out.println("Decrypted Message: ");
							System.out.println(RSA.decrypt(message, priv, mod));//Decrypt a message
							//System.out.println(RSA.decrypt(message,priv,mod);//decrypt the users message
                                                        printMenu();
							break;
						case 'Q': //Stop the loop and quit
							break;	
					}
				}
			} while(choice != 'Q');
		}//end of try
		catch(Exception e)
		{
			System.out.println("IO Exception");
		}
	}
	public static void printMenu()
	{
		          System.out.println("\n");
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