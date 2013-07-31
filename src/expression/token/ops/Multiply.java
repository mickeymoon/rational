package expression.token.ops;

import expression.token.Operator;

public class Multiply extends Operator {
	
	public Multiply(){
		setAssociativity(Associativity.LEFT_TO_RIGHT);
		setPriority(2);
		setCardinality(2);
		setOperationClass(operation.Multiply.class);
	}
	
	public String toString(){
		return "*";
	}

}
