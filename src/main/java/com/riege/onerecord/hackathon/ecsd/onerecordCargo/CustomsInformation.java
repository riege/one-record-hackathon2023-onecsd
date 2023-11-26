
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Customs information details
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_CustomsInformation)
public class CustomsInformation
    extends LogisticsObject
    implements Serializable
{

    /**
     * Reference to the Piece the document was issued for
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_issuedForPiece)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Piece issuedForPiece;
    /**
     * Customs, Security and Regulatory Control Information Identifier. Coded indicator qualifying Customs related information: Item Number "I", Exemption Legend "L", System Downtime Reference "S", Unique Consignment Reference Number "U", Movement Reference Number "M" .
     * Refers to Code List 1.100
     * Condition: At least one of the three elements (Country Code, Information Identifier or Customs, Security and Regulatory Control Information Identifier) must be completed
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_contentCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String contentCode;
    /**
     * Country ISO code. Refer ISO 3166-2. At least one of the three elements (Country Code, Information Identifier or Customs, Security and Regulatory Control Information Identifier) must be completed
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_countryCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String countryCode;
    /**
     * Free text for customs remarks, not used in OCI Composition Rules Table
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_note)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String note;
    /**
     * Supplementary Customs, Security and Regulatory Control Information
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_otherCustomsInformation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String otherCustomsInformation;
    /**
     * Information Identifier. Code identifying a piece of information/entity e.g. "IMP" for import, "EXP" for export, "AGT" for Agent, "ISS" for The Regulated Agent Issuing the Security Status for a Consignment etc.
     * Condition: At least one of the three elements (Country Code, Information Identifier or Customs, Security and Regulatory Control Information Identifier) must be completed
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_subjectCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String subjectCode;

    public void setIssuedForPiece(Piece issuedForPiece) {
        this.issuedForPiece = issuedForPiece;
    }

    public Piece getIssuedForPiece() {
        return issuedForPiece;
    }

    public void setContentCode(String contentCode) {
        this.contentCode = contentCode;
    }

    public String getContentCode() {
        return contentCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setOtherCustomsInformation(String otherCustomsInformation) {
        this.otherCustomsInformation = otherCustomsInformation;
    }

    public String getOtherCustomsInformation() {
        return otherCustomsInformation;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

}