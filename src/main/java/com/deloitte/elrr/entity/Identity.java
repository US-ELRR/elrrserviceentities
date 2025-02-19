package com.deloitte.elrr.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "identity")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Identity extends Auditable<String> {
    
    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;

    @Column(name="mbox_sha1sum")
    private String mboxSha1Sum;

    @Column(name="mbox")
    private String mbox;

    @Column(name="openid")
    private String openid;

    @Column(name="home_page")
    private String homePage;

    @Column(name="name")
    private String name;

    @Column(name="ifi", nullable=false, length=255, updatable=false, insertable=false)
    @Setter(AccessLevel.NONE)
    private String ifi;

    @Override
    public String toString() {
        return "Identity [person=" + person + ", mboxSha1Sum=" + mboxSha1Sum + ", id=" + id + ", mbox=" + mbox
                + ", openid=" + openid + ", homePage=" + homePage + ", name=" + name + ", ifi=" + ifi + "]";
    }

}
