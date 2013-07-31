package expression.analyser;

import expression.token.Token;

/**
 * Implementations of this interface are supposed to provide
 * the syntax for parsing the rational expression elements viz
 * operands, operators, parenthesis and the grammar for 
 * producing a token stream, a list of tokens in more concrete
 * object representations instead of their string equivalent
 * tokens in the string expression.
 *  
 * @author mickey
 *
 */
public interface Analyser {

	/**
	 * Returns an array of tokens by analysing the
	 * expression. The rules or grammar for analysis
	 * may change in different analyser implementations
	 * 
	 * @param expression
	 * @return
	 */
	Token[] getTokens(String expression);
}
