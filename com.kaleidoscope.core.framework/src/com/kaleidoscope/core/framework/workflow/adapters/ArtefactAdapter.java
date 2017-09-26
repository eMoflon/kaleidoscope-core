package com.kaleidoscope.core.framework.workflow.adapters;

import java.util.Optional;

/**
 * Kaleidoscope makes a clear distinction between an "artefact layer" a "model
 * layer". The primary motiviation for this is to support reuse of components
 * that can operate on models and be used for various artefact types. To convert
 * artefacts to models, however, some form of adaptation is required.
 * 
 * <br/>
 * <br/>
 * 
 * {@link ArtefactAdapter}s provide a bidirectional and bijective transformation
 * between model and artefacts via their parse and unparse methods. Artefact
 * adapters can restructure, simplify, and abstract from details in artefacts,
 * but should in general be able to reproduce the same or at least an isomorphic
 * artefact from the model. Isomorphic here means that you can ignore things you
 * don't care about such as comments or layouts, but should be aware of the fact
 * that you can only then generate artefacts with default fixed versions of
 * these ignored details.
 * 
 * <br/>
 * <br/>
 * 
 * To support cases where the adapter has some internal state, e.g., loads a
 * model from a location fixed by convention, the actual artefact<=>model
 * transformation is separated from state manipulation methods (setters and
 * getters). So implementations must check the respective preconditions for
 * (un)parsing, which might be very application specific.
 * 
 * @author aanjorin, dgataric
 *
 * @param <Model>
 *            The model type produced by the adapter.
 * @param <Artefact>
 *            The artefact type produced by the adapter.
 */
public interface ArtefactAdapter<Model, Artefact> {
	
	/* Model-to-Artefact Transformation */
	
	/**
	 * Transform internally stored artefact to a respective model. 
	 * Remember to check that the model can be accessed or retrieved.
	 */
	public void parse();
	
	/**
	 * Transform internally stored model to a respective artefact. 
	 * Remember to check that the model can be accessed or retrieved.
	 */
	public void unparse();

	
	/* Setters */
	
	/**
	 * Use for the simple case of setting the model to be transformed to an artefact.
	 */
	public void setModel(Model m);
	
	/**
	 * Use for the simple case of setting the artefact to be transformed to a model.
	 */
	public void setArtefact(Artefact a);
	
	
	/* Getters */
	
	/**
	 * @return Current internally stored model. Can be empty as transformation might
	 *         have failed or might not have been executed.
	 */
	public Optional<Model> getModel();

	/**
	 * @return Current internally stored model. Can be empty as transformation might
	 *         have failed or might not have been executed.
	 */
	public Optional<Artefact> getArtefact();	
}
