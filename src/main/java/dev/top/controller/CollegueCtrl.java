package dev.top.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dev.top.entities.Avis;
import dev.top.entities.Collegue;
import dev.top.entities.CollegueApi;
import dev.top.repos.CollegueRepo;
import dev.top.service.ChampAvis;

@CrossOrigin
@RestController // => pas besoin si @ResponseBody sur Méthode.
@RequestMapping("/collegues")
public class CollegueCtrl {

	@Autowired
	CollegueRepo collegueRepo;

	@GetMapping
	public ResponseEntity<List<Collegue>> findAll() {
		List<Collegue> listeCollegues = this.collegueRepo.findAll();
		if (!listeCollegues.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(listeCollegues);
		} else

		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		}
	}

	@GetMapping("/{nom}")
	public ResponseEntity<Collegue> findByNom(@PathVariable String nom) {
		
		return this.collegueRepo.findByNom(nom)
				.map(col -> ResponseEntity.status(HttpStatus.OK).body(col))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
				
		/*
		Collegue collegue = this.collegueRepo.findByNom(nom);

		if (collegue != null) {
			return ResponseEntity.status(HttpStatus.OK).body(collegue);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		}
		*/

	}

	@PatchMapping("/{nom}/")
	@Transactional
	public ResponseEntity<Collegue> patch(@PathVariable String nom, @RequestBody Avis avis) {

		Integer modifScore;

		if (avis.getAction() == ChampAvis.AIMER) {
			modifScore = new Integer(10);
		}else if (avis.getAction() == ChampAvis.DETESTER) {
			modifScore = new Integer(-5);
		}else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.header("erreur", "le body de la requête n'est pas perçu comme un Avis (enum) valide.")
					.build(); 
		}
			
	return this.collegueRepo.findByNom(nom)
					.map(col -> {
						col.setScore(col.getScore() + modifScore);
						return ResponseEntity.status(HttpStatus.OK).body(col);					
					})
					.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
													.build());
			
		


//		Collegue collegue = this.collegueRepo.findByNom(nom);
		
//		if (collegue != null) {
//			if (avis.getAction() == ChampAvis.AIMER) {
//				collegue.setScore(collegue.getScore() + 10);
//				System.out.println(collegue.getScore());
//			} else if (avis.getAction() == ChampAvis.DETESTER) {
//				collegue.setScore(collegue.getScore() - 5);
//			} else {
//				System.out.println("Erreur, le body de la requête n'est pas perçu comme un Avis (enum) valide.");
//			}
//
//			this.collegueRepo.save(collegue);
//
//			return ResponseEntity.status(HttpStatus.OK).body(collegue);
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//		}
	}
	

//	RestTemplate rt = new RestTemplate();
//	CollegueApi[] result = rt.getForObject("http://collegues-api.cleverapps.io/collegues", CollegueApi[].class)
	
	
	@PostMapping("/{matricule}")
	public ResponseEntity<?> creerCollegue(@PathVariable String matricule, @RequestBody Collegue collegue ) {
		
		RestTemplate rt = new RestTemplate();
		CollegueApi[] result = rt.getForObject("http://collegues-api.cleverapps.io/collegues?matricule={matricule}", CollegueApi[].class,matricule);
		
		
		
		if (result == null) {
			//Est ce qu'il est mieux de le mettre dans angular?
			return ResponseEntity.status(HttpStatus.NOT_FOUND).header("not_found", "matricule").body(null);
		}else {
			
			return collegueRepo.findByNom(collegue.getNom())
								.map(col -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
														   .header("failed", "name already used")
										.build())
								.orElseGet(() -> {collegueRepo.save(collegue);
													return ResponseEntity.status(HttpStatus.OK).build();
												 });
			
			
//			if(result == collegueTrouve) {
//				collegueRepo.save(collegue);
//				return ResponseEntity.status(HttpStatus.OK).header("action", "Cree").body(null);
//			}else {
//			}
			
		}
			
	}

}
