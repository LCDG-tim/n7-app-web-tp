package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Facade {

    private static final String db_url = "jdbc:hsqldb:hsql://localhost/xdb";

    private static final String db_user = "sa";

    private Connection con;

    public Facade() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            con = DriverManager.getConnection(db_url, db_user, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ajoutPersonne(String nom, String prenom) {
        try {            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Personne(nom, prenom) VALUES (?,?)");
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

	public void ajoutAdresse(String rue, String ville) {
        try {            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Adresse(rue, ville) VALUES (?,?)");
            stmt.setString(1, rue);
            stmt.setString(2, ville);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

	public Collection<Personne> listePersonnes() {
        Collection<Personne> lps = new ArrayList<>();
        try {            
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Personne");
            while (res.next()) {
                lps.add(new Personne(res.getInt("id"), res.getString("nom"), res.getString("prenom")));
            }
        } catch (Exception e) {
        }
        return lps;
    }

	public Collection<Adresse> listeAdresses() {
        Collection<Adresse> las = new ArrayList<>();
        try {            
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Adresse");
            while (res.next()) {
                las.add(new Adresse(res.getString("rue"), res.getString("ville"), res.getInt("id")));
            }
        } catch (Exception e) {
        }
        return las;
    }

	public void associer(int personneId, int adresseId){
        try {            
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("INSERT INTO Adresse VALUES (SELECT (rue, Ville) FROM Adresse WHERE id = " + adresseId + ", "+ personneId + ")");
        } catch (Exception e) {
        }
    }
}
