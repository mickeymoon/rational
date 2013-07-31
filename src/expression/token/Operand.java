package expression.token;

import arithematic.Rational;

/**
 * This class encapsulates a token with a wrapped rational
 * number as an operand in the expression.
 * 
 * @author mickey
 *
 */
public class Operand extends Token{
	
	private Rational value;
	
	public Rational getValue() {
		return value;
	}
	public void setValue(Rational value) {
		this.value = value;
	}
	
	public String toString(){
		return value.toString();
	}
	
}
