import java.math.*;
import java.util.*;

public class RSA
{
	static public final int KEY_LENGTH_BITS = 256;
	static public final int KEY_CERTANTY = 0x64; //TODO: Actually find a good certanty value
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
		//All primes are coprime to each other, so just get a prime thats less than phi
		do
		{
			e = new BigInteger(phi.bitLength(), random);
		} while(e.compareTo(BigInteger.ONE) <= 0 || e.compareTo(phi) >= 0 || !e.gcd(phi).equals(BigInteger.ONE));
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
		BigInteger p = new BigInteger(KEY_LENGTH_BITS / 2, KEY_CERTANTY, random);
		BigInteger q = new BigInteger(KEY_LENGTH_BITS / 2, KEY_CERTANTY, random);
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
	};
	/**
	 * Decrypt a message using a private key and a modulus
	 * @param 	d		The private key exponent
	 * @param 	n 		The public key modulus
	 */
	static public String decrypt(String message, BigInteger d, BigInteger n)
	{
		BigInteger m = new BigInteger(message);
		return new String(m.modPow(d, n).toByteArray());
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