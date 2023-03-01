package ru.numbdev.mycalendar.model.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import ru.numbdev.mycalendar.model.dto.OfficialWeekendsDTO;
import ru.numbdev.mycalendar.model.dto.WeekendsDaysDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "official_weekends")
public class OfficialWeekendsEntity {
    @Id
    @SequenceGenerator(name = "officialWeekendsIdSeq", sequenceName = "official_weekends_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "officialWeekendsIdSeq")
    private Long id;
    @Type(type = "jsonb")
    private WeekendsDaysDTO days;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedBy
    private String updatedBy;
    @LastModifiedDate
    private LocalDateTime updated;
}
