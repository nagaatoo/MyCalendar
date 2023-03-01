package ru.numbdev.mycalendar.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record WeekendsDaysDTO(
        @JsonDeserialize(contentUsing = LocalDateDeserializer.class)
        List<LocalDate> holidays,
        @JsonDeserialize(contentUsing = LocalDateDeserializer.class)
        List<LocalDate> preholidays,
        @JsonDeserialize(contentUsing = LocalDateDeserializer.class)
        List<LocalDate> nowork
){ }
