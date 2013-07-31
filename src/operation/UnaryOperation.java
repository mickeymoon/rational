package operation;

import arithematic.Rational;


public abstract class UnaryOperation extends Operation {
	
	protected UnaryOperation(Rational r)
	{
		super(1);
		args[0] = r;
	}
}
