package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Avis;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;
import dev.top.service.ChampAvis;

@RestController // => pas besoin si @ResponseBody sur Méthode.
@RequestMapping("/collegues")
public class CollegueCtrl {

	@Autowired
	CollegueRepo collegueRepo;

	@GetMapping
	public ResponseEntity<List<Collegue>> findAll(){
		List<Collegue> listeCollegues = this.collegueRepo.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(listeCollegues);
	}

//	@GetMapping
//	public List<Collegue> findAll() {
//		return this.collegueRepo.findAll();
//	}

	@PatchMapping("/{nom}/")
	public ResponseEntity<Collegue> patch(@PathVariable String nom, @RequestBody Avis avis) {

		Collegue collegue = this.collegueRepo.findByNom(nom);

		if (avis.getAction() == ChampAvis.AIMER) {
			collegue.setScore(collegue.getScore() + 10);
			System.out.println(collegue.getScore());
		} else if (avis.getAction() == ChampAvis.DETESTER) {
			collegue.setScore(collegue.getScore() - 5);
		} else {
			System.out.println("Erreur, le body de la requête n'est pas perçu comme un Avis (enum) valide.");
		}

		this.collegueRepo.save(collegue);

		return ResponseEntity.status(HttpStatus.OK).body(collegue);
	}

}
