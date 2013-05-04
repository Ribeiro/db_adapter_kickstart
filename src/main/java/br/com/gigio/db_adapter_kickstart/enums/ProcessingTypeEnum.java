package br.com.gigio.db_adapter_kickstart.enums;

public enum ProcessingTypeEnum {
	
	SCHEDULED("SCHEDULED");
	
	private String value;
	
	ProcessingTypeEnum (String value){
		this.value = value;
	}

	public String value() {
		return value;
	}

}
