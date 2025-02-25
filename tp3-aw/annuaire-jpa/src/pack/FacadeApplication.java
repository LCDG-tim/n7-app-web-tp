package pack;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@SpringBootApplication
public class FacadeApplication {

    @Autowired
    AdresseRepository las;
    @Autowired
    PersonneRepository lps;

    public FacadeApplication() {
    }

	@PostMapping("/ajoutpersonne")
	public void ajoutPersonne(@RequestBody String nom, @RequestBody String prenom) {
        lps.save(new Personne(nom, prenom));
    }

	@PostMapping("/ajoutadresse")
	public void ajoutAdresse(@RequestBody String rue,
			@RequestBody String ville) {
        las.save(new Adresse(rue, ville));
    }

	@GetMapping("/listepersonne")
	public Collection<Personne> listePersonnes() {
        return lps.findAll();
    }

	@GetMapping("/listeadresse")
	public Collection<Adresse> listeAdresses() throws SQLException {
        return las.findAll();
    }

	@PostMapping("/associer")
	public void associer(@RequestBody int personneId,
			@RequestBody int adresseId) throws SQLException {

        // récupération addresse
        Optional<Adresse> ao = las.findById((long) adresseId);
        if ( ! ao.isPresent()) throw new RuntimeException("Adresse introuvable");
        Adresse a = ao.get();

        // récupération personne
        Optional<Personne> po = lps.findById((long) personneId);
        if ( ! po.isPresent()) throw new RuntimeException("Personne introuvable");
        Personne p = po.get();

        p.addAdresse(a);
    }
	public static void main(String[] args) {
		SpringApplication.run(FacadeApplication.class, args);
	}

}
