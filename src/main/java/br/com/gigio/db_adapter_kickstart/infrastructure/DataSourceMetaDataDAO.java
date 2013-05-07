package br.com.gigio.db_adapter_kickstart.infrastructure;

import java.util.List;

import javax.sql.DataSource;

import br.com.gigio.db_adapter_kickstart.domain.DataSourceMetaData;

public interface DataSourceMetaDataDAO {
	public void setDataSource(DataSource dataSource);    
    public int insert(DataSourceMetaData dataSourceMetaData); 
    public int update(DataSourceMetaData dataSourceMetaData); 
    public int delete(DataSourceMetaData dataSourceMetaData); 
    public DataSourceMetaData findById(Integer id); 
    public List<DataSourceMetaData> listAll();

}