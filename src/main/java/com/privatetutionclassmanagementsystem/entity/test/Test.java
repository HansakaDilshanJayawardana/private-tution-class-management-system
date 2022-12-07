package com.privatetutionclassmanagementsystem.entity.test;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "private_tution_class_management_system_test")
@Audited
@Getter
@Setter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testId;
    private String testColumn;
}
