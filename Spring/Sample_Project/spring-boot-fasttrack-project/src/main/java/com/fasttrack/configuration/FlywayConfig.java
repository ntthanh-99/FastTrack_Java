package com.fasttrack.configuration;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
class FlywayConfig {

  @Autowired
  private DataSource dataSource;

  @PostConstruct
  public void migrate() {
    HikariDataSource hikariDataSource = (HikariDataSource) dataSource;
    try (Connection connection = hikariDataSource.getConnection()) {
      org.flywaydb.core.api.configuration.Configuration flywayConfig =
          Flyway.configure().validateOnMigrate(false).dataSource(hikariDataSource)
              .baselineOnMigrate(true)
              .outOfOrder(true)
              .locations("db/migration")
              .schemas("public");
      Flyway flyway = new Flyway(flywayConfig);
      flyway.migrate();
    } catch (SQLException e) {
      log.error(e.getMessage(), e);
    }
  }

}
