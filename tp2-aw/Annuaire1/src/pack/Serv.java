package pack;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Serv")
public class Serv extends HttpServlet {

    private Facade f = new Facade();
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        request.setAttribute("lp", f.listePersonnes());
        request.setAttribute("la", f.listeAdresses());
        request.getRequestDispatcher(action + ".jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("ajoutPersonne")) {
            String prenom = request.getParameter("prenom");
            String nom = request.getParameter("nom");
            f.ajoutPersonne(nom, prenom);
            
            
        } else if (action.equalsIgnoreCase("ajoutAdresse")) {
            String rue = request.getParameter("rue");
            String ville = request.getParameter("ville");
            f.ajoutAdresse(rue, ville);

            
        }else if (action.equalsIgnoreCase("associer")) {
            String idP = request.getParameter("idP");
            String idA = request.getParameter("idA");
            f.associer(Integer.parseInt(idP), Integer.parseInt(idA));
        }
        response.sendRedirect("index.html");
    }
}