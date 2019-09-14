package com.foxminded.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
@Data
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private long groupId;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "group", orphanRemoval = true)
    @JsonManagedReference
    private List<Student> students;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ScheduleItem> scheduleItems;

    public Group() {

    }

    public Group(String groupName) {
        this(0, groupName, new ArrayList<>());
    }

    public Group(long groupId, String groupName, List<Student> students) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.students = students;
    }
}
