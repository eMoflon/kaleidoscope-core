package com.kaleidoscope.core.delta.javabased.operational;

public abstract class Operation {
	public abstract Delta.Operation toOperationalEMF();
	public abstract void executeOperation();
	public abstract void rollbackOperation();
	
	public Runnable toJavaConsumer() {
		return () -> this.executeOperation();
	}
}
