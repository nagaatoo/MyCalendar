package ru.numbdev.mycalendar.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import ru.numbdev.mycalendar.model.enums.Role;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "team")
public class TeamEntity {
    @Id
    @SequenceGenerator(name = "teamIdSeq", sequenceName = "team_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamIdSeq")
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String userLogin;
    @OneToOne
    @JoinColumn(name = "calendar_id")
    private CalendarEntity calendar;
    @Column(name = "calendar_id", updatable = false, insertable = false)
    private Long calendarId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_id")
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
