package expression.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import expression.RationalExpression;
import expression.analyser.Analyser;
import expression.analyser.impl.StandardAnalyser;
import expression.parse.exception.ParseException;
import expression.token.Operand;
import expression.token.Operator;
import expression.token.Paranthesis;
import expression.token.Paranthesis.ParanthesisType;
import expression.token.Token;

public class RationalExpressionParser 
{
	private String expression;
	
	private Analyser analyser;
	
	public RationalExpressionParser(String expression)
	{
		this(expression, new StandardAnalyser());
	}
	
	public RationalExpressionParser(String expression, Analyser analyser)
	{
		this.expression = expression;
		this.analyser = analyser;
	}
	
	public RationalExpression parse() throws ParseException
	{
		Token[] infix = analyser.getTokens(expression);
		Stack<Token> stack = new Stack<Token>();
		stack.push(new Paranthesis(ParanthesisType.OPEN));
		List<Token> postFix = new ArrayList<Token>(infix.length);
		
		for(Token token:infix)
		{
			if(token instanceof Operand)
			{
				postFix.add(token);
			}
			else if(token instanceof Paranthesis)
			{
				Paranthesis paranToken = (Paranthesis)token;
				if(paranToken.isLeft())
				{
					stack.push(token);
				}
				else
				{
					Token lastToken = stack.pop();
					while( !(lastToken instanceof Paranthesis) )
					{
						postFix.add(lastToken);
						lastToken = stack.pop();
					}
				}
			}
			else if(token instanceof Operator)
			{
				Operator thisOp = (Operator)token;
				
				Token lastToken = stack.peek();
				while(  !(lastToken instanceof Paranthesis) 
						&& ( 
								((Operator)lastToken).getPriority() < thisOp.getPriority() || 
								( ((Operator)lastToken).getPriority() == thisOp.getPriority() && ((Operator)lastToken).isLeftToRightAssociative() )
								)
						)
				{
					postFix.add(stack.pop());
					lastToken = stack.peek();
				}
				stack.push(thisOp);
			}
		}
		if(stack.isEmpty())
		{
			return new RationalExpression(postFix);
		}
		else
		{
			throw new ParseException();
		}
	}
	
	public Analyser getAnalyser(){
		return analyser;
	}
	
	public String getExpression(){
		return expression;
	}

}
