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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping
    public Page<People> getAllPeople(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int size,
                                     @RequestParam(defaultValue = "personId") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return peopleRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> getPersonById(@PathVariable Long id) {
        return peopleRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public People createPerson(@RequestBody People person) {
        return peopleRepository.save(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<People> updatePerson(@PathVariable Long id, @RequestBody People personDetails) {
        return peopleRepository.findById(id).map(person -> {
            person.setFirstName(personDetails.getFirstName());
            person.setLastName(personDetails.getLastName());
            person.setBirthDate(personDetails.getBirthDate());
            return ResponseEntity.ok(peopleRepository.save(person));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable Long id) {
        if (peopleRepository.existsById(id)) {
            peopleRepository.deleteById(id);
            return "Address deleted successfully";
        } else {
            return "Address not found";
        }
    }

}
