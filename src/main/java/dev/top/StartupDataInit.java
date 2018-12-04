package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.entities.Version;
import dev.top.repos.CollegueRepo;
import dev.top.repos.VersionRepo;

@Component
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
        	this.collegueRepo.save(new Collegue("Mario","https://www.salford.ac.uk/__data/assets/image/0008/890072/varieties/lightbox.jpg"));
        	this.collegueRepo.save(new Collegue("Chris Sharma","http://image2.redbull.com/rbcom/010/2015-04-09/1331716034694_2/0010/1/1500/1000/2/chris-sharma-makes-the-first-ascent-of-el-bon-combat-near-barcelona-spain.jpg"));
        	this.collegueRepo.save(new Collegue("Maja Vidmar","http://fr.belclimb.be/uploads/maya-vidmar02.jpg"));
        	this.collegueRepo.save(new Collegue("Seb Bouin","https://www.matahijuice.com/wp-content/uploads/2017/10/seb-bouin-matahi.jpg"));
        	this.collegueRepo.save(new Collegue("Sasha Digiulian","https://www.grimper.com/media/news/janvier%202014/sasha.jpg"));
        	this.collegueRepo.save(new Collegue("Dave Graham", "https://c1.staticflickr.com/7/6125/5958326452_4f80086fa2_b.jpg"));
            this.collegueRepo.save(new Collegue("The one", "http://blog.roddet.com/images/photo.jpeg"));
            this.collegueRepo.save(new Collegue("Nina Caprez", "https://images.arcteryx.com/athletes/large/NinaCaprez_Oliana_5.jpg"));
            this.collegueRepo.save(new Collegue("Adam Ondra","https://www.climbing.com/.image/t_share/MTM5MTA4OTk1NjcwNjE1MTEy/noble_adam_ondra_climbing_357_gnjpg.jpg"));
          
        	
        }
    }
}
