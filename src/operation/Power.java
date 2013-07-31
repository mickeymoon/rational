package operation;

import arithematic.Rational;

public class Power extends UnaryOperation {

	private Integer exponent;

	public Power(Rational r, Integer exp)
	{
		super(r);
		this.exponent = exp;
	}
	
	@Override
	public Rational execute() 
	{
		return args[0].power(exponent);
	}

}
