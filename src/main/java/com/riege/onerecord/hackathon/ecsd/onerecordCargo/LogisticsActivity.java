
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Superclass: LogisticsActivity is a scheduled set of tasks that is executed as part of one or more Services
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_LogisticsActivity)
public class LogisticsActivity
    extends LogisticsObject
    implements Serializable
{

    /**
     * References to CheckActions performed for the Activity
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_checkActions)
    protected Set<Check> checkActions;
    /**
     * Information about contactDetails
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_contactDetails)
    protected Set<ContactDetail> contactDetails;
    /**
     * References to Actors (Person, NonHumanActor) acting as contacts
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_contactPersons)
    protected Set<Person> contactPersons;
    /**
     * Reference to Services this Activity is executed for
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_servedServices)
    protected Set<LogisticsService> servedServices;
    /**
     * Enum stating the status of the Activity
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_executionStatus)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String executionStatus;

    public void setCheckActions(Set<Check> checkActions) {
        this.checkActions = checkActions;
    }

    public Set<Check> getCheckActions() {
        return checkActions;
    }

    public void setContactDetails(Set<ContactDetail> contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Set<ContactDetail> getContactDetails() {
        return contactDetails;
    }

    public void setContactPersons(Set<Person> contactPersons) {
        this.contactPersons = contactPersons;
    }

    public Set<Person> getContactPersons() {
        return contactPersons;
    }

    public void setServedServices(Set<LogisticsService> servedServices) {
        this.servedServices = servedServices;
    }

    public Set<LogisticsService> getServedServices() {
        return servedServices;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

}
