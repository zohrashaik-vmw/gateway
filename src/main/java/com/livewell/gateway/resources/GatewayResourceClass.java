package com.livewell.gateway.resources;

import com.livewell.gateway.client.Client;
import com.livewell.gateway.model.Encounter;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;
;

@RestController
@RequestMapping("/gateway")
public class GatewayResourceClass {
    @PostMapping("/createEncounter")
    public int createEncounter(@RequestBody Encounter newEncounter) throws JSONException {
        Client client = new Client();
        int patientId = client.getPatientIdByName(newEncounter.getPatientName());
        int practitionerId = client.getPractitionerIdByName(newEncounter.getPractitionerName());
        int encounterId = 0;
        if (patientId > 0 && practitionerId > 0) {
            encounterId = client.createEncounter(patientId, practitionerId);
        }
        return encounterId;
    }
}
