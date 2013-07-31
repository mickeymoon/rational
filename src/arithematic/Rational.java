package arithematic;

import exceptions.NotInvertibleException;
import exceptions.ZeroDenominatorException;

/**
 * This class encapsulates a rational number and provides
 * methods for arithematic over it. This is an immutable class.
 * 
 * @author mickey
 *
 */
public class Rational extends Number
{
	private static final long serialVersionUID = 1L;

	private int numerator;
	
	private int denominator;
	
	public static Rational ZERO;
	
	public static Rational ONE;
	
	public static Rational UNDEFINED;
	
	static
	{
		UNDEFINED = new Rational();
		UNDEFINED.numerator = 0;
		UNDEFINED.denominator = 0;
		
		ZERO = new Rational(0,1);
		ONE = new Rational(1,1);
	}
	
	/** for testing **/
	private Rational()
	{}
	
	public Rational(int numerator, int denominator) throws ZeroDenominatorException
	{
		if(denominator==0)
		{
			throw new ZeroDenominatorException();
		}
		
		if(numerator==0)
		{
			this.numerator = 0;
			this.denominator = 1;
		}
		else
		{
			this.numerator = numerator;
			this.denominator = denominator;
			standardise();
		}
	}
	
	/**
	 * Changes the numerator and denominator to store them 
	 * in standard form - a standard form p/q is where q is 
	 * positive and p and q are coprimes. 
	 */
	private void standardise()
	{
		int sign = (int)(Math.signum(numerator)*Math.signum(denominator));
		int numAbs = Math.abs(numerator);
		int denAbs = Math.abs(denominator);
		int gcd = gcd(numAbs,denAbs);
		this.numerator = sign * (numAbs/gcd);
		this.denominator = denAbs/gcd;
	}
	
	/**
	 * finds GCD using the euclidean algorithm
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	private int gcd(int num1, int num2)
	{
		int rem = num2%num1;
		if( rem == 0 )
		{
			return num1;
		}
		return gcd(rem, num1);
	}
	
	/**
	 * Adds the two rational numbers
	 * 
	 * @param that
	 * @return Rational instance of the sum
	 */
	public Rational add(Rational that)
	{
		int numeratorResult = this.numerator*that.denominator + this.denominator*that.numerator;
		int denominatorResult = this.denominator*that.denominator;
		
		return new Rational(numeratorResult, denominatorResult);
	}
	
	/**
	 * Multiplies the two rational numbers
	 * @param that
	 * @return Rational instance representing product.
	 */
	public Rational multiply(Rational that)
	{
		int numeratorResult = this.numerator*that.numerator;
		int denomResult = this.denominator*that.denominator;
		
		return new Rational(numeratorResult, denomResult);
	}
	
	/**
	 * Returns the multiplicative inverse
	 * 
	 * @return Rational instance representing inverse(q/p)
	 * @throws NotInvertibleException if this instance represents 0
	 */
	public Rational invert() throws NotInvertibleException
	{
		int num = this.denominator;
		int denom = this.numerator;
		
		try
		{
			return new Rational(num,denom);
		}
		catch(ZeroDenominatorException zde)
		{
			throw new NotInvertibleException();
		}
	}
	
	/**
	 * Returns the additive inverse(-p/q)
	 * @return Rational instance of additive inverse
	 */
	public Rational negate()
	{
		return new Rational(0-this.numerator,this.denominator);
	}
	
	/**
	 * Returns the integral power of the number
	 * 
	 * @param exponent
	 * @return Rational instance representing the power
	 */
	public Rational power(int exponent)
	{
		if(this.equals(ZERO))
		{
			if(exponent <= 0)
			{
				return UNDEFINED;
			}
			else
			{
				return ZERO;
			}
		}
		if(exponent==0)
		{
			return ONE;
		}
		
		int num = this.numerator;
		int denom = this.denominator;
		
		if(exponent < 0)
		{
			num = this.denominator;
			denom = this.numerator;
		}
		
		int numResult = 1;
		int denomResult = 1;
		for(int i=1;i<Math.abs(exponent);i++)
		{
			numResult*=num;
			denomResult*=denom;
		}
		
		return new Rational(numResult,denomResult);
	}
	
	/* this one requires some thought 
	 * have in mind an algorithm that can
	 * map bijectively between integers and rationals
	 */
	@Override
	public int hashCode()
	{
		return this.numerator+this.denominator;
	}
	
	@Override
	public boolean equals(Object that)
	{
		return that != null && that instanceof Rational && ((Rational)that).numerator == this.numerator && ((Rational)that).denominator == this.denominator;
	}
	
	@Override
	public String toString()
	{
		if(this.equals(UNDEFINED))
		{
			return "nan";
		}
		else if(this.denominator == 1)
		{
			return this.numerator+"";
		}
		else
		{
			return String.format("(%d/%d)", this.numerator,this.denominator);
		}
	}

	@Override
	public double doubleValue() {
		return (double)this.numerator/(double)this.denominator;
	}

	@Override
	public float floatValue() {
		return (float)this.numerator/(float)this.denominator;
	}

	@Override
	public int intValue() {
		return this.numerator/this.denominator;
	}

	@Override
	public long longValue() {
		return (long)this.numerator/(long)this.denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public static void main(String args[])
	{
		System.out.println(new Rational(13,14).multiply(new Rational(8,3).invert()));
	}

}
