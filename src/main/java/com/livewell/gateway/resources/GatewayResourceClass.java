package com.livewell.gateway.resources;

import com.livewell.gateway.client.Client;
import com.livewell.gateway.model.Encounter;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;
;import java.net.UnknownHostException;

@RestController
@RequestMapping("/gateway")
public class GatewayResourceClass {
    @PostMapping("/createEncounter")
    public Encounter createEncounter(@RequestBody Encounter newEncounter) throws JSONException, UnknownHostException {
        Client client = new Client();
        int patientId = client.getPatientIdByName(newEncounter.getPatientName());
        int practitionerId = client.getPractitionerIdByName(newEncounter.getPractitionerName());
        int encounterId = 0;
        if (patientId > 0 && practitionerId > 0) {
            encounterId = client.createEncounter(patientId, practitionerId);
        }
        System.out.println("Patient id=" + patientId + " practitionerid =" + practitionerId);
        Encounter encounter = new Encounter();
        encounter.setId(encounterId);
        encounter.setPractitionerId(practitionerId);
        encounter.setPatientId(patientId);
        return encounter;
    }
}
