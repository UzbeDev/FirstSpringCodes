 <%--
  Created by IntelliJ IDEA.
  User: Hacker1202
  Date: 11/01/2022
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
<head>
    <title>Country list</title>
    <link rel="stylesheet" href="./../assets/bootstrap/bootstrap/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <h1 class="text-info text-center">Davlatlar ruyhati</h1>
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
                        <c:forEach items="${davlatlar}" var="country">
                            <tr>
                                <td>${country.id}</td>
                                <td>${country.name}</td>
                            </tr>
                        </c:forEach>

                    </tbody>
            </div>
        </table>
    </div>

</div>




<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<%--<script type="text/javascript">--%>

</script>
</body>
</html>
