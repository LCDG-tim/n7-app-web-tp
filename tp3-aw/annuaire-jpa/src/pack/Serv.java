package pack;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Serv")
public class Serv extends HttpServlet {

    private final Facade f;
    
    public Serv() throws ClassNotFoundException, SQLException {
        f = new Facade();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            request.setAttribute("lp", f.listePersonnes());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            request.setAttribute("la", f.listeAdresses());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.getRequestDispatcher(action + ".jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("ajoutPersonne")) {
            String prenom = request.getParameter("prenom");
            String nom = request.getParameter("nom");
            try {
                f.ajoutPersonne(nom, prenom);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            
        } else if (action.equalsIgnoreCase("ajoutAdresse")) {
            String rue = request.getParameter("rue");
            String ville = request.getParameter("ville");
            try {
                f.ajoutAdresse(rue, ville);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            
        }else if (action.equalsIgnoreCase("associer")) {
            String idP = request.getParameter("idP");
            String idA = request.getParameter("idA");
            try {
                f.associer(Integer.parseInt(idP), Integer.parseInt(idA));
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        response.sendRedirect("index.html");
    }
}