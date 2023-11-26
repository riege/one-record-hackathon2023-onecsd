
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Item details
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Item)
public class Item
    extends PhysicalLogisticsObject
    implements Serializable
{

    /**
     * URI of the PIECE that contains the Item
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_containedItemInPiece)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Piece containedItemInPiece;
    /**
     * URI of the product
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_describedByProduct)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Country describedByProduct;
    /**
     * Dimensions details
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_dimensions)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Dimensions dimensions;
    /**
     * Quantity of the item when applicable, with associated units of measure
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_itemQuantity)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value itemQuantity;
    /**
     * Details about any other identifier, depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_otherIdentifiers)
    protected Set<OtherIdentifier> otherIdentifiers;
    /**
     * Production country details
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_productionCountry)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Country productionCountry;
    /**
     * Item target country
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_targetCountry)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Country targetCountry;
    /**
     * Product price per unit in the base
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_unitPrice)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value unitPrice;
    /**
     * Weight of the item
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_weight)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value weight;
    /**
     * Production batch number / reference
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_batchNumber)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String batchNumber;
    /**
     * Product expiry date - e.g. for perishables goods or goods with programmed obsolescence
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_expiryDate)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime expiryDate;
    /**
     * Production lot number / reference
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_lotNumber)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String lotNumber;
    /**
     * Production date
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_productionDate)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime productionDate;
    /**
     * Product quantity for unit price - e.g. 12 (eggs for one USD 1)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_quantityForUnitPrice)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#double", max = 1)
    })
    protected Double quantityForUnitPrice;

    public void setContainedItemInPiece(Piece containedItemInPiece) {
        this.containedItemInPiece = containedItemInPiece;
    }

    public Piece getContainedItemInPiece() {
        return containedItemInPiece;
    }

    public void setDescribedByProduct(Country describedByProduct) {
        this.describedByProduct = describedByProduct;
    }

    public Country getDescribedByProduct() {
        return describedByProduct;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setItemQuantity(Value itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Value getItemQuantity() {
        return itemQuantity;
    }

    public void setOtherIdentifiers(Set<OtherIdentifier> otherIdentifiers) {
        this.otherIdentifiers = otherIdentifiers;
    }

    public Set<OtherIdentifier> getOtherIdentifiers() {
        return otherIdentifiers;
    }

    public void setProductionCountry(Country productionCountry) {
        this.productionCountry = productionCountry;
    }

    public Country getProductionCountry() {
        return productionCountry;
    }

    public void setTargetCountry(Country targetCountry) {
        this.targetCountry = targetCountry;
    }

    public Country getTargetCountry() {
        return targetCountry;
    }

    public void setUnitPrice(Value unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Value getUnitPrice() {
        return unitPrice;
    }

    public void setWeight(Value weight) {
        this.weight = weight;
    }

    public Value getWeight() {
        return weight;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setExpiryDate(OffsetDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public OffsetDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setProductionDate(OffsetDateTime productionDate) {
        this.productionDate = productionDate;
    }

    public OffsetDateTime getProductionDate() {
        return productionDate;
    }

    public void setQuantityForUnitPrice(Double quantityForUnitPrice) {
        this.quantityForUnitPrice = quantityForUnitPrice;
    }

    public Double getQuantityForUnitPrice() {
        return quantityForUnitPrice;
    }

}
