package com.example.demo.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @PostMapping("/login") 
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return "redirect:/dashboard.html";
    }

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/books";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Qqwerty1!";
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Failed to establish a database connection.");
        }
    }
}