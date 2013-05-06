package br.com.gigio.db_adapter_kickstart.util;

import org.springframework.integration.Message;

import br.com.gigio.db_adapter_kickstart.enums.ProcessingTypeEnum;

public class ProcessingCriteria {
	
	public boolean isScheduledGenerated(Message<?> message){
		return message.getHeaders().containsKey(ProcessingTypeEnum.SCHEDULED.value()) ? true : false;
	}
}
