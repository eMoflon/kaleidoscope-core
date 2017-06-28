package com.kaleidoscope.extensionpoint;

public interface ArtefactAdapter {

	public <M> M parse();
	public <M> void unparse(M rootElementOfModel);
		
	public <P>void setParseSource(P parseSource);
	public <P>void setUnParseSource(P unparseSource);
	
}
