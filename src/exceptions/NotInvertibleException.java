package exceptions;

@SuppressWarnings("serial")
public class NotInvertibleException extends RuntimeException {
	
	public String toString()
	{
		return "ZERO number cannot be inverted";
	}

}
