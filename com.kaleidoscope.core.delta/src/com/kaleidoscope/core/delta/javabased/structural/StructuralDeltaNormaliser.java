package com.kaleidoscope.core.delta.javabased.structural;

import java.util.Collection;
import java.util.stream.Collectors;

import com.kaleidoscope.core.delta.javabased.operational.AttributeChangeOp;

public class StructuralDeltaNormaliser {

	public static Collection<AttributeChangeOp> normaliseAttributeChanges(Collection<AttributeChangeOp> changedAttributes) {
		Collection<AttributeChangeOp> sorted = changedAttributes.stream()
				.sorted((ac1, ac2) -> {
					if(ac1.getAffectedNode().hashCode() != ac2.getAffectedNode().hashCode())
						return ac1.getAffectedNode().hashCode() >= ac2.getAffectedNode().hashCode() ? 1 : -1;
					else {
						return ac1.getAffectedAttribute().hashCode() >= ac2.getAffectedAttribute().hashCode() ? 1 : -1;
					}
				})
				.collect(Collectors.toList());	
				
		return sorted;
	}

}
