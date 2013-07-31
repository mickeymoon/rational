package expression.token.ops;

import expression.token.Operator;

public class Exponent extends Operator {

	public Exponent(){
		setAssociativity(Associativity.RIGHT_TO_LEFT);
		setCardinality(2);
		setPriority(1);
		setOperationClass(operation.Power.class);
	}
	
	public String toString(){
		return "^";
	}
}
