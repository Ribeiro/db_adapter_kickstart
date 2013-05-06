package br.com.gigio.db_adapter_kickstart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;

import br.com.gigio.db_adapter_kickstart.domain.QuerySet;
import br.com.gigio.db_adapter_kickstart.util.ProcessingCriteria;

public class DBAdapterServiceImpl implements DBAdapterService {

	public Message<?> process(Message<?> incomingMessage) {
		ProcessingCriteria processingCriteria = new ProcessingCriteria();
		QueryExecutor queryExecutor = new QueryExecutorImpl();

		if (processingCriteria.isScheduledGenerated(incomingMessage)) {
			// Retrieve QuerySet using querySetId on header
			QuerySet retrievedQuerySet = new QuerySet();

			// execute first query on retrievedQuerySet to mount List of Maps
			List<Map<String, Object>> retrievedListOfMaps = new ArrayList<Map<String, Object>>();

			// After mounted ListOfMaps add to the current´s message payload
			incomingMessage = MessageBuilder.withPayload(retrievedListOfMaps)
					                        .copyHeaders(incomingMessage.getHeaders())
					                        .build();

			//Execute from Query order 2 and so on associated to QuerySet in atomic way
			return queryExecutor.execute(retrievedQuerySet);

		} else {
			List<QuerySet> acceptedQuerySetsList = new ArrayList<QuerySet>();
			List<QuerySet> allQuerySets = retrieveAll();

			for (QuerySet currentQuerySet : allQuerySets) {
				if (currentQuerySet.accept(incomingMessage)) {
					acceptedQuerySetsList.add(currentQuerySet);
				}

			}

			if (acceptedQuerySetsList.size() == 0) {
				return MessageBuilder.withPayload("").setHeader("ERROR", "No QuerySet available fo Event=xxxx and Product=xxxx").build();

			} else if(acceptedQuerySetsList.size() == 1){
				
				//Execute from Query order 1 and so on associated to QuerySet in atomic way
				return queryExecutor.execute(acceptedQuerySetsList.get(0));

			}else {
				//Segundo Mikhail, o serviço deve permitir encontrar mais de um queryset(quando existe mais de um associado os mesmo headers de PRODUCT e EVENT) 
				//e gerar duas mensagens de saídas (pelo menos, no caso de não haver Split).
				return null;
				
			}

		}

	}

	public List<QuerySet> retrieveAll() {
		return new ArrayList<QuerySet>();
	}

	public static void main(String[] args) {
		DBAdapterService das = new DBAdapterServiceImpl();
		das.process(MessageBuilder.withPayload("")
								  .setHeader("SCHEDULED", "SCHEDULE")
								  .setHeader("querySetId", "1").build());

	}

}