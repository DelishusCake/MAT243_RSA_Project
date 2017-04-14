import java.math.*;

public class RSA
{
	static public final int KEY_LENGTH_BITS = 256;
	static public final int KEY_CERTANTY = 0xDEADBEEF; //TODO: Actually find a good certanty value
	/**
	 * Generate a large random prime number
	 */
	static public BigInteger getRandomPrime()
	{
		//TODO: Seed this for testing so we get consistant values
		Random random = new Random();
		/*
		Use the built in prime generator.
		Not particularly secure, but this is a school project, not the NSA.
		*/
		return new BigInteger(KEY_LENGTH_BITS, KEY_CERTANTY, random);
	};
	static public KeyPair generateKeys(BigInteger p, BigInteger q)
	{
	/*
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
	*/
		//Temp until implementet
		return new KeyPair(getRandomPrime(), getRandomPrime());
	};
	static public String encrypt(String message, BigInteger key)
	{
		return new String("Encrypted message goes here");
	};
	static public String decrypt(String message, BigInteger key)
	{
		return new String("Decrypted message goes here");
	};
}