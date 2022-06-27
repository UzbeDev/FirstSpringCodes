import model.Result;
import model.User;
import service.DbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer= resp.getWriter();
        writer.write(
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "\t<meta charset=\"utf-8\">\n" +
                        "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "\t<title>Register</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\t<div style=\"margin: 0 250px;\">\n" +
                        "\t\t<h1>Register</h1>\n" +
                        "\t\t<form action=\"/update\" method=\"post\">\n" +
                        "\t\t\t<input type=\"text\" name=\"username\" placeholder=\"Enter your username\"><br/><br/>\n" +
                        "\t\t\t<input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Enter your password\"><br/><br/>\n" +
                        "\t\t\t<button type=\"submit\" id=\"register\" onclick=\"checkPassword()\"  style=\"color: red;\">Register</button> \n" +
                        "\t\t</form>\n" +
                        "\t</div>\n"
        );
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer= resp.getWriter();
        if (req.getParameter("password").equals(req.getParameter("password"))){
            if (req.getParameter("username").equals(req.getParameter("username"))){
                User user=new User(
                        req.getParameter("firstName"),
                        req.getParameter("lastName"),
                        req.getParameter("middleName"),
                        req.getParameter("username"),
                        req.getParameter("birthDate"),
                        req.getParameter("password"),
                        req.getParameter("prePassword"));
                DbService dbService=new DbService();
                try {
                    Result result=dbService.register(user);
                    if (result.isSuccess()){
                        writer.write(
                                "<!DOCTYPE html>\n" +
                                        "<html>\n" +
                                        "<head>\n" +
                                        "\t<meta charset=\"utf-8\">\n" +
                                        "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                                        "\t<title>Register</title>\n" +
                                        "</head>\n" +
                                        "<body>\n" +
                                        "\t<div style=\"margin: 0 250px;\">\n" +
                                        "\t\t<h1>Register</h1>\n" +
                                        "\t\t<form action=\"/register\" method=\"post\">\n" +
                                        "\t\t\t<input type=\"text\" name=\"firstName\" placeholder=\"Enter your firstName\" required><br/><br/>\n" +
                                        "\t\t\t<input type=\"text\" name=\"lastName\" placeholder=\"Enter your lastName\"><br/><br/>\n" +
                                        "\t\t\t<input type=\"text\" name=\"middleName\" placeholder=\"Enter your middleName\"><br/><br/>\n" +
                                        "\t\t\t<input type=\"text\" name=\"username\" placeholder=\"Enter your username\"><br/><br/>\n" +
                                        "\t\t\t<input type=\"date\" name=\"birthDate\" placeholder=\"Enter your username\"><br/><br/>\n" +
                                        "\t\t\t<input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Enter your password\"><br/><br/>\n" +
                                        "\t\t\t<input type=\"password\" name=\"prePassword\" id=\"prePassword\" placeholder=\"Enter your prePassword\"><br/><br/>\n" +
                                        "\t\t\t<button type=\"button\" id=\"register\" onclick=\"checkPassword()\"  style=\"color: red;\">Register</button> \n" +
                                        "\t\t</form>\n" +
                                        "\t</div>\n" +
                                        "\t<script type=\"text/javascript\">\n" +
                                        "\t\tfunction checkPassword() {\n" +
                                        "\t\t\tlet password=document.getElementById(\"password\").value;\n" +
                                        "\t\t\tlet prePassword=document.getElementById(\"prePassword\").value;\n" +
                                        "\t\t\tif (password===prePassword) {\n" +
                                        "\t\t\t\tdocument.getElementById(\"register\").setAttribute(\"type\", \"submit\");\n" +
                                        "\t\t\t}else{\n" +
                                        "\t\t\t    alert(\"password and prepassword not equals\");\n" +
                                        "\t\t\t}\n" +
                                        "\t\t}\n" +
                                        "\t</script>\n" +
                                        "</body>\n" +
                                        "</html>"
                        );
                    }else {
                        writer.write(
                                "<!DOCTYPE html>\n" +
                                        "<html>\n" +
                                        "<head>\n" +
                                        "\t<meta charset=\"utf-8\">\n" +
                                        "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                                        "\t<title>Register</title>\n" +
                                        "</head>\n" +
                                        "<body>\n" +
                                        "\t<div style=\"margin: 0 250px;\">\n" +
                                        "\t\t<h1>Register</h1>\n" +
                                        "\t\t<form action=\"/register\" method=\"post\">\n" +
                                        "\t\t\t<input type=\"text\" name=\"firstName\" placeholder=\"Enter your firstName\" required><br/><br/>\n" +
                                        "\t\t\t<input type=\"text\" name=\"lastName\" placeholder=\"Enter your lastName\"><br/><br/>\n" +
                                        "\t\t\t<input type=\"text\" name=\"middleName\" placeholder=\"Enter your middleName\"><br/><br/>\n" +
                                        "\t\t\t<input type=\"text\" name=\"username\" placeholder=\"Enter your username\"><br/><br/>\n" +
                                        "\t\t\t<input type=\"date\" name=\"birthDate\" placeholder=\"Enter your username\"><br/><br/>\n" +
                                        "\t\t\t<input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Enter your password\"><br/><br/>\n" +
                                        "\t\t\t<input type=\"password\" name=\"prePassword\" id=\"prePassword\" placeholder=\"Enter your prePassword\"><br/><br/>\n" +
                                        "\t\t\t<button type=\"button\" id=\"register\" onclick=\"checkPassword()\"  style=\"color: red;\">Register</button> \n" +
                                        "\t\t</form>\n" +
                                        "\t</div>\n" +
                                        "\t<script type=\"text/javascript\">\n" +
                                        "\t\tfunction checkPassword() {\n" +
                                        "\t\t\tlet password=document.getElementById(\"password\").value;\n" +
                                        "\t\t\tlet prePassword=document.getElementById(\"prePassword\").value;\n" +
                                        "\t\t\tif (password===prePassword) {\n" +
                                        "\t\t\t\tdocument.getElementById(\"register\").setAttribute(\"type\", \"submit\");\n" +
                                        "\t\t\t}else{\n" +
                                        "\t\t\t    alert(\"password and prepassword not equals\");\n" +
                                        "\t\t\t}\n" +
                                        "\t\t}\n" +
                                        "\t</script>\n" +
                                        "</body>\n" +
                                        "</html>"
                        );
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}