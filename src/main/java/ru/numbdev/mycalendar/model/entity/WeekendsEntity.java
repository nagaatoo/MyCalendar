package ru.numbdev.mycalendar.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import ru.numbdev.mycalendar.model.dto.WeekendsDaysDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "weekends")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class WeekendsEntity {

    @Id
    @SequenceGenerator(name = "weekendsIdSeq", sequenceName = "weekends_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weekendsIdSeq")
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
