package ru.numbdev.mycalendar.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @SequenceGenerator(name = "taskIdSeq", sequenceName = "task_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskIdSeq")
    private Long id;
    private boolean personal;
    private String text;
    private int order;
    private String groupUuid;
    private String completeText;
    private boolean done;
    private String userLogin;
    private String userControl;
    private Boolean approved;
    private String approvingComment;
    private LocalDateTime date;
    private LocalDateTime deadline;
    private LocalDateTime completeDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calendar_id")
    @ToString.Exclude
    private CalendarEntity calendar;
    @Column(name = "calendar_id", updatable = false, insertable = false)
    private Long calendarId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    @ToString.Exclude
    private ScheduleEntity schedule;
    @Column(name = "schedule_id", updatable = false, insertable = false)
    private Long scheduleId;

    @CreatedBy
    private String createdBy;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedBy
    private String updatedBy;
    @LastModifiedDate
    private LocalDateTime updated;
}
