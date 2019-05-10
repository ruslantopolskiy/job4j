package ru.job4j.jbdc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrackerSQL implements ITracker, AutoCloseable {

    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class.getName());
    private Connection connection;
    private String name = "postgres";
    private String password = "password";
    private String url = "jdbc:postgresql://localhost:5432/tracker";

    public TrackerSQL(Connection connection) {
        this.connection = connection;
    }

    public boolean init() {
        try {
            this.connection = DriverManager.getConnection(this.url, this.name, this.password);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return this.connection != null;
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO items (name ,description,date) VALUES(?,?,NOW());", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getDescription());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                item.setId(resultSet.getString(1));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE items SET name =?,description =?,date = NOW() WHERE id = ?;")) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(1, item.getDescription());
            preparedStatement.setInt(1, Integer.parseInt(item.getId()));
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                result = true;
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        int rows = 0;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement("DELETE FROM items WHERE id = ?;")) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return rows > 0;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM items;")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Item item = new Item(name, description);
                result.add(item);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public ArrayList findByName(String key) {
        List<String> result = new ArrayList<>();
        String name = null;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT name FROM items WHERE name = ?;")) {
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString("name");
                result.add(name);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return (ArrayList) result;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT  * FROM items WHERE id = ?")) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                item = new Item(name, description);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
    }
}