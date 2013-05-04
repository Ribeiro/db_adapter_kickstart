package br.com.gigio.db_adapter_kickstart.domain;

public class DataSource {
	private Integer id;
	private String name;
	private String url;
	private Credentials credentials;
	
	public DataSource(Integer id, String name, String url, Credentials credentials){
		this.id = id;
		this.name = name;
		this.url = url;
		this.credentials = credentials;
		
	}

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public Credentials getCredentials() {
		return credentials;
	}
	
}
