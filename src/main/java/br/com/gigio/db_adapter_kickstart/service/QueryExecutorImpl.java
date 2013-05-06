package br.com.gigio.db_adapter_kickstart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.integration.Message;

import br.com.gigio.db_adapter_kickstart.domain.Query;
import br.com.gigio.db_adapter_kickstart.domain.QuerySet;
import br.com.gigio.db_adapter_kickstart.exception.QueryExecutorException;

public class QueryExecutorImpl implements QueryExecutor{
	private static final int MAX_NUMBER_OF_TRIES = 3;
    
    public List<Map<String, Object>> execute(Query query){
    	//Execute query using DAO Layer
    	return new ArrayList<Map<String, Object>>();
    }

	public Message<?> atomicProcessing(Message<?> incomingMessage, List<QuerySet> acceptedQuerySetsList, DBAMessageBuilder dbaMessageBuilder) throws QueryExecutorException {
		List<Map<String,Object>> payloadCopy = (List<Map<String, Object>>) incomingMessage.getPayload();
		List<Map<String,Object>> queryResult = null;
		List<Query> queries = acceptedQuerySetsList.get(0).getQueries();
		
		try {
			for (int i = 0; i < MAX_NUMBER_OF_TRIES; i++) {
				for (Query query : queries) {
					queryResult = this.execute(query);
					
					if (queryResult.size() == 1 && query.getType().equals("Query")) {
						
						if (query.getMultiRowResult() == 'N') {
							//Add List of Map containing only ONE MAP to current Map
							//map.put();
							payloadCopy.get(i).put("key", "value");
							
						}
						
					} 
					
				}
				
			}
			
		} catch (Exception e) {
			throw new QueryExecutorException("Error executing query!");
			
		}
		
		return dbaMessageBuilder.buildMessageWith(payloadCopy);
	}

}
