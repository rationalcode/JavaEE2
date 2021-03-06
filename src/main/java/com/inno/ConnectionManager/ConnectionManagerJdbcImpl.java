package com.inno.ConnectionManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@EJB
public class ConnectionManagerJdbcImpl implements ConnectionManager {
  private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionManagerJdbcImpl.class);

  @Override
  public Connection getConnection() {
    Connection connection = null;
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(
              "jdbc:postgresql://pde:5432/jdbcDB",
              "postgres",
              "qwerty");
    } catch (SQLException | ClassNotFoundException e) {
      LOGGER.error("Some thing wrong in getConnection method", e);
    }
    return connection;
  }
}
