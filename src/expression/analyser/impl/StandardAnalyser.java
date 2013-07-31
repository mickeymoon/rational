package expression.analyser.impl;

import expression.analyser.Analyser;
import expression.token.Token;
/**
 * This is a default implementation for the analyser.
 * This analyser treats all operations to be binary
 * operations. All unary operations are parsed to operands.
 * 
 * @author mickey
 *
 */
public class StandardAnalyser implements Analyser {

	@Override
	public Token[] getTokens(String expression) {
		return null;
	}

}
