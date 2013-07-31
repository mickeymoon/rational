package expression.token;

/**
 * This class encapsulates a operation token
 * as part of the rational expression.
 * 
 * @author mickey
 *
 */
public class Operator extends Token {
	
	private int priority;
	private int cardinality;
	private Associativity associativity;
	private Class<? extends operation.Operation> operationClass; 
	
	protected static enum Associativity{
		LEFT_TO_RIGHT, RIGHT_TO_LEFT
	}
	
	public int getPriority() {
		return priority;
	}

	public int getCardinality() {
		return cardinality;
	}

	public boolean isLeftToRightAssociative() {
		return associativity == Associativity.LEFT_TO_RIGHT;
	}
	
	public Class<? extends operation.Operation> getOperationClass() {
		return operationClass;
	}

	protected void setOperationClass(
			Class<? extends operation.Operation> operationClass) {
		this.operationClass = operationClass;
	}

	protected void setPriority(int priority) {
		this.priority = priority;
	}

	protected void setCardinality(int cardinality) {
		this.cardinality = cardinality;
	}

	protected void setAssociativity(Associativity associativity) {
		this.associativity = associativity;
	}
}
