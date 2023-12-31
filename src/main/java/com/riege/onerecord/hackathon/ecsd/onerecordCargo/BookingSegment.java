
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Booking Segment refers to the arrival and location details of a Booking Option Request or a Booking Option (offer or actual booking)
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_BookingSegment)
public class BookingSegment
    extends LogisticsObject
    implements Serializable
{

    /**
     * Reference to the arrival Location
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_arrivalLocation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Location arrivalLocation;
    /**
     * Reference to the BookingOptionRequest
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_bookingOptionRequest)
    protected Set<BookingOptionRequest> bookingOptionRequest;
    /**
     * Reference to the depature Location
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_departureLocation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Location departureLocation;
    /**
     * Reference to the BookingOptionRequest the LogisticsObject is detailling
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_forBookingOptions)
    protected Set<BookingOption> forBookingOptions;
    /**
     * When part of the Request it refers to the preferred Transport ID from the customer. When part of the BookingOption (offer or actual booking) it refers to the expected Transport ID or flight
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_preferredTransportId)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String preferredTransportId;

    public void setArrivalLocation(Location arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public Location getArrivalLocation() {
        return arrivalLocation;
    }

    public void setBookingOptionRequest(Set<BookingOptionRequest> bookingOptionRequest) {
        this.bookingOptionRequest = bookingOptionRequest;
    }

    public Set<BookingOptionRequest> getBookingOptionRequest() {
        return bookingOptionRequest;
    }

    public void setDepartureLocation(Location departureLocation) {
        this.departureLocation = departureLocation;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public void setForBookingOptions(Set<BookingOption> forBookingOptions) {
        this.forBookingOptions = forBookingOptions;
    }

    public Set<BookingOption> getForBookingOptions() {
        return forBookingOptions;
    }

    public void setPreferredTransportId(String preferredTransportId) {
        this.preferredTransportId = preferredTransportId;
    }

    public String getPreferredTransportId() {
        return preferredTransportId;
    }

}
