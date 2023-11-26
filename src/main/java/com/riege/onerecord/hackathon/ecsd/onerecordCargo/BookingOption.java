
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
 * Booking details
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_BookingOption)
public class BookingOption
    extends LogisticsObject
    implements Serializable
{

    /**
     * Reference to the Booking Segment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_bookingSegment)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingSegment bookingSegment;
    /**
     * booking times details of the Booking Option (proposed or actual)
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_bookingTimes)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingTimes bookingTimes;
    /**
     * Reference to the Carrier products included in the offer
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_carrierProductInfo)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected CarrierProduct carrierProductInfo;
    /**
     * Reference to the BookingOptionRequest the LogisticsObject is detailling
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_forBookingRequest)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingRequest forBookingRequest;
    /**
     * Carrier details
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_fromCarrier)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Carrier fromCarrier;
    /**
     * Information about other Parties involved depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_involvedParties)
    protected Set<Party> involvedParties;
    /**
     * Price of the Booking (if different from the offer)
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_price)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Price price;
    /**
     * Reference to the Booking option request
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_requestRef)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingOptionRequest requestRef;
    /**
     * Routing details of the offer, to be compared with routing preferences of the quote request
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_routing)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Routing routing;
    /**
     * Transport segment linked to the offer, including the Departure and Arrival locations
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_transportMovement)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected TransportMovement transportMovement;
    /**
     * Status of the Booking Option with regards to the step in the Sales and Booking process. Enumerated values to be defined
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_bookingOptionStatus)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String bookingOptionStatus;
    /**
     * String containing the proposed waybill number for the BookingOption
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_proposedWaybillNumber)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String proposedWaybillNumber;
    /**
     * Indicates if the offer is a perfect match to the quote request (boolean)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_requestMatchInd)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean requestMatchInd;
    /**
     * Indicate the secruty state of the shipment, screened or not
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_shipmentSecurityStatus)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String shipmentSecurityStatus;
    /**
     * Validity start date based on usage context
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_validFrom)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime validFrom;
    /**
     * Validity end date (date of expiry) based on usage context
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_validUntil)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime validUntil;

    public void setBookingSegment(BookingSegment bookingSegment) {
        this.bookingSegment = bookingSegment;
    }

    public BookingSegment getBookingSegment() {
        return bookingSegment;
    }

    public void setBookingTimes(BookingTimes bookingTimes) {
        this.bookingTimes = bookingTimes;
    }

    public BookingTimes getBookingTimes() {
        return bookingTimes;
    }

    public void setCarrierProductInfo(CarrierProduct carrierProductInfo) {
        this.carrierProductInfo = carrierProductInfo;
    }

    public CarrierProduct getCarrierProductInfo() {
        return carrierProductInfo;
    }

    public void setForBookingRequest(BookingRequest forBookingRequest) {
        this.forBookingRequest = forBookingRequest;
    }

    public BookingRequest getForBookingRequest() {
        return forBookingRequest;
    }

    public void setFromCarrier(Carrier fromCarrier) {
        this.fromCarrier = fromCarrier;
    }

    public Carrier getFromCarrier() {
        return fromCarrier;
    }

    public void setInvolvedParties(Set<Party> involvedParties) {
        this.involvedParties = involvedParties;
    }

    public Set<Party> getInvolvedParties() {
        return involvedParties;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }

    public void setRequestRef(BookingOptionRequest requestRef) {
        this.requestRef = requestRef;
    }

    public BookingOptionRequest getRequestRef() {
        return requestRef;
    }

    public void setRouting(Routing routing) {
        this.routing = routing;
    }

    public Routing getRouting() {
        return routing;
    }

    public void setTransportMovement(TransportMovement transportMovement) {
        this.transportMovement = transportMovement;
    }

    public TransportMovement getTransportMovement() {
        return transportMovement;
    }

    public void setBookingOptionStatus(String bookingOptionStatus) {
        this.bookingOptionStatus = bookingOptionStatus;
    }

    public String getBookingOptionStatus() {
        return bookingOptionStatus;
    }

    public void setProposedWaybillNumber(String proposedWaybillNumber) {
        this.proposedWaybillNumber = proposedWaybillNumber;
    }

    public String getProposedWaybillNumber() {
        return proposedWaybillNumber;
    }

    public void setRequestMatchInd(Boolean requestMatchInd) {
        this.requestMatchInd = requestMatchInd;
    }

    public Boolean getRequestMatchInd() {
        return requestMatchInd;
    }

    public void setShipmentSecurityStatus(String shipmentSecurityStatus) {
        this.shipmentSecurityStatus = shipmentSecurityStatus;
    }

    public String getShipmentSecurityStatus() {
        return shipmentSecurityStatus;
    }

    public void setValidFrom(OffsetDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public OffsetDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidUntil(OffsetDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public OffsetDateTime getValidUntil() {
        return validUntil;
    }

}