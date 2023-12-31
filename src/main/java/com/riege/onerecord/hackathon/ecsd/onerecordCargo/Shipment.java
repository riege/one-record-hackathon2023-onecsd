
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
 * Shipment details
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Shipment)
public class Shipment
    extends PhysicalLogisticsObject
    implements Serializable
{

    /**
     * Name and UN/LOCODE code of the point or port of departure, shipment or destination, as required under the applicable delivery term
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_deliveryLocation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Location deliveryLocation;
    /**
     * Insurance details
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_insurance)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Insurance insurance;
    /**
     * Information about other Parties involved depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_involvedParties)
    protected Set<Party> involvedParties;
    /**
     * Details of contained piece(s)
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_shipmentOfPieces)
    protected Set<Piece> shipmentOfPieces;
    /**
     * Dimensions of the whole shipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_totalDimensions)
    protected Set<Dimensions> totalDimensions;
    /**
     * Total gross weight of the whole shipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_totalGrossWeight)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value totalGrossWeight;
    /**
     * Volumetric weight of the whole shipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_totalVolumetricWeight)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected VolumetricWeight totalVolumetricWeight;
    /**
     * Reference to the Waybill of the shipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_waybill)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Waybill waybill;
    /**
     * he date at which the delivery is supposed to happen. Format is YYYYMMDD.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_deliveryDate)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime deliveryDate;
    /**
     * Description of goods, for the BookingShipment the commodity list defined by Modernizing Cargo Distribution MCD working group can be used as a referential.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_goodsDescription)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String goodsDescription;
    /**
     * Standard codes as defined by UNCEFACT and ICC that correspond to international rules for the interpretation of the most commonly used trade terms in different countries. UNECE recommendation n. 5 Incoterms 2000.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_incoterms)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String incoterms;
    /**
     * payment of Other Charges will be made at origin (prepaid) or at destination (collect)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_otherChargesIndicator)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String otherChargesIndicator;
    /**
     * Total SLAC of all piece groups 
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_totalSLAC)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#integer", max = 1)
    })
    protected Integer totalSLAC;
    /**
     * payment for the Weight/Valuation will be made at origin (prepaid) or at destination (collect)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_weightValuationIndicator)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String weightValuationIndicator;

    public void setDeliveryLocation(Location deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public Location getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInvolvedParties(Set<Party> involvedParties) {
        this.involvedParties = involvedParties;
    }

    public Set<Party> getInvolvedParties() {
        return involvedParties;
    }

    public void setShipmentOfPieces(Set<Piece> shipmentOfPieces) {
        this.shipmentOfPieces = shipmentOfPieces;
    }

    public Set<Piece> getShipmentOfPieces() {
        return shipmentOfPieces;
    }

    public void setTotalDimensions(Set<Dimensions> totalDimensions) {
        this.totalDimensions = totalDimensions;
    }

    public Set<Dimensions> getTotalDimensions() {
        return totalDimensions;
    }

    public void setTotalGrossWeight(Value totalGrossWeight) {
        this.totalGrossWeight = totalGrossWeight;
    }

    public Value getTotalGrossWeight() {
        return totalGrossWeight;
    }

    public void setTotalVolumetricWeight(VolumetricWeight totalVolumetricWeight) {
        this.totalVolumetricWeight = totalVolumetricWeight;
    }

    public VolumetricWeight getTotalVolumetricWeight() {
        return totalVolumetricWeight;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }

    public Waybill getWaybill() {
        return waybill;
    }

    public void setDeliveryDate(OffsetDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OffsetDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setIncoterms(String incoterms) {
        this.incoterms = incoterms;
    }

    public String getIncoterms() {
        return incoterms;
    }

    public void setOtherChargesIndicator(String otherChargesIndicator) {
        this.otherChargesIndicator = otherChargesIndicator;
    }

    public String getOtherChargesIndicator() {
        return otherChargesIndicator;
    }

    public void setTotalSLAC(Integer totalSLAC) {
        this.totalSLAC = totalSLAC;
    }

    public Integer getTotalSLAC() {
        return totalSLAC;
    }

    public void setWeightValuationIndicator(String weightValuationIndicator) {
        this.weightValuationIndicator = weightValuationIndicator;
    }

    public String getWeightValuationIndicator() {
        return weightValuationIndicator;
    }

}
