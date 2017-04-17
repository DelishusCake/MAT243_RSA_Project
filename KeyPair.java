import java.math.*;

/**
 * Immutible data structure for holding a public/private key pair
 */
class KeyPair
{
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

	private BigInteger modKey;
	private BigInteger publicKey;
	private BigInteger privateKey;
}