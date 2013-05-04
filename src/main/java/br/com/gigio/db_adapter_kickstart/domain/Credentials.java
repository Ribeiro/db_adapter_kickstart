package br.com.gigio.db_adapter_kickstart.domain;

public class Credentials {
	private Integer id;
	private String name;
	private String password;
	
	public Credentials(Integer id, String name, String password){
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}

}
