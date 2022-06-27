import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Login extends HttpServlet {

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
                        "\t\t<form action=\"/login\" method=\"post\">\n" +
                        "\t\t\t<input type=\"text\" name=\"username\" placeholder=\"Enter your username\"><br/><br/>\n" +
                        "\t\t\t<input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Enter your password\"><br/><br/>\n" +
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
                        "\t\t\t    alert(\"password error\");\n" +
                        "\t\t\t}\n" +
                        "\t\t}\n" +
                        "\t</script>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }

}
