package n7.facade;


import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {
    
    // Compte save(Compte c) ;
    // Optional<Compte> findById(Long id);
    // Collection<Compte> findAll();
    // void delete(Compte c) ;
    // long count() ;
}
