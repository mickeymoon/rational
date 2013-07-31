package operation;

import arithematic.Rational;


public abstract class BinaryOperation extends Operation
{
	protected BinaryOperation(Rational r1, Rational r2)
	{
		super(2);
		args[0] = r1;
		args[1] = r2;
	}

}
