package ru.numbdev.mycalendar.model.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.*;
import org.hibernate.annotations.Type;

import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import ru.numbdev.mycalendar.model.dto.ScheduleDaysDTO;


import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "schedule")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ScheduleEntity {
    @Id
    @SequenceGenerator(name = "scheduleIdSeq", sequenceName = "schedule_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scheduleIdSeq")
    private Long id;
    private Integer workDays;
    private Integer weekendDays;
    private String title;
    @Type(type = "jsonb")
    private ScheduleDaysDTO days;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedBy
    private String updatedBy;
    @LastModifiedDate
    private LocalDateTime updated;

}
