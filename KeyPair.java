import java.math.*;

/**
 * Immutible data structure for holding a public/private key pair
 */
class KeyPair
{
	public KeyPair(BigInteger publicKey, BigInteger privateKey)
	{
		this.publicKey = publicKey;
		this.privateKey = privateKey;
	}
	public BigInteger getPublic()  { return publicKey; }
	public BigInteger getPrivate() { return privateKey; }

	private BigInteger publicKey;
	private BigInteger privateKey;
}