<%@ page language="Java" %>
<%@page import="java.util.*"%>
<%@page import="pack.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Associer</title>
</head>
<body>
    <a href="index.html">HOME</a>
    
    <form action="Serv" method="post">
        <input type="hidden" name="action" value="associer">
    Choisir la personne : <br>

    <% Collection<Personne> lp = (Collection<Personne>) request.getAttribute("lp");
    if (lp != null) {
        for (Personne p : lp) { %>
            <%= p.toString() %><input type="radio" name="idP" id="idP" value="<%= p.getId() %>"> <br>
        <% } %>
    <% } %>
        
    <br>
    Choisir l'adresse :
    <br>
    <% Collection<Adresse> la = (Collection<Adresse>) request.getAttribute("la");
    if (la != null) {
        for (Adresse a : la) { %>
            <%= a.toString() %> <input type="radio" name="idA" id="idA" value="<%= a.getId() %>"> <br>
        <% }
    } %>
    
    <br>
    <button type="submit">Associer</a>
    </form>
</body>
</html>