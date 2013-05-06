package br.com.gigio.db_adapter_kickstart.domain;

public class Query {
	private Integer id;
	private String name;
	private String type;
	private String sql;
	private Character multiRowResult;
	
	public Query(Integer id, String name, String type, String sql, Character multiRowResult){
		this.id = id;
		this.name = name;
		this.type = type;
		this.sql = sql;
		this.multiRowResult = multiRowResult;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public String getSql() {
		return sql;
	}
	
	public Character getMultiRowResult() {
		return multiRowResult;
	}

}
