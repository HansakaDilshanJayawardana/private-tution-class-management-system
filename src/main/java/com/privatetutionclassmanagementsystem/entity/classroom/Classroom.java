package com.privatetutionclassmanagementsystem.entity.classroom;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "private_tution_class_management_system_classroom")
@Audited
@Getter
@Setter
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroomId;

    private String classroomCode;
    private String classroomName;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdOn;
    private int createdBy;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedOn;
    private Integer modifiedBy;

    private String floor;
    private Integer capacity;
    private Boolean isAC;
    private Boolean isAvailable;
}
