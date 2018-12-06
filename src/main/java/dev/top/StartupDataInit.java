package dev.top;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.entities.Version;
import dev.top.repos.CollegueRepo;
import dev.top.repos.VersionRepo;

@Component
@Transactional
public class StartupDataInit {

    @Autowired
    VersionRepo versionRepo;

    @Autowired
    CollegueRepo collegueRepo;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {

        if(this.versionRepo.count() <= 0) {
            this.versionRepo.save(new Version("v1"));
            this.versionRepo.save(new Version("v2"));
            this.versionRepo.save(new Version("v3"));
            this.versionRepo.save(new Version("v4"));
        }


        if(this.collegueRepo.count() <= 0) {
        	this.collegueRepo.save(new Collegue("Mario",new Integer(0),"https://www.salford.ac.uk/__data/assets/image/0008/890072/varieties/lightbox.jpg","mario@diginamic.fr"));
        	this.collegueRepo.save(new Collegue("Chris Sharma",new Integer(0),"http://image2.redbull.com/rbcom/010/2015-04-09/1331716034694_2/0010/1/1500/1000/2/chris-sharma-makes-the-first-ascent-of-el-bon-combat-near-barcelona-spain.jpg","sharma@diginamic.fr"));
        	this.collegueRepo.save(new Collegue("Maja Vidmar",new Integer(0),"http://fr.belclimb.be/uploads/maya-vidmar02.jpg","maya-vidmar@diginamic.fr"));
        	this.collegueRepo.save(new Collegue("Seb Bouin",new Integer(0),"https://www.matahijuice.com/wp-content/uploads/2017/10/seb-bouin-matahi.jpg","seb-bouin@diginamic.fr"));
        	this.collegueRepo.save(new Collegue("Sasha Digiulian",new Integer(0),"https://www.grimper.com/media/news/janvier%202014/sasha.jpg","sasha@diginamic.fr"));
        	this.collegueRepo.save(new Collegue("Dave Graham",new Integer(0), "https://c1.staticflickr.com/7/6125/5958326452_4f80086fa2_b.jpg","dave@diginamic.fr"));
            this.collegueRepo.save(new Collegue("The one",new Integer(0), "http://blog.roddet.com/images/photo.jpeg","springMan@diginamic.fr"));
            this.collegueRepo.save(new Collegue("Nina Caprez",new Integer(0), "https://images.arcteryx.com/athletes/large/NinaCaprez_Oliana_5.jpg","nina@diginamic.fr"));
            this.collegueRepo.save(new Collegue("Adam Ondra",new Integer(0),"https://www.climbing.com/.image/t_share/MTM5MTA4OTk1NjcwNjE1MTEy/noble_adam_ondra_climbing_357_gnjpg.jpg","adam@diginamic.fr"));
       	
//        }else {
//        	Collegue mario = collegueRepo.findByNom("Mario");
//        	Collegue chris = collegueRepo.findByNom("Chris Sharma");
//        	Collegue maj = collegueRepo.findByNom("Maja Vidmar");
//        	Collegue seb = collegueRepo.findByNom("Seb Bouin");
//        	Collegue sasha = collegueRepo.findByNom("Sasha Digiulian");
//        	Collegue dave = collegueRepo.findByNom("Dave Graham");
//        	Collegue theOne = collegueRepo.findByNom("The one");
//        	Collegue nina = collegueRepo.findByNom("Nina Caprez");
//        	Collegue adam = collegueRepo.findByNom("Adam Ondra");
//
//        	mario.miseAJourCollegue("Mario",new Integer(0),"https://www.salford.ac.uk/__data/assets/image/0008/890072/varieties/lightbox.jpg","mario@diginamic.fr");
//        	chris.miseAJourCollegue("Chris Sharma",new Integer(0),"http://image2.redbull.com/rbcom/010/2015-04-09/1331716034694_2/0010/1/1500/1000/2/chris-sharma-makes-the-first-ascent-of-el-bon-combat-near-barcelona-spain.jpg","sharma@diginamic.fr");
//        	maj.miseAJourCollegue("Maja Vidmar",new Integer(0),"http://fr.belclimb.be/uploads/maya-vidmar02.jpg","maya-vidmar@diginamic.fr");
//        	seb.miseAJourCollegue("Seb Bouin",new Integer(0),"https://www.matahijuice.com/wp-content/uploads/2017/10/seb-bouin-matahi.jpg","seb-bouin@diginamic.fr");
//        	sasha.miseAJourCollegue("Sasha Digiulian",new Integer(0),"https://www.grimper.com/media/news/janvier%202014/sasha.jpg","sasha@diginamic.fr");
//        	dave.miseAJourCollegue("Dave Graham",new Integer(0), "https://c1.staticflickr.com/7/6125/5958326452_4f80086fa2_b.jpg","dave@diginamic.fr");
//            theOne.miseAJourCollegue("The one",new Integer(0), "http://blog.roddet.com/images/photo.jpeg","springMan@diginamic.fr");
//            nina.miseAJourCollegue("Nina Caprez",new Integer(0), "https://images.arcteryx.com/athletes/large/NinaCaprez_Oliana_5.jpg","nina@diginamic.fr");
//           	adam.miseAJourCollegue("Adam Ondra",new Integer(0),"https://www.climbing.com/.image/t_share/MTM5MTA4OTk1NjcwNjE1MTEy/noble_adam_ondra_climbing_357_gnjpg.jpg","adam@diginamic.fr");
        }
        
    }
}
