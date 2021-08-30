package com.faisaldev.taskplanner.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "user_company_tasks")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCompanyTasks {
    @Id
    @GeneratedValue(generator = "id-generator")
    @GenericGenerator(name = "id-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne
    private Users user;

    @ManyToOne
    private Companies company;

    @ManyToOne
    private Tasks task;

    @ManyToOne
    private SubTasks subTask;

    private Boolean taskEnrolled;

    private Boolean taskFinished;

    @CreationTimestamp
    private Timestamp taskEnrollDate;

    @UpdateTimestamp
    private Timestamp taskFinishDate;

    private Boolean subTaskFinished;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date subTaskFinishDate;
}
