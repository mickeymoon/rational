package exceptions;

@SuppressWarnings("serial")
public class ZeroDenominatorException extends RuntimeException {
	
	public String toString()
	{
		return "Denominator to a rational number cannot be zero";
	}

}
