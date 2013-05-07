package br.com.gigio.db_adapter_kickstart.domain;

import java.util.Date;

public class DataSourceMetaData {
	private Integer id;
	private Integer name;
	private String jdbcDriver;
	private String url;
	private String username;
	private String password;
	private String validationQuery;
	private String codUser;
	private Date timeStamp;

	public DataSourceMetaData() {

	}

	// All attributes are NOT NULL on DataBase
	public DataSourceMetaData(Integer id, Integer name, String jdbcDriver,
			String url, String username, String password,
			String validationQuery, String codUser, Date timeStamp) {
		this.id = id;
		this.name = name;
		this.jdbcDriver = jdbcDriver;
		this.url = url;
		this.username = username;
		this.password = password;
		this.validationQuery = validationQuery;
		this.codUser = codUser;
		this.timeStamp = timeStamp;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getName() {
		return name;
	}

	public void setName(Integer name) {
		this.name = name;
	}

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
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