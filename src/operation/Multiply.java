package operation;

import arithematic.Rational;

public class Multiply extends BinaryOperation {

	public Multiply(Rational r1, Rational r2)
	{
		super(r1, r2);
	}
	
	@Override
	public Rational execute() 
	{
		return args[0].multiply(args[1]);
	}

}
