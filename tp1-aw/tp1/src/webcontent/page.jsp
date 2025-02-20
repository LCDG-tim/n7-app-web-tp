<%@ page language="Java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>page.jsp</title>
</head>
<body>
    <div>
        <form action="Serv1" method="get">
            nb1: <input type="text" name="nb1" value="${nb1}">
            <br>
            nb2: <input type="text" name="nb2" value="${nb2}">
            <br>
            <button type="submit">compute</button>
        </form>
        <% if (request.getAttribute("sum") != null) {  %>   
            La somme est ${sum}.
               
         <% } %>
    </div>
</body>
</html>