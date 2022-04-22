package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Загружаем драйвер JDBC для H2 DB
        Class.forName("org.h2.Driver");

        // Связываемся с базой данных, автоматически создаем тест базы данных в ~ и получаем соединение объекта соединения
        String url = "jdbc:h2:C:/Users/Руслан/OneDrive/work/haulmont/db/test";
        Connection con = DriverManager.getConnection(url, "root", "root");

        // Новая таблица данных
        String ctreateTable = "DROP TABLE test IF EXISTS; create table test(id integer,name VARCHAR(22) )";
        Statement createStatement = con.createStatement();
        long f1 = createStatement.executeUpdate(ctreateTable);
        System.out.println("Создать таблицу:" + f1);

        // вставляем данные
        String insertSql = "INSERT INTO TEST VALUES (1, 'Xiaoming')";
        Statement insertStatement = con.createStatement();
        long f2 = insertStatement.executeUpdate(insertSql);
        System.out.println("Вставить данные:" + f2);

        // Запросить данные
        String selectSql = "select id,name from test";
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
