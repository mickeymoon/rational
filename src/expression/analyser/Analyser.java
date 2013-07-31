package expression.analyser;

import expression.token.Token;

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
