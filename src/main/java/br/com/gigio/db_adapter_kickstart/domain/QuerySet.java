package br.com.gigio.db_adapter_kickstart.domain;

import java.util.List;
import org.springframework.integration.Message;

public class QuerySet {
	private Integer id;
	private String name;
	private DataSource dataSource;
	private List<Query> queries;
	
	public QuerySet(){
		
	}
	
	public QuerySet(Integer id, String name, DataSource dataSource, List<Query> queries){
		this.id = id;
		this.dataSource = dataSource;
		this.queries = queries;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public List<Query> getQueries() {
		return queries;
	}
	
	public boolean accept(Message<?> message){
		return true;
	}

}