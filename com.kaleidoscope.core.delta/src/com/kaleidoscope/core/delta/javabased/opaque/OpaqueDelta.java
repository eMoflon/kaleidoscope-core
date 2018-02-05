package com.kaleidoscope.core.delta.javabased.opaque;

import com.kaleidoscope.core.delta.javabased.IDelta;

/**
 * An {@link OpaqueDelta} represents an arbitrary transformation that
 * destructively manipulates and changes the given input (and output) model. As
 * it is a functional interface, this transformation can be implemented as
 * arbitrary Java code or using your favorite model transformation language.
 * 
 * @author aanjorin, dgataric
 *
 * @param <Model>
 *            The input and output model type (which is the same as the
 *            transformation is endogenous and in-place).
 */
@FunctionalInterface
public interface OpaqueDelta<Model> extends IDelta {
	/**
	 * Execute the underlying transformation to manipulate and change the given
	 * model.
	 * 
	 * @param model
	 *            The input/output model that will be destructively changed by the
	 *            delta.
	 */
	void execute(Model model);
}
