package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long session_id;
    public String session_name;
    public String session_description;
    /*
    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "session_speakers",
            joinColumns = {
                    @JoinColumn(name = "session_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "speaker_id")
            }
    )
    Set<Speaker> speakers = new HashSet< Speaker >();
    */

        @ManyToMany
        @JoinTable(
                name="session_speakers",
                joinColumns = @JoinColumn(name="session_id"),
                inverseJoinColumns = @JoinColumn(name="speaker_id")
        )
        private List<Speaker> speakers = null;

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSession_description() {
        return session_description;
    }

    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }

    public Integer getSession_length() {
        return session_length;
    }

    public void setSession_length(Integer session_length) {
        this.session_length = session_length;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    public Integer session_length;

    public Session() {
    }
}
