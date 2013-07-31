package expression.token;

public class Paranthesis extends Token {
	
	private ParanthesisType paranType;
	
	public Paranthesis(ParanthesisType type)
	{
		this.paranType = type;
	}
	
	public static enum ParanthesisType{
		OPEN,CLOSED
	}
	
	public boolean isLeft()
	{
		return paranType == ParanthesisType.OPEN;
	}
	
	public String toString(){
		return paranType==ParanthesisType.OPEN?"(":")";
	}
}
