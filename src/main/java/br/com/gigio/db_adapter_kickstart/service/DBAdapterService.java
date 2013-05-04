package br.com.gigio.db_adapter_kickstart.service;

import java.util.List;

import org.springframework.integration.Message;

import br.com.gigio.db_adapter_kickstart.domain.QuerySet;

public interface DBAdapterService {
	
	Message<?> process (Message<?> message);
	List<QuerySet> retrieveAll();

}
