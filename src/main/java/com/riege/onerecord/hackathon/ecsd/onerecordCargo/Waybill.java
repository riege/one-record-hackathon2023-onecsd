
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
 * Waybill details
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Waybill)
public class Waybill
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
     * Reference to the BillingDetails of the Waybill
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_billingDetails)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected BillingDetails billingDetails;
    /**
     * Location of individual or company involved in the movement of a consignment or Coded representation of a specific airport/city code
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_carrierDeclarationPlace)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Location carrierDeclarationPlace;
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
     * Refers to the Waybill(s) contained
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_houseWaybills)
    protected Set<Waybill> houseWaybills;
    /**
     * Information about other Parties involved depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_involvedParties)
    protected Set<Party> involvedParties;
    /**
     * Reference to the master Waybill if it is contained in one
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_masterWaybill)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Waybill masterWaybill;
    /**
     * Refers to the Booking
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_referredBookingOption)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Booking referredBookingOption;
    /**
     * Reference to the Shipment
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_shipment)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Shipment shipment;
    /**
     * Indicates the details of accounting information. Free text e.g. PAYMENT BY CERTIFIED CHEQUE etc.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_accountingInformation)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String accountingInformation;
    /**
     * Date upon which the certification is made by the carrier
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_carrierDeclarationDate)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#dateTime", max = 1)
    })
    protected OffsetDateTime carrierDeclarationDate;
    /**
     * Contains the authentication of the Carrier
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_carrierDeclarationSignature)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String carrierDeclarationSignature;
    /**
     * Name of consignor signatory
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_consignorDeclarationSignature)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String consignorDeclarationSignature;
    /**
     * Code indicating the origin of goods for Customs purposes (e.g. For goods in free circulation in the EU)
     * List to be provided by local authorities
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_customsOriginCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String customsOriginCode;
    /**
     * Charges levied at destination accruing to the last carrier, in destination currency
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_destinationCharges)
    protected Set<Double> destinationCharges;
    /**
     * ISO 3-letter currency code of destination. Refer to ISO 4217
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_destinationCurrencyCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String destinationCurrencyCode;
    /**
     * Conversion rate applied
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_destinationCurrencyRate)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#double", max = 1)
    })
    protected Double destinationCurrencyRate;
    /**
     * The check is a Modular 7 validation on the AWB number, recorded as a boolean.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_modularCheckNumber)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean modularCheckNumber;
    /**
     * ISO alpha 3 Code used to indicate the Origin Currency, refer to ISO 4217 currency codes
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_originCurrency)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String originCurrency;
    /**
     * The shipper or its Agent may enter the appropriate optional shipping
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_shippingInfo)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String shippingInfo;
    /**
     * Optional shipping reference number if any
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_shippingRefNo)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String shippingRefNo;
    /**
     * House or Master Waybill unique identifier
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_waybillNumber)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String waybillNumber;
    /**
     * Prefix used for the Waybill Number. Refer to IATA Airlines Codes
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_waybillPrefix)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String waybillPrefix;
    /**
     * Type of the Waybill: House, Direct or Master
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_waybillType)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String waybillType;

    public void setArrivalLocation(Location arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public Location getArrivalLocation() {
        return arrivalLocation;
    }

    public void setBillingDetails(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    public BillingDetails getBillingDetails() {
        return billingDetails;
    }

    public void setCarrierDeclarationPlace(Location carrierDeclarationPlace) {
        this.carrierDeclarationPlace = carrierDeclarationPlace;
    }

    public Location getCarrierDeclarationPlace() {
        return carrierDeclarationPlace;
    }

    public void setDepartureLocation(Location departureLocation) {
        this.departureLocation = departureLocation;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public void setHouseWaybills(Set<Waybill> houseWaybills) {
        this.houseWaybills = houseWaybills;
    }

    public Set<Waybill> getHouseWaybills() {
        return houseWaybills;
    }

    public void setInvolvedParties(Set<Party> involvedParties) {
        this.involvedParties = involvedParties;
    }

    public Set<Party> getInvolvedParties() {
        return involvedParties;
    }

    public void setMasterWaybill(Waybill masterWaybill) {
        this.masterWaybill = masterWaybill;
    }

    public Waybill getMasterWaybill() {
        return masterWaybill;
    }

    public void setReferredBookingOption(Booking referredBookingOption) {
        this.referredBookingOption = referredBookingOption;
    }

    public Booking getReferredBookingOption() {
        return referredBookingOption;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setAccountingInformation(String accountingInformation) {
        this.accountingInformation = accountingInformation;
    }

    public String getAccountingInformation() {
        return accountingInformation;
    }

    public void setCarrierDeclarationDate(OffsetDateTime carrierDeclarationDate) {
        this.carrierDeclarationDate = carrierDeclarationDate;
    }

    public OffsetDateTime getCarrierDeclarationDate() {
        return carrierDeclarationDate;
    }

    public void setCarrierDeclarationSignature(String carrierDeclarationSignature) {
        this.carrierDeclarationSignature = carrierDeclarationSignature;
    }

    public String getCarrierDeclarationSignature() {
        return carrierDeclarationSignature;
    }

    public void setConsignorDeclarationSignature(String consignorDeclarationSignature) {
        this.consignorDeclarationSignature = consignorDeclarationSignature;
    }

    public String getConsignorDeclarationSignature() {
        return consignorDeclarationSignature;
    }

    public void setCustomsOriginCode(String customsOriginCode) {
        this.customsOriginCode = customsOriginCode;
    }

    public String getCustomsOriginCode() {
        return customsOriginCode;
    }

    public void setDestinationCharges(Set<Double> destinationCharges) {
        this.destinationCharges = destinationCharges;
    }

    public Set<Double> getDestinationCharges() {
        return destinationCharges;
    }

    public void setDestinationCurrencyCode(String destinationCurrencyCode) {
        this.destinationCurrencyCode = destinationCurrencyCode;
    }

    public String getDestinationCurrencyCode() {
        return destinationCurrencyCode;
    }

    public void setDestinationCurrencyRate(Double destinationCurrencyRate) {
        this.destinationCurrencyRate = destinationCurrencyRate;
    }

    public Double getDestinationCurrencyRate() {
        return destinationCurrencyRate;
    }

    public void setModularCheckNumber(Boolean modularCheckNumber) {
        this.modularCheckNumber = modularCheckNumber;
    }

    public Boolean getModularCheckNumber() {
        return modularCheckNumber;
    }

    public void setOriginCurrency(String originCurrency) {
        this.originCurrency = originCurrency;
    }

    public String getOriginCurrency() {
        return originCurrency;
    }

    public void setShippingInfo(String shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public String getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingRefNo(String shippingRefNo) {
        this.shippingRefNo = shippingRefNo;
    }

    public String getShippingRefNo() {
        return shippingRefNo;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillPrefix(String waybillPrefix) {
        this.waybillPrefix = waybillPrefix;
    }

    public String getWaybillPrefix() {
        return waybillPrefix;
    }

    public void setWaybillType(String waybillType) {
        this.waybillType = waybillType;
    }

    public String getWaybillType() {
        return waybillType;
    }

}
