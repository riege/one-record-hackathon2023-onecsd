
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.Id;
import cz.cvut.kbss.jopa.model.annotations.OWLAnnotationProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;
import cz.cvut.kbss.jopa.model.annotations.Properties;
import cz.cvut.kbss.jopa.model.annotations.Types;
import cz.cvut.kbss.jopa.vocabulary.RDFS;


/**
 * Measurements details for Sensors, either generic or geolocation measurements are recorded
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Measurement)
public class Measurement
    implements Serializable
{

    @Id(generated = true)
    protected String id;
    @OWLAnnotationProperty(iri = RDFS.LABEL)
    protected String name;
    @OWLAnnotationProperty(iri = cz.cvut.kbss.jopa.vocabulary.DC.Elements.DESCRIPTION)
    protected String description;
    @Types
    protected Set<String> types;
    @Properties
    protected Map<String, Set<String>> properties;
    /**
     * Information about all non-Geolocation values of the measurement
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_measurementValue)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value measurementValue;
    /**
     * Reference to the Geolocation recorded of the measurement
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_recordedGeolocation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Geolocation recordedGeolocation;
    /**
     * Timestamp for the measurement
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_measurementTimestamp)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime measurementTimestamp;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTypes(Set<String> types) {
        this.types = types;
    }

    public Set<String> getTypes() {
        return types;
    }

    public void setProperties(Map<String, Set<String>> properties) {
        this.properties = properties;
    }

    public Map<String, Set<String>> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return ((((("Measurement {"+ name)+"<")+ id)+">")+"}");
    }

    public void setMeasurementValue(Value measurementValue) {
        this.measurementValue = measurementValue;
    }

    public Value getMeasurementValue() {
        return measurementValue;
    }

    public void setRecordedGeolocation(Geolocation recordedGeolocation) {
        this.recordedGeolocation = recordedGeolocation;
    }

    public Geolocation getRecordedGeolocation() {
        return recordedGeolocation;
    }

    public void setMeasurementTimestamp(OffsetDateTime measurementTimestamp) {
        this.measurementTimestamp = measurementTimestamp;
    }

    public OffsetDateTime getMeasurementTimestamp() {
        return measurementTimestamp;
    }

}
