package ru.numbdev.mycalendar.model.spec;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import ru.numbDev.openapi.model.Pagable;
import ru.numbdev.mycalendar.model.entity.CalendarEntity;

@RequiredArgsConstructor
public class CalendarSpecification implements Specification<CalendarEntity> {

    private final Pagable params;
    private final String owner;

    @Override
    public Predicate toPredicate(Root<CalendarEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        var predicates = new ArrayList<Predicate>();

        predicates.add(builder.equal(root.get("ownerLogin"), owner));
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
