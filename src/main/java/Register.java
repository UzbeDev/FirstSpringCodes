import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Register extends HttpServlet{
    private static List<User> users=new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer=resp.getWriter();
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer =resp.getWriter();
        if (req.getParameter("password").equals(req.getParameter("prePassword"))){
            if (!checkUserExist(req.getParameter("username"))) {
                User user = new User();
                user.setFirstName(req.getParameter("firstName"));
                user.setLastName(req.getParameter("lastName"));
                user.setMiddleName(req.getParameter("middleName"));
                user.setUsername(req.getParameter("username"));
                user.setPassword(req.getParameter("password"));
                user.setPrePassword(req.getParameter("prePassword"));
                users.add(user);
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
                                "\t\t<h1>successfully saved user</h1>" +
                                "</div>" +
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
                                "\t\t<h1>Username already exist</h1>" +
                                "</div>" +
                                "</body>\n" +
                                "</html>"
                );
            }
        }else{
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
                            "\t\t<h1>password and preP assword not equals</h1>" +
                            "</div>" +
                            "</body>\n" +
                            "</html>"
            );
        }

    }

    private boolean checkUserExist(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}
