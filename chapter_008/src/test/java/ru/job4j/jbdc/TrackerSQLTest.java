package ru.job4j.jbdc;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.hamcrest.Matchers.is;

public class TrackerSQLTest {
    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class.getName());
    private Connection connection;
    private String name = "postgres";
    private String password = "password";
    private String url = "jdbc:postgresql://localhost:5432/tracker";

/*        @Test
        public void checkConnection() {
            TrackerSQL sql = new TrackerSQL();
            assertThat(sql.init(), is(true));
     /*

    @Test
    public void createItem() {
        TrackerSQL tracker = new TrackerSQL();
        tracker.add(new Item("name4443", "desc"));
        assertThat(tracker.findByName("name4443").size(), is(1));
    }*/

    public Connection init() {
        try {
              this.connection = DriverManager.getConnection(this.url, this.name, this.password);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return connection;
    }

    @Test
    public void createItem2() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }

    }
