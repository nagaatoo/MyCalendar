package ru.numbdev.mycalendar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.numbDev.openapi.api.OrganizationApi;
import ru.numbDev.openapi.model.Organization;
import ru.numbDev.openapi.model.OrganizationCreate;
import ru.numbdev.mycalendar.service.OrganizationService;
import ru.numbdev.mycalendar.utils.Utils;

@RestController
@RequiredArgsConstructor
public class OrganizationController implements OrganizationApi {

    private final OrganizationService organizationService;

    @Override
    public ResponseEntity<Organization> organizationPost(OrganizationCreate organizationCreate) {
        return ResponseEntity.ok(organizationService.create(Utils.getUsername(), organizationCreate));
    }

    @Override
    public ResponseEntity<Organization> organizationIdPut(Long id, OrganizationCreate organizationCreate) {
        return ResponseEntity.ok(organizationService.update(id, organizationCreate));
    }

}
