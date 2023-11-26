package com.riege.onerecord.hackathon.ecsd.domain;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.openjson.JSONObject;

import com.riege.onerecord.hackathon.ecsd.onerecordCargo.SecurityDeclaration;

public class OneRecordConnector {
    private Logger logger;
    private String token;

    public OneRecordConnector() {
        logger = LoggerFactory.getLogger(OneRecordConnector.class);
        token = "";
    }

    private void createToken() throws Exception{
        logger.info("Creating 1R token");

        if (token != null && !token.isEmpty()) {
            return;
        }

        Map<String, String> parameters = new HashMap<>();
        parameters.put("grant_type", "client_credentials");
        parameters.put("client_id", "neone-client");

        String form = parameters.entrySet()
            .stream()
            .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
            .collect(Collectors.joining("&"));

        byte[] base64Bytes = Base64.encodeBase64("neone-client:lx7ThS5aYggdsMm42BP3wMrVqKm9WpNY".getBytes());

        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("https://3p5ind9upy.us-east-1.awsapprunner.com/realms/neone/protocol/openid-connect/token"))
            .POST(HttpRequest.BodyPublishers.ofString(form))
            .version(HttpClient.Version.HTTP_1_1)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .header("Accept", "*/*")
            .header("Authorization", "Basic " + new String(base64Bytes))
            .build();

        HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofMinutes(1))
            .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject responseObject = new JSONObject(response.body());
        token = responseObject.getString("access_token");
        logger.info(response.body());
    }

    public void sendSecurityDeclaration (SecurityDeclaration declaration) {
        logger.info("Preparing send of security declaration");
        try {
            createToken();

            if (token == null || token.isEmpty()) {
                throw new Exception("Token was unexpectedly empty");
            }

            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://hkrps7vtam.us-east-1.awsapprunner.com:443/logistics-objects"))
                .POST(HttpRequest.BodyPublishers.ofString(OneRecordDomainUtil.buildJSON(declaration)))
                .version(HttpClient.Version.HTTP_1_1)
                .header("Content-Type", "application/ld+json; version=2.0.0-dev")
                .header("Accept", "application/ld+json; version=2.0.0-dev")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Authorization", "Bearer " + token)
                .build();

            HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMinutes(1))
                .build();

            logger.info("Sending request");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 201) {
                Optional<String> location = response.headers().firstValue("location");
                logger.info("Created logistics object: " + location);
            }
            else{
                logger.info("Error creating logistics object, HTTP-Code: " + response.statusCode());
                logger.info(response.body());
            }
        } catch (Exception e) {
            logger.error("Unable to send securit declaration", e);
        }
    }

    public <T> Optional<T> getLogisticsObject(String identifier, Class<T> tClass) {
        logger.info("Preparing get of shipment");
        try {
            createToken();

            if (token == null || token.isEmpty()) {
                throw new Exception("Token was unexpectedly empty");
            }

            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://hkrps7vtam.us-east-1.awsapprunner.com:443/logistics-objects/" + identifier))
                .GET()
                .version(HttpClient.Version.HTTP_1_1)
                .header("Content-Type", "application/ld+json; version=2.0.0-dev")
                .header("Accept", "application/ld+json; version=2.0.0-dev")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Authorization", "Bearer " + token)
                .build();

            HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMinutes(1))
                .build();

            logger.info("Sending request");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                logger.info("Got logistics object: " + identifier);
                logger.info(response.body());

                return Optional.of(OneRecordDomainUtil.getObjectFromJson(response.body(), tClass));
            }
            else{
                logger.info("Error getting logistics object, HTTP-Code: " + response.statusCode());
                logger.info(response.body());
            }
        } catch (Exception e) {
            logger.error("Unable to get logistics object", e);
        }
        return Optional.empty();
    }
}
