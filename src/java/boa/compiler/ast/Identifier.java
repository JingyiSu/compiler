package boa.compiler.ast;

import boa.compiler.ast.types.AbstractType;
import boa.compiler.visitors.AbstractVisitor;
import boa.compiler.visitors.AbstractVisitorNoArg;
import boa.parser.Token;

/**
 * 
 * @author rdyer
 */
public class Identifier extends AbstractType {
	protected String token;

	public String getToken() {
		return token;
	}

	public void setToken(final String token) {
		this.token = token;
	}

	public Identifier (final String token) {
		this.token = token;
	}

	/** {@inheritDoc} */
	@Override
	public <A> void accept(final AbstractVisitor<A> v, A arg) {
		v.visit(this, arg);
	}

	/** {@inheritDoc} */
	@Override
	public void accept(final AbstractVisitorNoArg v) {
		v.visit(this);
	}

	public Identifier clone() {
		final Identifier id = new Identifier(token);
		copyFieldsTo(id);
		return id;
	}

	public Identifier setPositions(final Token first) {
		return (Identifier)setPositions(first.beginLine, first.beginColumn, first.endLine, first.endColumn);
	}
}