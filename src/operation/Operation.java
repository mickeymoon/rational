package operation;

import operation.exception.OperationIllegalArgumentCardinalityException;
import arithematic.Rational;

public abstract class Operation 
{
	protected Rational[] args;
	
	private int cardinality;
	
	protected Operation(int cardinality)
	{
		this.cardinality = cardinality;
		args = new Rational[cardinality];
	}
	
	public Rational operate()
	{
		if(args.length >= cardinality)
		{
			return execute();
		}
		else
		{
			throw new OperationIllegalArgumentCardinalityException();
		}
	}
	
	public abstract Rational execute();
	
}
