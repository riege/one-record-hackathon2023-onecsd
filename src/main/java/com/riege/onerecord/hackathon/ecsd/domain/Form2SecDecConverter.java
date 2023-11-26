package com.riege.onerecord.hackathon.ecsd.domain;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.riege.onerecord.hackathon.ecsd.onerecordCargo.Company;
import com.riege.onerecord.hackathon.ecsd.onerecordCargo.Person;
import com.riege.onerecord.hackathon.ecsd.onerecordCargo.Piece;
import com.riege.onerecord.hackathon.ecsd.onerecordCargo.RegulatedEntity;
import com.riege.onerecord.hackathon.ecsd.onerecordCargo.SecurityDeclaration;

public class Form2SecDecConverter {
    public static SecurityDeclaration convert(SecurityCheckJob job) {
        Logger logger = LoggerFactory.getLogger(Form2SecDecConverter.class);

        SecurityDeclaration dec = new SecurityDeclaration();
        dec.setTypes(Set.of("https://onerecord.iata.org/ns/cargo#SecurityDeclaration"));
        logger.info("Created empty security declaration");

        Person issuedBy = new Person();
        issuedBy.setTypes(Set.of("https://onerecord.iata.org:443/ns/cargo#Person"));
        issuedBy.setName(job.getStatusIssuedBy());
        dec.setIssuedBy(issuedBy);
        logger.info("Added issuedBy");

        dec.setIssuedOn(OffsetDateTime.of(job.getStatusIssuedOn(), ZoneOffset.UTC));
        logger.info("Added issuedOn");

        dec.setSecurityStatus(job.getSecurityStatus());
        logger.info("Added security status");

        Set<String> screeningMethods = new HashSet<>();
        screeningMethods.add(job.getScreeningMethod());
        dec.setScreeningMethods(screeningMethods);
        logger.info("Added screening methods");

        Piece piece = new Piece();
        piece.setTypes(Set.of("https://onerecord.iata.org:443/ns/cargo#Piece"));
        piece.setId("https://hkrps7vtam.us-east-1.awsapprunner.com/logistics-objects/efbbfc01-8c23-4d57-a6d6-d93ede15ba2e");
        dec.setIssuedForPiece(piece);
        logger.info("Added piece");

        RegulatedEntity issuer = new RegulatedEntity();
        issuer.setTypes(Set.of("https://onerecord.iata.org:443/ns/cargo#RegulatedEntity"));
        issuer.setCategory("RA");
        Company issuerCompany = new Company();
        issuerCompany.setTypes(Set.of("https://onerecord.iata.org:443/ns/cargo#Company"));
        issuerCompany.setIataCargoAgentCode(job.getPartyIssueingRegulatedEntityNumber());
        issuer.setIdentifier(issuerCompany);
        dec.setRegulatedEntityIssuer(issuer);
        logger.info("Added regulated entity issuer");
        logger.info("Converted security declaration");
        return dec;
    }
}
