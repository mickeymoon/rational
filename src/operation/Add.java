package operation;

import arithematic.Rational;

public class Add extends BinaryOperation {

	public Add(Rational r1, Rational r2)
	{
		super(r1, r2);
	}
	
	@Override
	public Rational execute() 
	{
		return args[0].add(args[1]);
	}

}
