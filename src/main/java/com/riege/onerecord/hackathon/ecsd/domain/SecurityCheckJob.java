package com.riege.onerecord.hackathon.ecsd.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import com.riege.onerecord.hackathon.ecsd.onerecordCargo.Location;
import com.riege.onerecord.hackathon.ecsd.onerecordCargo.Shipment;
import com.riege.onerecord.hackathon.ecsd.onerecordCargo.Waybill;

public class SecurityCheckJob implements Serializable {

    @Id
    private String id;

    // Audit information
    private LocalDateTime creationTimestamp;

    // MongoDB credential's from Vault are not valid immediately, so we must not perform
    // database operations (like ensuring indexes) on application startup.
    // @Indexed(expireAfter = "92d")
    private LocalDateTime updateTimestamp;

    // See README.md for details
    private String partyIssueingRegulatedEntityNumber;
    private String waybillNumber;
    private String natureOfGoods;
    private String origin;
    private String destination;
    private String securityStatus;
    private String screeningMethod;
    private String statusIssuedBy;
    private LocalDateTime statusIssuedOn;
    private String partyAcceptingRegulatedEntityNumber;

    // *****************************************************************************************************************

    private SecurityCheckJob() {
        // nop
    }

    public static SecurityCheckJob create() {
        SecurityCheckJob result = new SecurityCheckJob();
        result.id = UUID.randomUUID().toString();
        return result;
    }

    public static SecurityCheckJob createDemo() {
        return loadData("e9e5990a-aad9-4f19-a696-d9bd6824c195");
    }

    public static SecurityCheckJob loadData(String identifier) {
        OneRecordConnector connector = new OneRecordConnector();
        Optional<Shipment> shipObj = connector.getLogisticsObject(identifier, Shipment.class);

        SecurityCheckJob result = create();
        if (shipObj.isPresent()) {
            Shipment ship = shipObj.get();

            String[] sp = ship.getWaybill().getId().split("/");
            Optional<Waybill> wayBillObject = connector.getLogisticsObject(sp[4], Waybill.class);

            if (wayBillObject.isPresent()){
                Waybill bill = wayBillObject.get();
                result.waybillNumber = bill.getWaybillPrefix() + "-" + bill.getWaybillNumber();

                String originId = bill.getDepartureLocation().getId().replace("neone:", "");
                Optional<Location> originLocObj = connector.getLogisticsObject(originId, Location.class);
                if (originLocObj.isPresent()) {
                    Location origin = originLocObj.get();
                    result.origin = origin.getCode();
                }
                else{
                    result.origin                               = "HAM";
                }

                String destId = bill.getArrivalLocation().getId().replace("neone:", "");
                Optional<Location> destLocObj = connector.getLogisticsObject(destId, Location.class);
                if (destLocObj.isPresent()) {
                    Location dest = destLocObj.get();
                    result.destination = dest.getCode();
                }
                else{
                    result.destination                               = "JFK";
                }
            }
            else{
                result.waybillNumber = "020-11111111";
            }

            result.partyIssueingRegulatedEntityNumber   = "DE/RA/123456-001";
            result.natureOfGoods                        = ship.getGoodsDescription();
            result.securityStatus                       = "SCO";
            result.screeningMethod                      = "XRY";
        }
        else{
            result.partyIssueingRegulatedEntityNumber   = "DE/RA/123456-001";
            result.waybillNumber                        = "020-11111111";
            result.natureOfGoods                        = "Aircraft engine spare part";
            result.origin                               = "HAM";
            result.destination                          = "JFK";
            result.securityStatus                       = "SCO";
            result.screeningMethod                      = "XRY";
        }
        return result;

    }

    // *****************************************************************************************************************

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public LocalDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(LocalDateTime updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public String getPartyIssueingRegulatedEntityNumber() {
        return partyIssueingRegulatedEntityNumber;
    }

    public void setPartyIssueingRegulatedEntityNumber(String partyIssueingRegulatedEntityNumber) {
        this.partyIssueingRegulatedEntityNumber = partyIssueingRegulatedEntityNumber;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public String getNatureOfGoods() {
        return natureOfGoods;
    }

    public void setNatureOfGoods(String natureOfGoods) {
        this.natureOfGoods = natureOfGoods;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(String securityStatus) {
        this.securityStatus = securityStatus;
    }

    public String getScreeningMethod() {
        return screeningMethod;
    }

    public void setScreeningMethod(String screeningMethod) {
        this.screeningMethod = screeningMethod;
    }

    public String getStatusIssuedBy() {
        return statusIssuedBy;
    }

    public void setStatusIssuedBy(String statusIssuedBy) {
        this.statusIssuedBy = statusIssuedBy;
    }

    public LocalDateTime getStatusIssuedOn() {
        return statusIssuedOn;
    }

    public void setStatusIssuedOn(LocalDateTime statusIssuedOn) {
        this.statusIssuedOn = statusIssuedOn;
    }

    public String getPartyAcceptingRegulatedEntityNumber() {
        return partyAcceptingRegulatedEntityNumber;
    }

    public void setPartyAcceptingRegulatedEntityNumber(String partyAcceptingRegulatedEntityNumber) {
        this.partyAcceptingRegulatedEntityNumber = partyAcceptingRegulatedEntityNumber;
    }
}
