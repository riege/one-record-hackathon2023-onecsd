
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Activity to describe build-up and break-down processes
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_UnitComposition)
public class UnitComposition
    extends LogisticsActivity
    implements Serializable
{

    /**
     * References to all CompositionActions performed for the UnitComposition
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_compositionActions)
    protected Set<Composing> compositionActions;
    /**
     * Short text holding the process number if necessary
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_compositionIdentifier)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String compositionIdentifier;

    public void setCompositionActions(Set<Composing> compositionActions) {
        this.compositionActions = compositionActions;
    }

    public Set<Composing> getCompositionActions() {
        return compositionActions;
    }

    public void setCompositionIdentifier(String compositionIdentifier) {
        this.compositionIdentifier = compositionIdentifier;
    }

    public String getCompositionIdentifier() {
        return compositionIdentifier;
    }

}
