package expression;

import java.util.List;
import java.util.Stack;

import operation.Operation;
import arithematic.Rational;
import expression.token.Operand;
import expression.token.Operator;
import expression.token.Token;

public class RationalExpression 
{
	private List<Token> postFix;
	
	public RationalExpression(List<Token> postFix)
	{
		this.postFix = postFix;
	}
	
	public Rational solve()
	{
		Stack<Operand> stack = new Stack<Operand>();
		for(Token token:postFix)
		{
			if(token instanceof Operand)
			{
				stack.push((Operand)token);
			}
			else
			{
				Operator op = (Operator)token;
				Rational rightOp = stack.pop().getValue();
				Rational leftOp = stack.pop().getValue();
				
				Rational args[] = new Rational[2];
				args[0] = leftOp;
				args[1] = rightOp;
				Operation opn = null;
				try {
					opn = op.getOperationClass().getConstructor(Rational.class, Rational.class).newInstance((Object[])args);
				} catch (Exception e) {
					//nothing to do here
					e.printStackTrace();
				}
				
				Rational result = opn.execute();
				Operand resltOp = new Operand();
				resltOp.setValue(result);
				stack.push(resltOp);
				
			}
		}
		return stack.pop().getValue();
	}
}
