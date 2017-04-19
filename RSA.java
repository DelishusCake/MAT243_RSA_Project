import java.math.*;
import java.util.*;

public class RSA
{
	static public final int KEY_LENGTH_BITS = 64;
	static public final int KEY_CERTANTY = 0xDEADBEEF; //TODO: Actually find a good certanty value
	/**
	 * Generate a large random prime number
	 */
	static public BigInteger getRandomPrime()
	{		
		/*
		Use the built in prime generator.
		Not particularly secure, but this is a school project, not the NSA.
		*/
		return new BigInteger(KEY_LENGTH_BITS, KEY_CERTANTY, random);
	};
	/**
	 * Creates a public/private key pair from two prime numbers
	 */
	static public KeyPair generateKeys(BigInteger p, BigInteger q)
	{
		//NOTE: Big integer math is ugly, but it's needed for large keys
		//Mod value (n=p*q)
		BigInteger n = p.multiply(q);
		//Totient value (phi=(p-1)(q-1))
		BigInteger phi = p.subtract(BigInteger.ONE).multiply(p.subtract(BigInteger.ONE));
		//Public key exponent (1 < e < phi)
		BigInteger e = getRandomPrime();
		//All primes are coprime to each other, so just get a prime thats less than phi
		while(e.compareTo(phi) >= 0)
		{
			e = getRandomPrime();
		}
		// d * e mod phi = 1
		// d = 1 * e^-1 mod phi
		BigInteger d = e.modInverse(phi);
		//TODO: assert(d * e mod phi == 1);

		return new KeyPair(n, e, d);
	};
	/**
	 * Creates a public/private key pair from two random prime numbers.
	 * Helper method.
	 */
	static public KeyPair generateKeys()
	{
		BigInteger p = getRandomPrime();
		BigInteger q = getRandomPrime();
		return generateKeys(p, q);
	};
	/**
	 * Encrypt a message using a public key and a modulus
	 * @param	e 		The public key exponent
	 * @param 	n		The public key modulus
	 */
	static public String encrypt(String message, BigInteger e, BigInteger n)
	{
		BigInteger m = new BigInteger(message.getBytes());
		return m.modPow(e, n).toString();
		//return new String("Encrypted message goes here");
	};
	/**
	 * Decrypt a message using a private key and a modulus
	 * @param 	d		The private key exponent
	 * @param 	n 		The public key modulus
	 */
	static public String decrypt(String message, BigInteger d, BigInteger n)
	{
		BigInteger m = new BigInteger(message.getBytes());
		return m.modPow(d, n).toString();
		//return new String("Decrypted message goes here");
	};
	/**
	 * Random Number Generator used for prime generation
	 */
	static private Random random;
	static
	{
		//TODO: Seed this for testing so we get consistant values
		random = new Random();
	}
}