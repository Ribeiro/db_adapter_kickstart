package br.com.gigio.db_adapter_kickstart.service;

import java.util.List;
import java.util.Map;

import org.springframework.integration.Message;

public interface DBAMessageBuilder {

	public abstract Message<?> buildMessageWith(
			List<Map<String, Object>> listOfMaps);

}