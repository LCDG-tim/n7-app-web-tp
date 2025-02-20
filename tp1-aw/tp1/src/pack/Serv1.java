package pack;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Serv1")
public class Serv1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s1 = request.getParameter("nb1");
        String s2 = request.getParameter("nb2");
        String add = String.valueOf(Integer.parseInt(s1) + Integer.parseInt(s2));
        request.setAttribute("sum", add);
        request.getRequestDispatcher("page.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}