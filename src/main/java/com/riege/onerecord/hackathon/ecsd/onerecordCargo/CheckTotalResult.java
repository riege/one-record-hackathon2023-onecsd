
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * CheckTotalResult holds the result of a Check and should be provided by the party executing and accounting for the check result
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_CheckTotalResult)
public class CheckTotalResult
    extends LogisticsObject
    implements Serializable
{

    /**
     * Reference to the Actor certifying the result of the Check if required
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_certifiedByActor)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Person certifiedByActor;
    /**
     * Information about a result Value of any kind of the Check
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_resultValue)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value resultValue;
    /**
     * Free text remarks to the check result
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_checkRemark)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String checkRemark;
    /**
     * Boolean indicating whether the Check was passed
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_passed)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean passed;

    public void setCertifiedByActor(Person certifiedByActor) {
        this.certifiedByActor = certifiedByActor;
    }

    public Person getCertifiedByActor() {
        return certifiedByActor;
    }

    public void setResultValue(Value resultValue) {
        this.resultValue = resultValue;
    }

    public Value getResultValue() {
        return resultValue;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    public Boolean getPassed() {
        return passed;
    }

}