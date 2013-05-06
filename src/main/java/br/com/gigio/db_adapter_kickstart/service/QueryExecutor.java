package br.com.gigio.db_adapter_kickstart.service;

import java.util.List;
import java.util.Map;

import org.springframework.integration.Message;

import br.com.gigio.db_adapter_kickstart.domain.Query;
import br.com.gigio.db_adapter_kickstart.domain.QuerySet;
import br.com.gigio.db_adapter_kickstart.exception.QueryExecutorException;

public interface QueryExecutor {
	public List<Map<String, Object>> execute(Query query);
	public Message<?> atomicProcessing(Message<?> incomingMessage, List<QuerySet> acceptedQuerySetsList, DBAMessageBuilder dbaMessageBuilder) throws QueryExecutorException;
}
