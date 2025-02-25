package n7.facade;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
    // Compte save(Compte c) ;
    // Optional<Compte> findById(Long id);
    // Collection<Compte> findAll();
    // void delete(Compte c) ;
    // long count() ;

}
