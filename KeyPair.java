import java.math.*;

/**
 * Immutable data structure for holding a public/private key pair.
 * Should probably be a KeyTouple but its too late for that now.
 */
class KeyPair
{
	/**
	 * Create a new immutable KeyPair
	 * @param	n 	The Public modulus
	 * @param 	e 	The Public exponent
	 * @param 	d 	The Private exponent
	 */
	public KeyPair(BigInteger n, BigInteger e, BigInteger d)
	{
		this.modKey = n;
		this.publicKey = e;
		this.privateKey = d;
	}
	/**
	 * Get the Modulus portion of the public key
	 */
	public BigInteger getMod()     { return modKey; }
	/**
	 * Get the exponent portion of the public key
	 */
	public BigInteger getPublic()  { return publicKey; }
	/**
	 * Get the exponent portion of the private key
	 */
	public BigInteger getPrivate() { return privateKey; }

	/**
	 * Create a copy of the immutable keypair
	 */
	public KeyPair copy() { return new KeyPair(modKey, publicKey, privateKey); }

	private BigInteger modKey;
	private BigInteger publicKey;
	private BigInteger privateKey;
}