package com.riege.onerecord.hackathon.ecsd.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.openjson.JSONArray;
import com.github.openjson.JSONObject;

import com.riege.onerecord.jsonutils.JacksonObjectMapper;

public class OneRecordDomainUtil {

    public static final String buildJSON(Object logisticsObject) throws JsonProcessingException {
        ObjectMapper m = JacksonObjectMapper.buildMapperWithoutTimezone();
        return m.writerWithDefaultPrettyPrinter().writeValueAsString(logisticsObject);
    }


    public static final <T> T getObjectFromJson(String json, Class<T> tClass) throws Exception {
        JSONObject obj = new JSONObject(json);
        if (obj.has("@graph")) {
            JSONArray arr = obj.getJSONArray("@graph");
            json = arr.get(0).toString();
        }

        ObjectMapper m = JacksonObjectMapper.buildMapperWithoutTimezone();
        return m.readValue(json, tClass);
    }
}
