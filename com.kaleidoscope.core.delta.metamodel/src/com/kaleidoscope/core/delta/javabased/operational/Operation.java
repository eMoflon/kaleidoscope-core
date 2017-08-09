package com.kaleidoscope.core.delta.javabased.operational;

public abstract class Operation {
	public abstract KaleidoscopeDelta.Operation toOperationalEMF();
	public abstract void executeOperation();
	
	public Runnable toJavaConsumer() {
		return () -> this.executeOperation();
	}
}
