package service;

import model.*;

import java.sql.*;

public class DbService {
    private static final String url="jdbc:postgresql://localhost:5432/b1_lesson";
    private static final String dbUsername="postgres";
    private static final String dbPassword="root123";

    public static Result register(User user) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(url, dbUsername, dbPassword);
        String query="{call register(?,?,?,?,?,?,?,?,?)}";
        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setString(1, user.getFirstName());
        callableStatement.setString(2, user.getLastName());
        callableStatement.setString(3, user.getMiddleName());
        callableStatement.setString(4, user.getUsername());
        callableStatement.setString(5, user.getBirthDate());
        callableStatement.setString(6, user.getPassword());
        callableStatement.setString(7, user.getPrePassword());
        callableStatement.registerOutParameter(8, Types.VARCHAR);
        callableStatement.registerOutParameter(9, Types.BOOLEAN);
        callableStatement.executeUpdate();
        return  new Result(callableStatement.getString(8),callableStatement.getBoolean(9));
    }

    public static Result login(SignUP user) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(url, dbUsername, dbPassword);
        String query="{call login(?,?,?,?)}";
        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setString(1, user.getUsername());
        callableStatement.setString(2, user.getPassword());
        callableStatement.registerOutParameter(3, Types.VARCHAR);
        callableStatement.registerOutParameter(4, Types.BOOLEAN);
        callableStatement.executeUpdate();
        return  new Result(callableStatement.getString(3),callableStatement.getBoolean(4));
    }

    public static Result delete(Delete user) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(url, dbUsername, dbPassword);
        String query="{call delete_user(?,?,?,?)}";
        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setString(1, user.getUsername());
        callableStatement.setString(2, user.getPassword());
        callableStatement.registerOutParameter(3, Types.VARCHAR);
        callableStatement.registerOutParameter(4, Types.BOOLEAN);
        callableStatement.executeUpdate();
        return  new Result(callableStatement.getString(3),callableStatement.getBoolean(4));
    }

    public static Result register(Update user) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(url, dbUsername, dbPassword);
        String query="{call update_user(?,?,?,?,?,?,?,?,?)}";
        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setString(1, user.getFirstName());
        callableStatement.setString(2, user.getLastName());
        callableStatement.setString(3, user.getMiddleName());
        callableStatement.setString(4, user.getUsername());
        callableStatement.setString(5, user.getBirthDate());
        callableStatement.setString(6, user.getPassword());
        callableStatement.setString(7, user.getPrePassword());
        callableStatement.registerOutParameter(8, Types.VARCHAR);
        callableStatement.registerOutParameter(9, Types.BOOLEAN);
        callableStatement.executeUpdate();
        return  new Result(callableStatement.getString(8),callableStatement.getBoolean(9));
    }
}
