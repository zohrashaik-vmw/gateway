package com.livewell.gateway.client;

import com.livewell.gateway.model.Encounter;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Client {

    RestTemplate restTemplate = new RestTemplate();
    String uri= "http://localhost:8080/";
    int result;

    public int getPatientIdByName(String name) {

        result = restTemplate.getForObject(
                uri + "patient/getPatientIdByName?name=" + name,
                Integer.class);

        return result;
    }

    public int getPractitionerIdByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        result = restTemplate.getForObject(
                uri + "practitioner/getPractitionerIdByName?name=" + name,
                Integer.class);

        return result;
    }

    public int createEncounter(int patientId, int practitionerId) throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject encounterObject = new JSONObject();
        encounterObject.put("patientId", patientId);
        encounterObject.put("practitionerId", practitionerId);

        HttpEntity<String> request =
                new HttpEntity<String>(encounterObject.toString(), headers);

        int encounterId = restTemplate.postForObject(uri + "encounter/create", request, Integer.class);
        return encounterId;
    }
}
