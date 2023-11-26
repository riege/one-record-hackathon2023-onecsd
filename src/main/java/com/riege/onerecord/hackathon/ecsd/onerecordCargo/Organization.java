
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Superclass: Organizations represent a kind of Agent corresponding to social instititutions such as companies, societies, etc
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Organization)
public class Organization
    extends LogisticsAgent
    implements Serializable
{

    /**
     * Reference to the Location where the Organization is based at or headquartered
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_basedAtLocation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Location basedAtLocation;
    /**
     * References to Actors (Person, NonHumanActor) acting as contacts
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_contactPersons)
    protected Set<Actor> contactPersons;
    /**
     * Details about any other identifier, depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_otherIdentifiers)
    protected Set<OtherIdentifier> otherIdentifiers;
    /**
     * Reference to the parent Organization
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_parentOrganization)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Organization parentOrganization;
    /**
     * References to all sub-Organizations
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_subOrganization)
    protected Set<Organization> subOrganization;
    /**
     * Human-understandable name of object depending on the context
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_name)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String name;
    /**
     * Short name of the Organization if any
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_shortName)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String shortName;

    public void setBasedAtLocation(Location basedAtLocation) {
        this.basedAtLocation = basedAtLocation;
    }

    public Location getBasedAtLocation() {
        return basedAtLocation;
    }

    public void setContactPersons(Set<Actor> contactPersons) {
        this.contactPersons = contactPersons;
    }

    public Set<Actor> getContactPersons() {
        return contactPersons;
    }

    public void setOtherIdentifiers(Set<OtherIdentifier> otherIdentifiers) {
        this.otherIdentifiers = otherIdentifiers;
    }

    public Set<OtherIdentifier> getOtherIdentifiers() {
        return otherIdentifiers;
    }

    public void setParentOrganization(Organization parentOrganization) {
        this.parentOrganization = parentOrganization;
    }

    public Organization getParentOrganization() {
        return parentOrganization;
    }

    public void setSubOrganization(Set<Organization> subOrganization) {
        this.subOrganization = subOrganization;
    }

    public Set<Organization> getSubOrganization() {
        return subOrganization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

}