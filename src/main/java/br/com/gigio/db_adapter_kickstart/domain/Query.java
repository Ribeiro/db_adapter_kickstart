package br.com.gigio.db_adapter_kickstart.domain;

import java.util.Date;

public class Query {
	private Integer id;
	private Integer queryOrder;
	private String description;
	private String type;
	private String sqlQuery;
	private Character multiRowResult;
	private String querysetName;
	private String codUser;
	private Date timeStamp;

	public Query() {

	}

	// All attributes are NOT NULL on DataBase
	public Query(Integer id, Integer queryOrder, String description,
			String type, String sqlQuery, Character multiRowResult,
			String querysetName, String codUser, Date timeStamp) {
		this.id = id;
		this.queryOrder = queryOrder;
		this.description = description;
		this.type = type;
		this.sqlQuery = sqlQuery;
		this.multiRowResult = multiRowResult;
		this.querysetName = querysetName;
		this.codUser = codUser;
		this.timeStamp = timeStamp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQueryOrder() {
		return queryOrder;
	}

	public void setQueryOrder(Integer queryOrder) {
		this.queryOrder = queryOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSqlQuery() {
		return sqlQuery;
	}

	public void setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
	}

	public Character getMultiRowResult() {
		return multiRowResult;
	}

	public void setMultiRowResult(Character multiRowResult) {
		this.multiRowResult = multiRowResult;
	}

	public String getQuerysetName() {
		return querysetName;
	}

	public void setQuerysetName(String querysetName) {
		this.querysetName = querysetName;
	}

	public String getCodUser() {
		return codUser;
	}

	public void setCodUser(String codUser) {
		this.codUser = codUser;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}