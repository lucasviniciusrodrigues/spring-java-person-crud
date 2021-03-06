package com.lab.person.onboarding.adapter.controller.base;

import com.lab.person.onboarding.infrastructure.entity.PersonEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/person")
public interface IPersonController {

    @Operation(summary = "Get all persons from database")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return founded data",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PersonEntity[].class)) })})
    @GetMapping(value = "")
    public List<PersonEntity> getAll();

    @Operation(summary = "Get person from database")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return founded data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PersonEntity.class)) })})
    @GetMapping(value = "/{document}")
    public PersonEntity getPersonById(@PathVariable String document);

    @Operation(summary = "Insert person at database")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Return inserted data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PersonEntity.class)) })})
    @PostMapping()
    PersonEntity postPerson(PersonEntity personEntity);

    @Operation(summary = "Update person at database")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return updated person",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PersonEntity.class)) })})
    @PutMapping()
    PersonEntity updatePerson(PersonEntity personEntity);

    @Operation(summary = "Delete person from database")
    @ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Person deleted from database")})
    @DeleteMapping(value = "/{document}")
    public ResponseEntity<Object> deletePerson(@PathVariable String document);

}


