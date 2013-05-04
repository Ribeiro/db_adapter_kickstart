package br.com.gigio.db_adapter_kickstart.service;

import org.springframework.integration.Message;

import br.com.gigio.db_adapter_kickstart.domain.QuerySet;

public interface QueryExecutor {
	Message<?> execute(final QuerySet querySet);

}
