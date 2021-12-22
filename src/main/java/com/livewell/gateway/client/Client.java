package com.livewell.gateway.client;

import com.livewell.gateway.model.Encounter;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {

    RestTemplate restTemplate = new RestTemplate();
    int result;

    public Client() throws UnknownHostException {
    }

    public int getPatientIdByName(String name) {
        try {
            result = restTemplate.getForObject(
                    "http://patient-service:8089/patient/getPatientIdByName?name=" + name,
                    Integer.class);
        }
        catch(Exception e){
            result = 0;
        }

        return result;
    }

    public int getPractitionerIdByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
       try {
           result = restTemplate.getForObject(
                   "http://practitioner-service:8088/practitioner/getPractitionerIdByName?name=" + name,
                   Integer.class);
       }
       catch(Exception e){
           result = 0;
       }

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

        int encounterId = restTemplate.postForObject( "http://encounter-service:8087/encounter/create", request, Integer.class);
        return encounterId;
    }
}
