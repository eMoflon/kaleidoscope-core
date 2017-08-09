package com.kaleidoscope.extensionpoint.bxtool;

import java.util.ArrayList;
import java.util.List;

import com.kaleidoscope.core.delta.javabased.operational.Operation;

public class SynchronizationReport{
	
    List<Operation>successfulOperations = new ArrayList<Operation>();
    List<Operation>failedlOperations = new ArrayList<Operation>();
    
    public SynchronizationReport(){
    	
    }
    public void addSuccessfulOperation(Operation delta){
    	successfulOperations.add(delta);
    }
    public void removeSuccessfulOperation(Operation delta){
    	successfulOperations.remove(delta);
    }
    
    public void addFailedOperation(Operation delta){
    	failedlOperations.add(delta);
    }
    public void removeFailedOperation(Operation delta){
    	failedlOperations.remove(delta);
    }
    
	public List<Operation> getSuccessfulOperations() {
		return successfulOperations;
	}
	public void setSuccessfulOperations(List<Operation> successfulOperations) {
		this.successfulOperations = successfulOperations;
	}
	public List<Operation> getFailedlOperations() {
		return failedlOperations;
	}
	public void setFailedlOperations(List<Operation> failedlOperations) {
		this.failedlOperations = failedlOperations;
	}
    
    
}
