package operation;

import arithematic.Rational;

public class Negate extends UnaryOperation {

	public Negate(Rational r)
	{
		super(r);
	}
	
	@Override
	public Rational execute() 
	{
		return args[0].negate();
	}

}
