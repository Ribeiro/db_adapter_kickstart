package br.com.gigio.db_adapter_kickstart.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

public class DataSourceMetaDataRowMapper implements RowMapper<Object>{

	public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		DataSourceMetaData dataSourceMetaData = new DataSourceMetaData();
		dataSourceMetaData.setId(resultSet.getInt("DATASOURCE_METADATA_ID"));
		dataSourceMetaData.setName(resultSet.getString("NAME"));
		dataSourceMetaData.setJdbcDriver(resultSet.getString("JDBC_DRIVE"));
		dataSourceMetaData.setJdbcUrl(resultSet.getString("JDBC_URL"));
		dataSourceMetaData.setUsername(resultSet.getString("USERNAME"));
		dataSourceMetaData.setPassword(resultSet.getString("PASSWORD"));
		dataSourceMetaData.setValidationQuery(resultSet.getString("VALIDATION_QUERY"));
		dataSourceMetaData.setCodUser(resultSet.getString("CODEUSER"));
		dataSourceMetaData.setTimeStamp(new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate("TIMESTAMP")));
		return dataSourceMetaData;
		
	}

}
