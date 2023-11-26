
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Dangerous Goods subtype of Piece
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_PieceDg)
public class PieceDg
    extends Piece
    implements Serializable
{

    /**
     * Reference to the Dangerous Goods declaration
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_dgDeclaration)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected DgDeclaration dgDeclaration;
    /**
     * A statement identifying that the dangerous goods listed above are all contained in the same outer packaging. Takes the form All packed in one aaaa (description of packaging type) x nn (number of packages). Applies to air transport only. (Air) 
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_allPackedInOneIndicator)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean allPackedInOneIndicator;
    /**
     * Applies to fissile material only, other than fissile excepted. A numeric value expressed to one decimal place preceded by the letters CSI. 
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_overpackCriticalitySafetyIndexNumeric)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String overpackCriticalitySafetyIndexNumeric;
    /**
     * Overpack indicator 
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_overpackIndicator)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean overpackIndicator;
    /**
     * A single number assigned to a package, overpack or freight container to provide control over radiation exposure. 
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_overpackT1)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean overpackT1;
    /**
     * Identifies the Logistic Unit package type. UN Recommendation on Transport of Dangerous Goods, Model Regulations 
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_overpackTypeCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean overpackTypeCode;
    /**
     * Most instances of all packed in one will require the addition of the Q value which  1. Applies to air transport only. (Air)  
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_qValueNumeric)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#double", max = 1)
    })
    protected Double qValueNumeric;

    public void setDgDeclaration(DgDeclaration dgDeclaration) {
        this.dgDeclaration = dgDeclaration;
    }

    public DgDeclaration getDgDeclaration() {
        return dgDeclaration;
    }

    public void setAllPackedInOneIndicator(Boolean allPackedInOneIndicator) {
        this.allPackedInOneIndicator = allPackedInOneIndicator;
    }

    public Boolean getAllPackedInOneIndicator() {
        return allPackedInOneIndicator;
    }

    public void setOverpackCriticalitySafetyIndexNumeric(String overpackCriticalitySafetyIndexNumeric) {
        this.overpackCriticalitySafetyIndexNumeric = overpackCriticalitySafetyIndexNumeric;
    }

    public String getOverpackCriticalitySafetyIndexNumeric() {
        return overpackCriticalitySafetyIndexNumeric;
    }

    public void setOverpackIndicator(Boolean overpackIndicator) {
        this.overpackIndicator = overpackIndicator;
    }

    public Boolean getOverpackIndicator() {
        return overpackIndicator;
    }

    public void setOverpackT1(Boolean overpackT1) {
        this.overpackT1 = overpackT1;
    }

    public Boolean getOverpackT1() {
        return overpackT1;
    }

    public void setOverpackTypeCode(Boolean overpackTypeCode) {
        this.overpackTypeCode = overpackTypeCode;
    }

    public Boolean getOverpackTypeCode() {
        return overpackTypeCode;
    }

    public void setQValueNumeric(Double qValueNumeric) {
        this.qValueNumeric = qValueNumeric;
    }

    public Double getQValueNumeric() {
        return qValueNumeric;
    }

}
