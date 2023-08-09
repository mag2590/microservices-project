package com.example.programmingtechie.inventoryservice.service;

import com.example.programmingtechie.inventoryservice.dto.InventoryResponse;
import com.example.programmingtechie.inventoryservice.model.Inventory;
import com.example.programmingtechie.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

        private final InventoryRepository repository;
        @Transactional(readOnly = true)
        @SneakyThrows
        public List<InventoryResponse> isInStock(List<String> skuCode) {
           return repository.findBySkuCodeIn(skuCode).stream().
               map(inventory ->
                   InventoryResponse.builder()
                       .skuCode(inventory.getSkuCode())
                       .isAvailable(inventory.getQuantity() > 0)
                       .build()
               ).toList();


        }
}
