package com.james.spring.jpa.postgresql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.james.spring.jpa.postgresql.model.Kolumns;
import com.james.spring.jpa.postgresql.repository.TutorialRepository;

@CrossOrigin(origins = "http://localhost:3456")
@RestController
@RequestMapping("/api")
public class TutorialController {

	@Autowired
	TutorialRepository tutorialRepository;



	@GetMapping("/kolumns")
	public ResponseEntity<List<Kolumns>> getAllTutorials(@RequestParam(required = false) String kolumna1) {
		try {
			List<Kolumns> Columns1 = new ArrayList<Kolumns>();

			if (kolumna1 == null) {
				tutorialRepository.findAll().forEach(Columns1::add);
			} else tutorialRepository.findByKolumnsContaining(kolumna1).forEach(Columns1::add);

			if (Columns1.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(Columns1, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/kolumns/{id}")
	public ResponseEntity<Kolumns> getTutorialById(@PathVariable("id") long id) {
		Optional<Kolumns> tutorialData = tutorialRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/kolumnsPost")
	public ResponseEntity<Kolumns> createTutorial(@RequestBody Kolumns kolumns) {
		try {
			Kolumns _kolumns = tutorialRepository
					.save(new Kolumns(kolumns.getKolumna1(), (String) kolumns.getKolumna2(),kolumns.getKolumna3(),kolumns.getKolumna4()));
			return new ResponseEntity<>(_kolumns, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/kolumns/{id}")
	public ResponseEntity<Kolumns> updateTutorial(@PathVariable("id") long id, @RequestBody Kolumns kolumns) {
		Optional<Kolumns> tutorialData = tutorialRepository.findById(id);

		if (tutorialData.isPresent()) {
			Kolumns _kolumns = tutorialData.get();
			_kolumns.setKolumna(kolumns.getKolumna1());
			_kolumns.setKolumna2(kolumns.getKolumna2());
			_kolumns.setKolumna3(kolumns.getKolumna3());
			_kolumns.setKolumna4(kolumns.getKolumna4());
//			_kolumns.setPublished(kolumns.getPublished());
			return new ResponseEntity<>(tutorialRepository.save(_kolumns), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/kolumns/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			tutorialRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/kolumns")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			tutorialRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
//
//	@GetMapping("/tutorials/published")
//	public ResponseEntity<List<Kolumns>> findByPublished() {
//		try {
//
//			List<Kolumns> kolumns = tutorialRepository.findByPublished(true);
//
//			if (kolumns.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return new ResponseEntity<>(kolumns, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

}
