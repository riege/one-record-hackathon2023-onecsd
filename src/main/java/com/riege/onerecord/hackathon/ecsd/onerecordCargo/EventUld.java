
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Subtype of Event
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_EventUld)
public class EventUld
    extends LogisticsEvent
    implements Serializable
{

    /**
     * Position of the shipment in the aircraft - e.g. lower or main deck
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_loadingPosition)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String loadingPosition;

    public void setLoadingPosition(String loadingPosition) {
        this.loadingPosition = loadingPosition;
    }

    public String getLoadingPosition() {
        return loadingPosition;
    }

}
