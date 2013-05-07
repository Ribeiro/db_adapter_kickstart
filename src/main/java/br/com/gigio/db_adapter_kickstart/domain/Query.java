package br.com.gigio.db_adapter_kickstart.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Query {
	private Integer id;
	@NotNull(message="may not be null") @NotEmpty(message="may not be empty")
	private Integer queryOrder;
	@NotNull(message="may not be null") @NotEmpty(message="may not be empty")
	private String description;
	@NotNull(message="may not be null") @NotEmpty(message="may not be empty")
	private String type;
	@NotNull(message="may not be null") @NotEmpty(message="may not be empty")
	private String sqlQuery;
	@NotNull(message="may not be null") @NotEmpty(message="may not be empty")
	private Character multiRowResult;
	@NotNull(message="may not be null") @NotEmpty(message="may not be empty")
	private String querysetName;
	private String codUser;
	private String timeStamp;

	public Query() {

	}

	//All attributes are NOT NULL on DataBase
	public Query(Integer id, Integer queryOrder, String description,
			String type, String sqlQuery, Character multiRowResult,
			String querysetName, String codUser, String timeStamp) {
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

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}