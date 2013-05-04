package br.com.gigio.db_adapter_kickstart.util;

import org.springframework.integration.Message;

import br.com.gigio.db_adapter_kickstart.enums.ProcessingTypeEnum;
import br.com.gigio.db_adapter_kickstart.service.QueryExecutor;
import br.com.gigio.db_adapter_kickstart.service.QueryExecutorAtomic;
import br.com.gigio.db_adapter_kickstart.service.QueryExecutorScheduled;

public class ProcessingCriteria {
	
	public boolean isScheduledGenerated(Message<?> message){
		return message.getHeaders().containsKey(ProcessingTypeEnum.SCHEDULED.value()) ? true : false;
	}

	public QueryExecutor getQueryExecutorInstance(Message<?> message){
		if (isScheduledGenerated(message)) {
			return new QueryExecutorScheduled();
		} else {
			return new QueryExecutorAtomic();
		}
	}
}
