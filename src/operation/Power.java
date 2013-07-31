package operation;

import arithematic.Rational;

public class Power extends BinaryOperation {
	
	public Power(Rational r1, Rational r2)
	{
		super(r1,r2);
	}
	
	@Override
	public Rational execute() 
	{
		return args[0].power(args[1].intValue());
	}

}
