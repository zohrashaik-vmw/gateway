package com.livewell.gateway.model;

public class Encounter {
    private String encounterId;
    private String patientName;
    private String practitionerName;
    private int id;
    private int patientId;
    private int practitionerId;

    public Encounter(String encounterId, String patientName, String practitionerName, int id, int patientId, int practitionerId) {
        this.encounterId = encounterId;
        this.patientName = patientName;
        this.practitionerName = practitionerName;
        this.id = id;
        this.patientId = patientId;
        this.practitionerId = practitionerId;
    }

    public String getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(String encounterId) {
        this.encounterId = encounterId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPractitionerName() {
        return practitionerName;
    }

    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPractitionerId() {
        return practitionerId;
    }

    public void setPractitionerId(int practitionerId) {
        this.practitionerId = practitionerId;
    }

    @Override
    public String toString() {
        return "Encounter{" +
                "patientName='" + patientName + '\'' +
                ", practitionerName='" + practitionerName + '\'' +
                '}';
    }
}
