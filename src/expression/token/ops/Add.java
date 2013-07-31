package expression.token.ops;

import expression.token.Operator;

public class Add extends Operator 
{
	public Add()
	{
		setAssociativity(Associativity.LEFT_TO_RIGHT);
		setCardinality(2);
		setPriority(3);
		setOperationClass(operation.Add.class);
	}
	
	public String toString(){
		return "+";
	}

}
