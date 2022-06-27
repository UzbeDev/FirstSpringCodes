import model.Result;
import model.SignUP;
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
import java.util.ArrayList;
import java.util.List;
@WebServlet("/login")
public class Login extends HttpServlet {
    private List<User> users=new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer=resp.getWriter();
        writer.write(
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "\t<meta charset=\"utf-8\">\n" +
                        "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "\t<title>Login</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\t<div style=\"margin: 0 250px;\">\n" +
                        "\t\t<h1>Login</h1>\n" +
                        "\t\t<form action=\"/login\" method=\"post\">\n" +
                        "\t\t\t<input type=\"text\" name=\"username\" id=\"username\" placeholder=\"Enter your username\"><br/><br/>\n" +
                        "\t\t\t<input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Enter your password\"><br/><br/>\n" +
                        "\t\t\t<button type=\"submit\" id=\"login\" style=\"color: red;\">Login</button> \n" +
                        "\t\t</form>\n" +
                        "\t</div>\n" +
                        "\n" +
                        " "
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer= resp.getWriter();
        if (req.getParameter("password").equals(req.getParameter("password"))){
            if (req.getParameter("username").equals(req.getParameter("username"))){
            SignUP signUP=new SignUP(
                    req.getParameter("username"),
                    req.getParameter("password"));
            DbService dbService=new DbService();
            try {
                Result result=dbService.login(signUP);
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
                                    "\t\t<h1 style=\" color: green;\">"+result.getMessage()+"</h1>" +
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
                                    "\t\t<h1 style=\" color: red;\">"+result.getMessage()+"</h1>" +
                                    "</div>" +
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

