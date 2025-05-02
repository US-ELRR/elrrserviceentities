package com.deloitte.elrr.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "facility")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Facility extends Auditable<String> {

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "operational_status")
    private String operationalStatus;

    @Column(name = "facility_security_level")
    private String facilitySecurityLevel;

    @Override
    public String toString() {
        return "Facility [name = " + name + ", description=" + description
        + ", id=" + id + ", location=" + location + ", operational_status="
        + operationalStatus + ", facility_security_level="
        + facilitySecurityLevel + "]";
    }
}
