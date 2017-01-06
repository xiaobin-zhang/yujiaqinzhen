package com.yjqz.binge.batch.xml.config;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.embedded.ConnectionProperties;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseConfigurer;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.util.ClassUtils;

public class H2Config implements EmbeddedDatabaseConfigurer{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@SuppressWarnings("unchecked")
	@Override
	public void configureConnectionProperties(ConnectionProperties properties, String databaseName) {
		try
		{
			properties.setDriverClass((Class<? extends Driver>) ClassUtils.forName("org.h2.Driver", H2Config.class.getClassLoader()));
			properties.setUrl(String.format("jdbc:h2:mem:%s;DB_CLOSE_DELAY=-1;MVCC=true", databaseName));
			properties.setUsername("sa");
			properties.setPassword("");
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public void shutdown(DataSource dataSource, String databaseName) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute("SHUTDOWN");
		}
		catch (SQLException ex)
		{
			if (logger.isWarnEnabled()) {
				logger.warn("Could not shutdown embedded database", ex);
			}
		}
		finally
		{
			if (connection != null)
			{
				JdbcUtils.closeConnection(connection);
			}
		}
	}

}
