package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class AppDAO {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        // Загружаем драйвер JDBC для H2 DB
        Class.forName("org.h2.Driver");

        // Связываемся с базой данных, автоматически создаем тест базы данных в ~ и получаем соединение объекта соединения
        String url = "jdbc:h2:C:/Users/Руслан/OneDrive/work/haulmont/db/faculty";
        Connection con = DriverManager.getConnection(url, "root", "root");
        String createTable = "";

        Path path = Paths.get("src/main/resources/students.sql");

        StringBuilder sb = new StringBuilder();

        try (Stream stream = Files.lines(path)) {
            stream.forEach(s -> sb.append(s).append("\n"));

        } catch (IOException ex) {
            // Handle exception
        }

        createTable = sb.toString();


        // Новая таблица данных

        Statement createStatement = con.createStatement();
        long f1 = createStatement.executeUpdate(createTable);
        System.out.println("Создать таблицу:" + f1);

        // вставляем данные
        String insertSql = "INSERT INTO STUDENTS VALUES (1, 'Ruslan','Satybaev','Abdimanapovich','1988-06-25','electronica')";
        Statement insertStatement = con.createStatement();
        long f2 = insertStatement.executeUpdate(insertSql);
        System.out.println("Вставить данные:" + f2);

        // Запросить данные
        String selectSql = "select id,first_name from STUDENTS";
        PreparedStatement prepareStatement = con.prepareStatement(selectSql);
        // Отправляем SQL и возвращаем ResultSet
        ResultSet rs = prepareStatement.executeQuery();

        // Редактируем набор результатов
        while (rs.next())// Получаем строку данных из БД, есть ли другая
        {
            int id = rs.getInt(1); // начинаем с 1
            String name = rs.getString(2);
            System.out.println("id:" + id + "'\' tName:" + name);
        }

        // закрываем соединение

        con.close();
    }
}
