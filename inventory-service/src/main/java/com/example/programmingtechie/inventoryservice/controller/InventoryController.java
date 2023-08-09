package com.example.programmingtechie.inventoryservice.controller;

import com.example.programmingtechie.inventoryservice.dto.InventoryResponse;
import com.example.programmingtechie.inventoryservice.model.Inventory;
import com.example.programmingtechie.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> insInStock(@RequestParam List<String> skuCode) {

        return inventoryService.isInStock(skuCode);
    }
}
