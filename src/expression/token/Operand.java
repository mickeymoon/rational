package expression.token;

import arithematic.Rational;

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
