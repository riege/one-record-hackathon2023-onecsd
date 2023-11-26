
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.time.OffsetDateTime;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Previsouly called Schedule. This object refers to times used for the Booking Option Request (preferences part of the request) or the Booking Option (times sur as LAT where there is a commitment from the carrier)
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_BookingTimes)
public class BookingTimes
    extends LogisticsObject
    implements Serializable
{

    /**
     * Reference to the BookingOptionRequest the information of the LogisticsObject is detailling
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_forBookingOptionRequest)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingOptionRequest forBookingOptionRequest;
    /**
     * Reference to the BookingOptionRequest the LogisticsObject is detailling
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_forBookingOptions)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BookingOption forBookingOptions;
    /**
     * Earliest acceptance date time (requested or proposed)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_earliestAcceptanceTime)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime earliestAcceptanceTime;
    /**
     * Latest Acceptance time as per CargoIQ definition (requested, proposed or actual)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_latestAcceptanceTime)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime latestAcceptanceTime;
    /**
     * Latest arrival time at destination
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_latestArrivalTime)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime latestArrivalTime;
    /**
     * Time of availability of the shipment as per CargoIQ definition
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_timeOfAvailability)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime timeOfAvailability;
    /**
     * Total transit time as per CargoIQ definition, expressed as a duration
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_totalTransitTime)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/1999/02/22-rdf-syntax-ns#PlainLiteral", max = 1)
    })
    protected String totalTransitTime;

    public void setForBookingOptionRequest(BookingOptionRequest forBookingOptionRequest) {
        this.forBookingOptionRequest = forBookingOptionRequest;
    }

    public BookingOptionRequest getForBookingOptionRequest() {
        return forBookingOptionRequest;
    }

    public void setForBookingOptions(BookingOption forBookingOptions) {
        this.forBookingOptions = forBookingOptions;
    }

    public BookingOption getForBookingOptions() {
        return forBookingOptions;
    }

    public void setEarliestAcceptanceTime(OffsetDateTime earliestAcceptanceTime) {
        this.earliestAcceptanceTime = earliestAcceptanceTime;
    }

    public OffsetDateTime getEarliestAcceptanceTime() {
        return earliestAcceptanceTime;
    }

    public void setLatestAcceptanceTime(OffsetDateTime latestAcceptanceTime) {
        this.latestAcceptanceTime = latestAcceptanceTime;
    }

    public OffsetDateTime getLatestAcceptanceTime() {
        return latestAcceptanceTime;
    }

    public void setLatestArrivalTime(OffsetDateTime latestArrivalTime) {
        this.latestArrivalTime = latestArrivalTime;
    }

    public OffsetDateTime getLatestArrivalTime() {
        return latestArrivalTime;
    }

    public void setTimeOfAvailability(OffsetDateTime timeOfAvailability) {
        this.timeOfAvailability = timeOfAvailability;
    }

    public OffsetDateTime getTimeOfAvailability() {
        return timeOfAvailability;
    }

    public void setTotalTransitTime(String totalTransitTime) {
        this.totalTransitTime = totalTransitTime;
    }

    public String getTotalTransitTime() {
        return totalTransitTime;
    }

}
