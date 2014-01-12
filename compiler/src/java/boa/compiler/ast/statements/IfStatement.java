package boa.compiler.ast.statements;

import boa.compiler.ast.expressions.Expression;
import boa.compiler.visitors.AbstractVisitor;
import boa.compiler.visitors.AbstractVisitorNoArg;

/**
 * 
 * @author rdyer
 */
public class IfStatement extends Statement {
	protected Expression condition;
	protected Block body;
	protected Block elseBody;

	public Expression getCondition() {
		return condition;
	}

	public Block getBody() {
		return body;
	}

	public boolean hasElse() {
		return elseBody != null;
	}

	public Block getElse() {
		return elseBody;
	}

	public IfStatement(final Expression condition, final Block body) {
		this(condition, body, null);
	}

	public IfStatement(final Expression condition, final Block body, final Block elseBody) {
		if (condition != null)
			condition.setParent(this);
		if (body != null)
			body.setParent(this);
		if (elseBody != null)
			elseBody.setParent(this);
		this.condition = condition;
		this.body = body;
		this.elseBody = elseBody;
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

	public IfStatement clone() {
		final IfStatement s;
		if (hasElse())
			s = new IfStatement(condition.clone(), body.clone(), elseBody.clone());
		else
			s = new IfStatement(condition.clone(), body.clone());
		copyFieldsTo(s);
		return s;
	}
}
