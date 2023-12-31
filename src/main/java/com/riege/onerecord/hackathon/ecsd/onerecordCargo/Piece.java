
package com.riege.onerecord.hackathon.ecsd.onerecordCargo;

import java.io.Serializable;
import java.util.Set;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLObjectProperty;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraint;
import cz.cvut.kbss.jopa.model.annotations.ParticipationConstraints;


/**
 * Individual piece or virtual grouping of pieces
 * 
 * This class was generated by OWL2Java 0.22.2
 * 
 */
@OWLClass(iri = Vocabulary.s_c_Piece)
public class Piece
    extends PhysicalLogisticsObject
    implements Serializable
{

    /**
     * Reference to the item(s) contained in the piece
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_containedItems)
    protected Set<Item> containedItems;
    /**
     * Reference to the parent Piece if the Piece is contained within another Piece
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_containedPieceInPiece)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Piece containedPieceInPiece;
    /**
     * Details of contained piece(s)
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_containedPieces)
    protected Set<Piece> containedPieces;
    /**
     * Product of the piece, mandatory when there are no items
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_contentDescribedByProducts)
    protected Set<Product> contentDescribedByProducts;
    /**
     * Goods production country, mandatory when there are no Items
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_contentProductionCountry)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Country contentProductionCountry;
    /**
     * Customs details
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_customsInformation)
    protected Set<CustomsInformation> customsInformation;
    /**
     * Dimensions details
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_dimensions)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Dimensions dimensions;
    /**
     * Weight details
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_grossWeight)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Value grossWeight;
    /**
     * Links to Handling instructions / service requests of the piece
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_handlingInstructions)
    protected Set<HandlingInstructions> handlingInstructions;
    /**
     * Information about other Parties involved depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_involvedParties)
    protected Set<Party> involvedParties;
    /**
     * Details about any other identifier, depending on the context of use
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_otherIdentifiers)
    protected Set<OtherIdentifier> otherIdentifiers;
    /**
     * Packaging details 
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_packagingType)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected PackagingType packagingType;
    /**
     * Shipment on which the piece is assigned to
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_partOfShipment)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected Shipment partOfShipment;
    /**
     * Security details of the piece
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_securityDeclaration)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected SecurityDeclaration securityDeclaration;
    /**
     * ULD on which the (virtual) piece has been loaded into - URIs of the ULD
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_uldReference)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected LoadingUnit uldReference;
    /**
     * Volumetric weight details
     * 
     */
    @OWLObjectProperty(iri = Vocabulary.s_p_volumetricWeight)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = Vocabulary.s_c_Thing, max = 1)
    })
    protected VolumetricWeight volumetricWeight;
    /**
     * Coload indicator for the pieces (boolean)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_coload)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean coload;
    /**
     * The value of a shipment declared for carriage purposes , NVD if no value declared
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_declaredValueForCarriage)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String declaredValueForCarriage;
    /**
     * The value of a shipment declared for customs purposes , NVD if no value declared
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_declaredValueForCustoms)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String declaredValueForCustoms;
    /**
     * Text holding an ULD Type Code if the Piece fulfills it before UnitComposition
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_fulfillsUldTypeCode)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String fulfillsUldTypeCode;
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
     * When no value is declared for Carriage, this field may be completed with the value TRUE otherwise FALSE
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_nvdForCarriage)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean nvdForCarriage;
    /**
     * When no value is declared for Customs, this field may be completed with the value TRUE otherwise FALSE
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_nvdForCustoms)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean nvdForCustoms;
    /**
     * Reference identifying how the package is marked. Field is hardcode to "SSCC-18", "UPC" or "Other"
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_packageMarkCoded)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String packageMarkCoded;
    /**
     * SSCC-18 code for the value of the package mark, company or bar code, free text, pallet code, etc.
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_packagedeIdentifier)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String packagedeIdentifier;
    /**
     * Shipping marks
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_shippingMarks)
    protected Set<String> shippingMarks;
    /**
     * Shipper's Load And Count  ( total contained piece count as provided by shipper)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_slac)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#integer", max = 1)
    })
    protected Integer slac;
    /**
     * Stackable indicator for the pieces (boolean)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_stackable)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean stackable;
    /**
     * Turnable indicator for the pieces (boolean)
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_turnable)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#boolean", max = 1)
    })
    protected Boolean turnable;
    /**
     * Unique Piece Identifier (UPID) of the piece. Refer IATA Recommended Practice 1689
     * 
     */
    @OWLDataProperty(iri = Vocabulary.s_p_upid)
    @ParticipationConstraints({
        @ParticipationConstraint(owlObjectIRI = "http://www.w3.org/2001/XMLSchema#string", max = 1)
    })
    protected String upid;

    public void setContainedItems(Set<Item> containedItems) {
        this.containedItems = containedItems;
    }

    public Set<Item> getContainedItems() {
        return containedItems;
    }

    public void setContainedPieceInPiece(Piece containedPieceInPiece) {
        this.containedPieceInPiece = containedPieceInPiece;
    }

    public Piece getContainedPieceInPiece() {
        return containedPieceInPiece;
    }

    public void setContainedPieces(Set<Piece> containedPieces) {
        this.containedPieces = containedPieces;
    }

    public Set<Piece> getContainedPieces() {
        return containedPieces;
    }

    public void setContentDescribedByProducts(Set<Product> contentDescribedByProducts) {
        this.contentDescribedByProducts = contentDescribedByProducts;
    }

    public Set<Product> getContentDescribedByProducts() {
        return contentDescribedByProducts;
    }

    public void setContentProductionCountry(Country contentProductionCountry) {
        this.contentProductionCountry = contentProductionCountry;
    }

    public Country getContentProductionCountry() {
        return contentProductionCountry;
    }

    public void setCustomsInformation(Set<CustomsInformation> customsInformation) {
        this.customsInformation = customsInformation;
    }

    public Set<CustomsInformation> getCustomsInformation() {
        return customsInformation;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setGrossWeight(Value grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Value getGrossWeight() {
        return grossWeight;
    }

    public void setHandlingInstructions(Set<HandlingInstructions> handlingInstructions) {
        this.handlingInstructions = handlingInstructions;
    }

    public Set<HandlingInstructions> getHandlingInstructions() {
        return handlingInstructions;
    }

    public void setInvolvedParties(Set<Party> involvedParties) {
        this.involvedParties = involvedParties;
    }

    public Set<Party> getInvolvedParties() {
        return involvedParties;
    }

    public void setOtherIdentifiers(Set<OtherIdentifier> otherIdentifiers) {
        this.otherIdentifiers = otherIdentifiers;
    }

    public Set<OtherIdentifier> getOtherIdentifiers() {
        return otherIdentifiers;
    }

    public void setPackagingType(PackagingType packagingType) {
        this.packagingType = packagingType;
    }

    public PackagingType getPackagingType() {
        return packagingType;
    }

    public void setPartOfShipment(Shipment partOfShipment) {
        this.partOfShipment = partOfShipment;
    }

    public Shipment getPartOfShipment() {
        return partOfShipment;
    }

    public void setSecurityDeclaration(SecurityDeclaration securityDeclaration) {
        this.securityDeclaration = securityDeclaration;
    }

    public SecurityDeclaration getSecurityDeclaration() {
        return securityDeclaration;
    }

    public void setUldReference(LoadingUnit uldReference) {
        this.uldReference = uldReference;
    }

    public LoadingUnit getUldReference() {
        return uldReference;
    }

    public void setVolumetricWeight(VolumetricWeight volumetricWeight) {
        this.volumetricWeight = volumetricWeight;
    }

    public VolumetricWeight getVolumetricWeight() {
        return volumetricWeight;
    }

    public void setCoload(Boolean coload) {
        this.coload = coload;
    }

    public Boolean getCoload() {
        return coload;
    }

    public void setDeclaredValueForCarriage(String declaredValueForCarriage) {
        this.declaredValueForCarriage = declaredValueForCarriage;
    }

    public String getDeclaredValueForCarriage() {
        return declaredValueForCarriage;
    }

    public void setDeclaredValueForCustoms(String declaredValueForCustoms) {
        this.declaredValueForCustoms = declaredValueForCustoms;
    }

    public String getDeclaredValueForCustoms() {
        return declaredValueForCustoms;
    }

    public void setFulfillsUldTypeCode(String fulfillsUldTypeCode) {
        this.fulfillsUldTypeCode = fulfillsUldTypeCode;
    }

    public String getFulfillsUldTypeCode() {
        return fulfillsUldTypeCode;
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

    public void setNvdForCarriage(Boolean nvdForCarriage) {
        this.nvdForCarriage = nvdForCarriage;
    }

    public Boolean getNvdForCarriage() {
        return nvdForCarriage;
    }

    public void setNvdForCustoms(Boolean nvdForCustoms) {
        this.nvdForCustoms = nvdForCustoms;
    }

    public Boolean getNvdForCustoms() {
        return nvdForCustoms;
    }

    public void setPackageMarkCoded(String packageMarkCoded) {
        this.packageMarkCoded = packageMarkCoded;
    }

    public String getPackageMarkCoded() {
        return packageMarkCoded;
    }

    public void setPackagedeIdentifier(String packagedeIdentifier) {
        this.packagedeIdentifier = packagedeIdentifier;
    }

    public String getPackagedeIdentifier() {
        return packagedeIdentifier;
    }

    public void setShippingMarks(Set<String> shippingMarks) {
        this.shippingMarks = shippingMarks;
    }

    public Set<String> getShippingMarks() {
        return shippingMarks;
    }

    public void setSlac(Integer slac) {
        this.slac = slac;
    }

    public Integer getSlac() {
        return slac;
    }

    public void setStackable(Boolean stackable) {
        this.stackable = stackable;
    }

    public Boolean getStackable() {
        return stackable;
    }

    public void setTurnable(Boolean turnable) {
        this.turnable = turnable;
    }

    public Boolean getTurnable() {
        return turnable;
    }

    public void setUpid(String upid) {
        this.upid = upid;
    }

    public String getUpid() {
        return upid;
    }

}
