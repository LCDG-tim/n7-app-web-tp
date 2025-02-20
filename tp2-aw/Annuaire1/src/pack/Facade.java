package pack;

// import java.sql.Connection;
// import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Facade {

    private List<Personne> lps = new ArrayList<>();
    private List<Adresse> las = new ArrayList<>();

    
    public Facade() {
        // String db_url = "jdbc:hsqldb:hsql://localhost/xdb";
        // String db_user = "sa";
        // Class.forName("org.hsqldb.jdbcDriver");
        // Connection con = DriverManagerager.getConnection(db_url, db_user, null);
    }

    public void ajoutPersonne(String nom, String prenom) {
        Personne p = new Personne(lps.size(), nom, prenom);
        if (!lps.contains(p)) {
            lps.add(p);
        }
    }

	public void ajoutAdresse(String rue, String ville) {
        Adresse a = new Adresse(rue, ville, las.size());
        if (!las.contains(a)) {
            las.add(a);
        }
    }

	public Collection<Personne> listePersonnes() {
        return lps;
    }

	public Collection<Adresse> listeAdresses() {
        return las;
    }

	public void associer(int personneId, int adresseId){
        lps.get(personneId).addAdresse(las.get(adresseId));
    }
}
