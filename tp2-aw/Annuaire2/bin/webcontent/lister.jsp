<%@ page language="Java" %>
<%@page import="java.util.*"%>
<%@page import="pack.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lister</title>
</head>
<body>
    <a href="index.html">HOME</a>
    <br>
    Voici la liste des personnes et adresses enregistrees :
    <% if (request.getAttribute("lp") != null) { %>
        <% Collection<Personne> lp = (Collection<Personne>) request.getAttribute("lp"); %>
        <br>
        La taille de lp est <%= lp.size() %>.
        <br>
        <ul>
            <% for (Personne p : lp) { %>
            <li>
                <%= p.toString() %>
                <%if (p.getLa().size() > 0) { %>
                <ul>
                    <% for (Adresse a : p.getLa()) { %>
                    <li>
                        <%= a.toString() %>
                    </li>
                    <% } %>
                </ul>
                <% } %>
            </li>
            <% } %>
            <br>
        </ul>
    <% } else { %>
        Veuiller charger les données.
    <% } %>
    <br>
    <% if (request.getAttribute("la") != null) { %>
        <% Collection<Adresse> la = (Collection<Adresse>) request.getAttribute("la"); %>
        La taille de la est <%= la.size() %>. <br>
        <ul>
        <% for (Adresse a : la) { %>
            <li>
                <%= a.toString() %>
            </li>
        <% } %>
        </ul>
    <% } %>

    ${exception}
</body>
</html>