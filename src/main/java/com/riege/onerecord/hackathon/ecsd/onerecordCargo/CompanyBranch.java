
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Company branches
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_CompanyBranch)
public class CompanyBranch
    extends Organization
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
     * Refers to the mother company of the branch
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_company)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Company company;
    /**
     * Details about any other identifier, depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_otherIdentifiers)
    protected Set<OtherIdentifier> otherIdentifiers;
    /**
     * Company branch name
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_branchName)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String branchName;
    /**
     * IATA CASS cargo agent 4 digit branch number / location identifier
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_iataCargoAgentLocationIdentifier)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String iataCargoAgentLocationIdentifier;

    public void setBasedAtLocation(Location basedAtLocation) {
        this.basedAtLocation = basedAtLocation;
    }

    public Location getBasedAtLocation() {
        return basedAtLocation;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setOtherIdentifiers(Set<OtherIdentifier> otherIdentifiers) {
        this.otherIdentifiers = otherIdentifiers;
    }

    public Set<OtherIdentifier> getOtherIdentifiers() {
        return otherIdentifiers;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setIataCargoAgentLocationIdentifier(String iataCargoAgentLocationIdentifier) {
        this.iataCargoAgentLocationIdentifier = iataCargoAgentLocationIdentifier;
    }

    public String getIataCargoAgentLocationIdentifier() {
        return iataCargoAgentLocationIdentifier;
    }

}
