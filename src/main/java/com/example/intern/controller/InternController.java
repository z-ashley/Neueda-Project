package com.example.intern.controller;

import com.example.intern.model.Intern;
import com.example.intern.repository.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interns")
public class InternController {

    @Autowired
    private InternRepository internRepository;

    @GetMapping
    public List<Intern> getAllInterns() {
        return internRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Intern> getInternById(@PathVariable Long id) {
        Intern intern = internRepository.findById(id).orElse(null);
        if (intern == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(intern);
    }

    @PostMapping
    public Intern createIntern(@RequestBody Intern intern) {
        return internRepository.save(intern);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Intern> updateIntern(@PathVariable Long id, @RequestBody Intern internDetails) {
        Intern intern = internRepository.findById(id).orElse(null);
        if (intern == null) {
            return ResponseEntity.notFound().build();
        }

//        intern.setManager(internDetails.getManager());
//        intern.setMentor(internDetails.getMentor());
//        intern.setDepartment(internDetails.getDepartment());
//        intern.setRole(internDetails.getRole());
//        intern.setCycle(internDetails.getCycle());
//        intern.setPerformanceReview(internDetails.getPerformanceReview());

        Intern updatedIntern = internRepository.save(intern);
        return ResponseEntity.ok(updatedIntern);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIntern(@PathVariable Long id) {
        Intern intern = internRepository.findById(id).orElse(null);
        if (intern == null) {
            return ResponseEntity.notFound().build();
        }

        internRepository.delete(intern);
        return ResponseEntity.noContent().build();
    }
}
