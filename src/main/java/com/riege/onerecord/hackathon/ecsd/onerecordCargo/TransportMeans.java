
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Transport means details
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_TransportMeans)
public class TransportMeans
    extends PhysicalLogisticsObject
    implements Serializable
{

    /**
     * Transport Movement on which the Transport Means is used
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_operatedTransportMovements)
    protected Set<TransportMovement> operatedTransportMovements;
    /**
     * Company operating the transport means
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_transportOrganization)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Company transportOrganization;
    /**
     * Required for some CO2 calculations
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_typicalCo2Coefficient)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value typicalCo2Coefficient;
    /**
     * Typical fuel comsumption (e.g. 20 000L / 1 000nm)
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_typicalFuelConsumption)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value typicalFuelConsumption;
    /**
     * Model or make of the vehicle (e.g. A330-300)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_vehicleModel)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String vehicleModel;
    /**
     * Vehicle identification - e.g. aircraft registration number
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_vehicleRegistration)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String vehicleRegistration;
    /**
     * Size of the vehicle - free text
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_vehicleSize)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String vehicleSize;
    /**
     * Vehicle or container type. Refer UNECE28, e.g. 4.00.0 - Aircraft, type unknown.For Air refer to IATA Standard Schedules Information Manua in section ATA/IATA Aircraft Types
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_vehicleType)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String vehicleType;

    public void setOperatedTransportMovements(Set<TransportMovement> operatedTransportMovements) {
        this.operatedTransportMovements = operatedTransportMovements;
    }

    public Set<TransportMovement> getOperatedTransportMovements() {
        return operatedTransportMovements;
    }

    public void setTransportOrganization(Company transportOrganization) {
        this.transportOrganization = transportOrganization;
    }

    public Company getTransportOrganization() {
        return transportOrganization;
    }

    public void setTypicalCo2Coefficient(Value typicalCo2Coefficient) {
        this.typicalCo2Coefficient = typicalCo2Coefficient;
    }

    public Value getTypicalCo2Coefficient() {
        return typicalCo2Coefficient;
    }

    public void setTypicalFuelConsumption(Value typicalFuelConsumption) {
        this.typicalFuelConsumption = typicalFuelConsumption;
    }

    public Value getTypicalFuelConsumption() {
        return typicalFuelConsumption;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleRegistration(String vehicleRegistration) {
        this.vehicleRegistration = vehicleRegistration;
    }

    public String getVehicleRegistration() {
        return vehicleRegistration;
    }

    public void setVehicleSize(String vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public String getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

}
