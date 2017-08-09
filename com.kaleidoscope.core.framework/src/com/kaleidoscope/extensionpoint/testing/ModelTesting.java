package com.kaleidoscope.extensionpoint.testing;

public class ModelTesting<S, T> {
	
	private Comparator<S>src;
	private Comparator<T>trg;
	
	public ModelTesting(){
		
	}
	public ModelTesting(Comparator<S>srcComparator, Comparator<T>trgComparator){
		this.src= srcComparator;
		this.trg = trgComparator;
	}
	
	public void setSrcComparator(Comparator<S>srcComparator){
		this.src = srcComparator;
	}
	
	public void setTrgComparator(Comparator<T>trgComparator){
		this.trg  = trgComparator;
	}

	public void assertSourceModel(S expectedSourceModel, S actualSourceModel){
		src.assertEquals(expectedSourceModel, actualSourceModel);
	}
	
	public void assertTargetModel(T expectedTargetModel, T actualTargetModel){
		trg.assertEquals(expectedTargetModel, actualTargetModel);
	}
}
