import java.math.*;
import java.util.*;
import java.security.*;

public class RSA
{
	//The size of the keys in bits
	static public final int KEY_LENGTH_BITS = 256;
	//The certainty of generating a prime (0x0 - 0xFFFFFFFF)
	static public final int KEY_CERTAINTY = 0x64;
	/**
	 * Creates a public/private key pair from two prime numbers
	 */
	static public KeyPair generateKeys(BigInteger p, BigInteger q)
	{
		//NOTE: Big integer math is ugly, but it's needed for large keys
		//Mod value (n=p*q)
		BigInteger n = p.multiply(q);
		//Totient value (phi=(p-1)(q-1))
		BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		//Public key exponent (1 < e < phi)
		BigInteger e;
		//Create a public key exponent (1 < e < phi, e is coprime with phi)
		do
		{
			e = new BigInteger(phi.bitLength(), random);
		} while(e.compareTo(BigInteger.ONE) <= 0 || e.compareTo(phi) >= 0 || !e.gcd(phi).equals(BigInteger.ONE));
		// d * e mod phi = 1
		// d = 1 * e^-1 mod phi
		BigInteger d = e.modInverse(phi);
		return new KeyPair(n, e, d);
	};
	/**
	 * Creates a public/private key pair from two random prime numbers.
	 * Helper method.
	 */
	static public KeyPair generateKeys()
	{
		//Generate two primes of half the key length
		BigInteger p = new BigInteger(KEY_LENGTH_BITS / 2, KEY_CERTAINTY, random);
		BigInteger q = new BigInteger(KEY_LENGTH_BITS / 2, KEY_CERTAINTY, random);
		//Generate an immutable key pair from the primes
		return generateKeys(p, q);
	};
	/**
	 * Encrypt a message using a public key and a modulus
	 * @param	e 		The public key exponent
	 * @param 	n		The public key modulus
	 */
	static public String encrypt(String message, BigInteger e, BigInteger n) 
	{
		//Transform the message to a BigInteger
		BigInteger m = new BigInteger(message.getBytes());
		// encrypted_message = m^e mod n
		return m.modPow(e, n).toString();
	};
	/**
	 * Decrypt a message using a private key and a modulus
	 * @param 	d		The private key exponent
	 * @param 	n 		The public key modulus
	 */
	static public String decrypt(String message, BigInteger d, BigInteger n)
	{
		//Transform the encrypted message into a big integer
		BigInteger m = new BigInteger(message);
		// message = encrypted_message^d mod n
		return new String(m.modPow(d, n).toByteArray());
	};
	/**
	 * Random Number Generator used for prime generation
	 */
	static private Random random;
	static
	{
		random = new SecureRandom();
	}
}