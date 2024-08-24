package com.makersharks.controller;

import com.makersharks.model.NatureOfBusiness;
import com.makersharks.model.Supplier;
import com.makersharks.service.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Operation(summary = "Query suppliers by location, nature of business, and manufacturing process")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the suppliers",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Supplier.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Suppliers not found",
                    content = @Content)
    })
    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(
            @RequestParam String location,
            @RequestParam NatureOfBusiness natureOfBusiness,
            @RequestParam String process,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Supplier> suppliers = supplierService.searchSuppliers(location, natureOfBusiness, process, page, size);
        return ResponseEntity.ok(suppliers);
    }
}
