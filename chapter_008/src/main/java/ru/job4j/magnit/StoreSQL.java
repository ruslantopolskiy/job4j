package ru.job4j.magnit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreSQL implements AutoCloseable {
    private Connection connect;

    public StoreSQL(Config config) {
        try {
            this.connect = DriverManager.getConnection(config.get("url"));
            System.out.println("Подключение к базе данных: " + config.get("url"));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void create() {
        try (Statement statement = connect.createStatement()) {
            String sqlCreate = "CREATE TABLE IF NOT EXISTS Entries(field INT)";
            String sqlClear = "DELETE FROM Entries";
            statement.executeUpdate(sqlCreate);
            statement.executeUpdate(sqlClear);
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public void generate(int size) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO Entries VALUES (?)")) {
            connect.setAutoCommit(false);
            for (int i = 0; i < size; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connect.commit();
        } catch (Exception e) {
            e.getStackTrace();
            try {
                connect.rollback();
            } catch (SQLException e1) {
                e1.getErrorCode();
            }
        }
    }

    public List<Entry> load() {
        List<Entry> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connect.prepareStatement("SELECT field FROM Entries")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Entry entry = new Entry(resultSet.getString("field"));
                list.add(entry);
            }
        }catch (Exception e){
            e.getStackTrace();
        }

        return list;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }
}