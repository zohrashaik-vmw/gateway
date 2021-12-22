package com.livewell.gateway.model;

public class Encounter {
    private int encounterId;
    private String patientName;
    private String practitionerName;
    private int patientId;
    private int practitionerId;

    public Encounter(int encounterId, String patientName, String practitionerName, int patientId, int practitionerId) {
        this.encounterId = encounterId;
        this.patientName = patientName;
        this.practitionerName = practitionerName;
        this.patientId = patientId;
        this.practitionerId = practitionerId;
    }
    public Encounter(){

    }

    public int getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(int encounterId) {
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
