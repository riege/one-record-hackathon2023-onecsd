
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Simplified shipment object that is to be used only for the distribution scope where only a subset of data is known priori to operational phase.
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_BookingShipment)
public class BookingShipment
    extends LogisticsObject
    implements Serializable
{

    /**
     * Reference to the BookingOptionRequest
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_bookingOptionRequest)
    protected Set<BookingOptionRequest> bookingOptionRequest;
    /**
     * Information about preferred HandlingInstructions for the BookingShipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_preferredHandling)
    protected Set<HandlingInstructions> preferredHandling;
    /**
     * Dimensions of the whole shipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_totalDimensions)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Dimensions totalDimensions;
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
     * Description of goods, for the BookingShipment the commodity list defined by Modernizing Cargo Distribution MCD working group can be used as a referential.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_goodsDescription)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String goodsDescription;
    /**
     * Load type of the shipment or piece (Bulk, ULD, Pallet, Loose)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_loadType)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String loadType;
    /**
     * Total Piece Count
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_totalPieceCount)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#integer", max = 1)
    })
    protected Integer totalPieceCount;

    public void setBookingOptionRequest(Set<BookingOptionRequest> bookingOptionRequest) {
        this.bookingOptionRequest = bookingOptionRequest;
    }

    public Set<BookingOptionRequest> getBookingOptionRequest() {
        return bookingOptionRequest;
    }

    public void setPreferredHandling(Set<HandlingInstructions> preferredHandling) {
        this.preferredHandling = preferredHandling;
    }

    public Set<HandlingInstructions> getPreferredHandling() {
        return preferredHandling;
    }

    public void setTotalDimensions(Dimensions totalDimensions) {
        this.totalDimensions = totalDimensions;
    }

    public Dimensions getTotalDimensions() {
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

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setTotalPieceCount(Integer totalPieceCount) {
        this.totalPieceCount = totalPieceCount;
    }

    public Integer getTotalPieceCount() {
        return totalPieceCount;
    }

}
