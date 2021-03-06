package br.com.gigio.db_adapter_kickstart.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.integration.Message;

public class QuerySet {
	private Integer id;
	@NotNull(message="may not be null") @NotEmpty(message="may not be empty")
	private String name;
	@NotNull(message="may not be null") @NotEmpty(message="may not be empty")
	private Character enabled;
	@NotNull(message="may not be null") @NotEmpty(message="may not be empty")
	private String dataSourceMetaDataName;
	private String cron;
	@NotNull(message="may not be null") @NotEmpty(message="may not be empty")
	private Character splitResults;
	private String groupingHeaders;
	@NotNull(message="may not be null") @NotEmpty(message="may not be empty")
	private String event;
	@NotNull(message="may not be null") @NotEmpty(message="may not be empty")
	private String product;
	private String codUser;
	private String timeStamp;
	private List<Query> queries;

	public QuerySet() {
		this.queries = new ArrayList<Query>();
	}

	public QuerySet(Integer id, String name, Character enabled,
			String dataSourceMetaDataName, String cron,
			Character splitResults, String groupingHeaders, String event,
			String product, String codUser, String timeStamp) {
		this.id = id; // NOT NULL
		this.name = name; // NOT NULL
		this.enabled = enabled;
		this.dataSourceMetaDataName = dataSourceMetaDataName; // NOT NULL
		this.cron = cron; // NULLABLE
		this.splitResults = splitResults; // NOT NULL
		this.groupingHeaders = groupingHeaders; // NULLABLE
		this.event = event; // NOT NULL
		this.product = product; // NOT NULL
		this.codUser = codUser; // NOT NULL
		this.timeStamp = timeStamp; // NOT NULL
		this.queries = queries != null ? queries : new ArrayList<Query>();
	}

	public boolean accept(Message<?> message) {
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getEnabled() {
		return enabled;
	}

	public void setEnabled(Character enabled) {
		this.enabled = enabled;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public Character getSplitResults() {
		return splitResults;
	}

	public void setSplitResults(Character splitResults) {
		this.splitResults = splitResults;
	}

	public String getGroupingHeaders() {
		return groupingHeaders;
	}

	public void setGroupingHeaders(String groupingHeaders) {
		this.groupingHeaders = groupingHeaders;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
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

	public List<Query> getQueries() {
		return queries;
	}

	public void setQueries(List<Query> queries) {
		this.queries = queries;
	}

	public String getDataSourceMetaDataName() {
		return dataSourceMetaDataName;
	}

	public void setDataSourceMetaDataName(String dataSourceMetaDataName) {
		this.dataSourceMetaDataName = dataSourceMetaDataName;
	}

}