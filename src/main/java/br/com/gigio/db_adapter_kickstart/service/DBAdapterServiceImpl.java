package br.com.gigio.db_adapter_kickstart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;

import br.com.gigio.db_adapter_kickstart.domain.QuerySet;
import br.com.gigio.db_adapter_kickstart.util.ProcessingCriteria;

public class DBAdapterServiceImpl implements DBAdapterService{

	public Message<?> process(Message<?> message) {
		ProcessingCriteria processingCriteria = new ProcessingCriteria();
		QueryExecutor queryExecutor = processingCriteria.getQueryExecutorInstance(message);
		
		if (queryExecutor instanceof QueryExecutorScheduled) {
			//recupera o QuerySet do BD usando o Id ou Nome que consta no Payload e depois
			return queryExecutor.execute(new QuerySet());
			
		} else {
			List<QuerySet> acceptedQuerySetsList = new ArrayList<QuerySet>();
			List<QuerySet> allQuerySets = retrieveAll();
			
			for (QuerySet currentQuerySet : allQuerySets) {
				if (currentQuerySet.accept(message)) {
					acceptedQuerySetsList.add(currentQuerySet);
				}
				
			}
			
			if (acceptedQuerySetsList.size() > 1 || acceptedQuerySetsList.size() == 0) {
				return MessageBuilder.withPayload("ERROR").build();
				
			} else {
				return queryExecutor.execute(acceptedQuerySetsList.get(0));
				
			}

		}
		
	}

	public List<QuerySet> retrieveAll() {
		return new ArrayList<QuerySet>();
	}
	
	public static void main(String[] args) {
		DBAdapterService das = new DBAdapterServiceImpl();
		das.process(MessageBuilder.withPayload("querySet").setHeader("SCHEDULED", "SCHEDULE").build());
		
	}

}