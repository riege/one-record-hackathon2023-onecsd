
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Request object, refers to the Quote request or Booking request 
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_BookingOptionRequest)
public class BookingOptionRequest
    extends LogisticsObject
    implements Serializable
{

    /**
     * Reference to the BookingOptions
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_bookingOption)
    protected Set<BookingOption> bookingOption;
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
     * Reference to the BookingShipment if required
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_bookingShipmentDetails)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingShipment bookingShipmentDetails;
    /**
     * Ratings preferences of the request
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_ratingsPreference)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Ratings ratingsPreference;
    /**
     * Routing details that are part of the request, these details will be used to determine if the offer is a perfect match
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_routingPreference)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Routing routingPreference;
    /**
     * Details of the shipment that is to be shipped
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_shipmentDetails)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Shipment shipmentDetails;
    /**
     * Schedule preferences of the request
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_timePreferences)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingTimes timePreferences;
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
     * Unit preferences of the request (e.g. kg or cm)
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_unitsPreference)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value unitsPreference;
    /**
     * Reference to the Allotment as per the contracts between forwarders and carriers
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_allotment)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String allotment;
    /**
     * Expected commodity for quote request purposes only. To be defined by MCD
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_expectedCommodities)
    protected Set<String> expectedCommodities;
    /**
     * Requested handling information for quote request purposes only
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_requestedHandling)
    protected Set<String> requestedHandling;
    /**
     * Indicate the secruty state of the shipment, screened or not
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_shipmentSecurityStatus)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String shipmentSecurityStatus;

    public void setBookingOption(Set<BookingOption> bookingOption) {
        this.bookingOption = bookingOption;
    }

    public Set<BookingOption> getBookingOption() {
        return bookingOption;
    }

    public void setBookingSegment(BookingSegment bookingSegment) {
        this.bookingSegment = bookingSegment;
    }

    public BookingSegment getBookingSegment() {
        return bookingSegment;
    }

    public void setBookingShipmentDetails(BookingShipment bookingShipmentDetails) {
        this.bookingShipmentDetails = bookingShipmentDetails;
    }

    public BookingShipment getBookingShipmentDetails() {
        return bookingShipmentDetails;
    }

    public void setRatingsPreference(Ratings ratingsPreference) {
        this.ratingsPreference = ratingsPreference;
    }

    public Ratings getRatingsPreference() {
        return ratingsPreference;
    }

    public void setRoutingPreference(Routing routingPreference) {
        this.routingPreference = routingPreference;
    }

    public Routing getRoutingPreference() {
        return routingPreference;
    }

    public void setShipmentDetails(Shipment shipmentDetails) {
        this.shipmentDetails = shipmentDetails;
    }

    public Shipment getShipmentDetails() {
        return shipmentDetails;
    }

    public void setTimePreferences(BookingTimes timePreferences) {
        this.timePreferences = timePreferences;
    }

    public BookingTimes getTimePreferences() {
        return timePreferences;
    }

    public void setTransportMovement(TransportMovement transportMovement) {
        this.transportMovement = transportMovement;
    }

    public TransportMovement getTransportMovement() {
        return transportMovement;
    }

    public void setUnitsPreference(Value unitsPreference) {
        this.unitsPreference = unitsPreference;
    }

    public Value getUnitsPreference() {
        return unitsPreference;
    }

    public void setAllotment(String allotment) {
        this.allotment = allotment;
    }

    public String getAllotment() {
        return allotment;
    }

    public void setExpectedCommodities(Set<String> expectedCommodities) {
        this.expectedCommodities = expectedCommodities;
    }

    public Set<String> getExpectedCommodities() {
        return expectedCommodities;
    }

    public void setRequestedHandling(Set<String> requestedHandling) {
        this.requestedHandling = requestedHandling;
    }

    public Set<String> getRequestedHandling() {
        return requestedHandling;
    }

    public void setShipmentSecurityStatus(String shipmentSecurityStatus) {
        this.shipmentSecurityStatus = shipmentSecurityStatus;
    }

    public String getShipmentSecurityStatus() {
        return shipmentSecurityStatus;
    }

}
