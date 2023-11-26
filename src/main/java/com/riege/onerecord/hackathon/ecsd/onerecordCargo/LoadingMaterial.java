
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * LoadingMaterial describes transportable, complementary non-Piece objects such as dry ice or nets
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_LoadingMaterial)
public class LoadingMaterial
    extends PhysicalLogisticsObject
    implements Serializable
{

    /**
     * Manufacturing company details and contacts
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_manufacturer)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Organization manufacturer;
    /**
     * Details about any other identifier, depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_otherIdentifiers)
    protected Set<OtherIdentifier> otherIdentifiers;
    /**
     * Natural language description if required
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_description)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String description;
    /**
     * Model of the LoadingMaterial if any
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_materialModel)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String materialModel;
    /**
     * Type of the LoadingMaterial
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_materialType)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String materialType;
    /**
     * Serial number that allows to uniquely identify the object
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_serialNumber)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String serialNumber;

    public void setManufacturer(Organization manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Organization getManufacturer() {
        return manufacturer;
    }

    public void setOtherIdentifiers(Set<OtherIdentifier> otherIdentifiers) {
        this.otherIdentifiers = otherIdentifiers;
    }

    public Set<OtherIdentifier> getOtherIdentifiers() {
        return otherIdentifiers;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setMaterialModel(String materialModel) {
        this.materialModel = materialModel;
    }

    public String getMaterialModel() {
        return materialModel;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

}
