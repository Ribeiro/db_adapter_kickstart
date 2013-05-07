package br.com.gigio.db_adapter_kickstart.infrastructure;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.stereotype.Repository;
import br.com.gigio.db_adapter_kickstart.domain.DataSourceMetaData;
import br.com.gigio.db_adapter_kickstart.domain.DataSourceMetaDataRowMapper;

@Repository
public class DataSourceMetaDataDAOImpl implements DataSourceMetaDataDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public int insert(DataSourceMetaData dataSourceMetaData) {
		OracleSequenceMaxValueIncrementer incr = new OracleSequenceMaxValueIncrementer (jdbcTemplate.getDataSource (), "DATASOURCE_METADATA_SEQUENCE");
		dataSourceMetaData.setId((int) (long) incr.nextLongValue());
		
		String sql = "INSERT INTO DATASOURCE_METADATA (DATASOURCE_METADATA_ID, NAME, JDBC_DRIVE, JDBC_URL, USERNAME, PASSWORD, VALIDATION_QUERY, CODEUSER, TIMESTAMP) ".concat(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		//dataSourceMetaData.setCodUser(janusUtil.getLoggedInUserJanusSid());
	    return jdbcTemplate.update(sql, new Object[] { dataSourceMetaData.getId(),
	       									    		dataSourceMetaData.getJdbcDriver(),
	       									    		dataSourceMetaData.getJdbcUrl(),
	       									    		dataSourceMetaData.getUsername(),
	       									    		dataSourceMetaData.getPassword(),
	       									    		dataSourceMetaData.getValidationQuery(),
	       									    		dataSourceMetaData.getCodUser(),
	       									    		dataSourceMetaData.getTimeStamp()
	       									   		  });
		
	}

	public int update(DataSourceMetaData dataSourceMetaData) {
		//dataSourceMetaData.setCodUser(janusUtil.getLoggedInUserJanusSid());
		String sql = "UPDATE DATASOURCE_METADATA SET NAME=?, JDBC_DRIVE=?, JDBC_URL=?, USERNAME=?, PASSWORD=?, VALIDATION_QUERY=?, CODEUSER=?, TIMESTAMP=? WHERE DATASOURCE_METADATA_ID=?";

		return jdbcTemplate.update(sql, new Object[] { dataSourceMetaData.getJdbcDriver(),
	    											    dataSourceMetaData.getJdbcUrl(),
	    											    dataSourceMetaData.getUsername(),
	    											    dataSourceMetaData.getPassword(),
	    											    dataSourceMetaData.getValidationQuery(),
	    											    dataSourceMetaData.getCodUser(),
	    											    dataSourceMetaData.getTimeStamp(), 
	    											    dataSourceMetaData.getId()});
		
	}

	public int delete(DataSourceMetaData dataSourceMetaData) {
		String sql = "DELETE FROM DATASOURCE_METADATA WHERE DATASOURCE_METADATA_ID = ?";
		return jdbcTemplate.update(sql, new Object[] { dataSourceMetaData.getId() });
	}

	public DataSourceMetaData findById(Integer id) {
		String sql = "SELECT * FROM DATASOURCE_METADATA WHERE DATASOURCE_METADATA_ID = ?";
		return (DataSourceMetaData) jdbcTemplate.queryForObject(sql, new Object[] { id }, new DataSourceMetaDataRowMapper());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<DataSourceMetaData> listAll() {
		String sql = "SELECT * FROM DATASOURCE_METADATA";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(DataSourceMetaData.class));
	}
	
}