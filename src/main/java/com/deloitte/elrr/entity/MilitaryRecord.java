package com.deloitte.elrr.entity;

import java.time.LocalDate;

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
@Table(name = "military_record")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MilitaryRecord extends Extensible<String> {

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "branch")
    private String branch;

    @Column(name = "country")
    private String country;

    @Column(name = "induction_date")
    private LocalDate inductionDate;

    @Column(name = "induction_rank")
    private String inductionRank;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "current_rank")
    private String currentRank;

    @Column(name = "current_status")
    private String currentStatus;

    @Column(name = "discharge_date")
    private LocalDate dischargeDate;

    @Column(name = "discharge_category")
    private String dischargeCategory;

    @Column(name = "discharge_rank")
    private String dischargeRank;

    @Column(name = "highest_rank")
    private String highestRank;

    @Column(name = "military_id")
    private String militaryId;

    @Override
    public final String toString() {
        return "MilitaryRecord [person=" + person + ", id=" + id + "]";
    }

}
