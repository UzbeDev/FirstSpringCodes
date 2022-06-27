<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="service.DbService" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="model.Result" %>
<%@ page import="model.Country" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Sherzod
  Date: 11/01/2022
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Country list</title>
    <link rel="stylesheet" href="./assets/bootstrap/bootstrap/css/bootstrap.css">
</head>
<body>
<%
    DbService dbService=new DbService();
    try {
        Result result = dbService.addCountry(request.getParameter("name"));
        if (result.isSuccess()) {
            System.out.println(result.getMessage());
        }else {
            System.out.println(result.getMessage());
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <h1 class="text-info text-center">Davlatlar ruyhati</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
            <form action="/country.jsp" method="post">
                <label>
                    <input type="text" name="name" placeholder="Added country" required/>
                    <button class="btn btn-success">Save</button>
                </label>
            </form>

        </div>
    </div>
    <div class="row">
        <table class="col-md-10 table-bordered ">
                <div class="col-md-1 offset-3">

                <thread>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th colspan="2" class="text-center">Action</th>
                    </tr>
                </thread>
                <tbody>

               <%
                   try {
                       List<Country> countryList = dbService.getCountryList();
                       for (int i=0; i<countryList.size(); i++) {
                           out.println(
                                   " <tr>" +
                                           "<td>"+(i+1)+"</td>" +
                                           "<td>"+countryList.get(i).getName()+"</td>" +
                                           "<td class=\"text-center\"><button class=\"btn btn-warning text-center\">edit</button></td>" +
                                           "<td class=\"text-center\"><button class=\"btn btn-danger text-center\">delete</button></td>" +
                                           "" +
                                           "</tr>"
                           );
                       }
                   } catch (ClassNotFoundException e) {
                       e.printStackTrace();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }

               %>
                </tbody>
    </div>
        </table>
    </div>

</div>




<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
