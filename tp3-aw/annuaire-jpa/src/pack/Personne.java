package pack;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private final String name;
    private final String firstname;

    @OneToMany
    Collection<Adresse> la;


    public Personne(String name, String firstname) {
        this.name = name;
        this.firstname = firstname;
    }

    public Collection<Adresse> getLa() {
        return la;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLa(Collection<Adresse> la) {
        this.la = la;
    }

    public void addAdresse(Adresse add) {
        la.add(add);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Personne other = (Personne) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name + " " + firstname;
    }
}