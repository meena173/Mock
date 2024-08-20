package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BankController {

    @Autowired
    private BankRepository bankRepository;

    @GetMapping("/page/{pageNo}/{pageSize}")
    public List<Bank> getPaginatedBanks(@PathVariable int pageNo, @PathVariable int pageSize,
                                        @RequestParam(defaultValue = "bankId") String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Bank> pagedResult = bankRepository.findAll(pageable);

        return pagedResult.hasContent() ? pagedResult.getContent() : new ArrayList<>();
    }



    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable Long id) {
        return bankRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Bank createBank(@RequestBody Bank bank) {
        return bankRepository.save(bank);
    }

    @PutMapping("/{id}")
    public Bank updateBank(@PathVariable Long id, @RequestBody Bank bankDetails) {
        Bank bank = bankRepository.findById(id).orElseThrow(() -> new RuntimeException("Bank not found"));

        if (bankDetails.getBankId() != null) {
            bank.setBankName(bankDetails.getBankName());
        }
        if (bankDetails.getPhoneNumber() != null) {
            bank.setPhoneNumber(bankDetails.getPhoneNumber());
        }

        return bankRepository.save(bank);
    }


    @DeleteMapping("/{id}")
    public String deleteBank(@PathVariable Long id) {
        if (bankRepository.existsById(id)) {
            bankRepository.deleteById(id);
            return "Bank deleted successfully";
        } else {
            return "Bank not found";
        }
    }

}
