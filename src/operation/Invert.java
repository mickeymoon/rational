package operation;

import arithematic.Rational;

public class Invert extends UnaryOperation {
	
	public Invert(Rational r)
	{
		super(r);
	}

	@Override
	public Rational execute() 
	{
		return args[0].invert();
	}

}
