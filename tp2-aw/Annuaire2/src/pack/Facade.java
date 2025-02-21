package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class Facade {

    private static final String db_url = "jdbc:hsqldb:hsql://localhost/xdb";

    private static final String db_user = "sa";

    private Connection con;

    public Facade() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbcDriver");
        con = DriverManager.getConnection(db_url, db_user, null);
    }

    public void ajoutPersonne(String nom, String prenom) throws SQLException {
        try {            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Personne(nom, prenom) VALUES (?,?)");
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

	public void ajoutAdresse(String rue, String ville) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO Adresse(rue, ville) VALUES (?,?)");
        stmt.setString(1, rue);
        stmt.setString(2, ville);
        stmt.executeUpdate();
    }

	public Collection<Personne> listePersonnes() throws SQLException {
        Collection<Personne> lps = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM Personne");
        while (res.next()) {
            Personne p = new Personne(res.getInt("id"), res.getString("nom"), res.getString("prenom"));
            Statement stmt2 = con.createStatement();
            // stmt2.executeQuery("SELECT * FROM Adresse AS A INNER JOIN Personne AS P ON A.personneid = p.id WHERE p.id = " + res.getInt("id"));
            ResultSet res2 = stmt2.executeQuery("SELECT * FROM Adresse WHERE personneid = " + res.getInt("id"));
            while (res2.next()) {
                p.addAdresse(new Adresse(res2.getString("rue"), res2.getString("ville"), res2.getInt("id")));
            }
            lps.add(p);
        }
        return lps;
    }

	public Collection<Adresse> listeAdresses() throws SQLException {
        Collection<Adresse> las = new ArrayList<>();
        // try {
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Adresse");
            while (res.next()) {
                las.add(new Adresse(res.getString("rue"), res.getString("ville"), res.getInt("id")));
            }
        // } catch (Exception e) {
        // }
        return las;
    }

	public void associer(int personneId, int adresseId) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet res  = stmt.executeQuery("SELECT Rue, Ville FROM Adresse WHERE id = " + adresseId);
        while (res.next()) {
            PreparedStatement stmt2 = con.prepareStatement("INSERT INTO Adresse(rue, ville, personneid) VALUES (?,?,?)");
            stmt2.setString(1, res.getString("rue"));
            stmt2.setString(2, res.getString("ville"));
            stmt2.setInt(3, personneId);

            stmt2.executeUpdate();
        }

    }
}
