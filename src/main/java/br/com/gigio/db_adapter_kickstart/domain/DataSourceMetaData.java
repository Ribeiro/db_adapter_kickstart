package br.com.gigio.db_adapter_kickstart.domain;

public class DataSourceMetaData {
	private Integer id;
	private String name;
	private String jdbcDriver;
	private String jdbcUrl;
	private String username;
	private String password;
	private String validationQuery;
	private String codUser;
	private String timeStamp;

	public DataSourceMetaData() {

	}

	// All attributes are NOT NULL on DataBase
	public DataSourceMetaData(Integer id, String name, String jdbcDriver,
			String jdbcUrl, String username, String password,
			String validationQuery, String codUser, String timeStamp) {
		this.id = id;
		this.name = name;
		this.jdbcDriver = jdbcDriver;
		this.jdbcUrl = jdbcUrl;
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

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
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

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}