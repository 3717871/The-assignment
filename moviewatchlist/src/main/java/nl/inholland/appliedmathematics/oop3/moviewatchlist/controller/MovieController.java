package nl.inholland.appliedmathematics.oop3.moviewatchlist.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import nl.inholland.appliedmathematics.oop3.moviewatchlist.service.IMovieService;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final IMovieService movieService;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPeople() {
        return ResponseEntity.ok(personService.getAllPeople());
    }

    @PostMapping
    public ResponseEntity<Void> createPerson(@RequestBody PersonDTO personDTO) {
        personService.createPerson(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable UUID id, @RequestBody PersonDTO personDTO) {
        Person updatedPerson = personService.updatePerson(id, personDTO);
        return ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable UUID id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Person>> findPersonByName(@PathVariable String name) {
        return ResponseEntity.ok(personService.findPersonByName(name));
    }


}
