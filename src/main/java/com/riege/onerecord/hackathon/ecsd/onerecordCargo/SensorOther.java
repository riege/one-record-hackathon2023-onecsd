
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;


/**
 * Sensor measurements details for sensors other than Geolocation sensors (sensorType != "Geolocation")
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_SensorOther)
public class SensorOther
    extends Sensor
    implements Serializable
{

    /**
     * Reference to the measurements recorded by the sensor
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_measurementsOther)
    protected Set<MeasurementsOther> measurementsOther;

    public void setMeasurementsOther(Set<MeasurementsOther> measurementsOther) {
        this.measurementsOther = measurementsOther;
    }

    public Set<MeasurementsOther> getMeasurementsOther() {
        return measurementsOther;
    }

}