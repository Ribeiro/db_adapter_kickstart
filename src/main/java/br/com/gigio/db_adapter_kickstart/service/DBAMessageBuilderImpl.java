package br.com.gigio.db_adapter_kickstart.service;

import java.util.List;
import java.util.Map;

import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;

public class DBAMessageBuilderImpl implements DBAMessageBuilder {
	
	/* (non-Javadoc)
	 * @see br.com.gigio.db_adapter_kickstart.service.DBAMessageBuilder#buildMessageWith(java.util.List)
	 */
	public Message<?> buildMessageWith(List<Map<String, Object>> listOfMaps){
		return MessageBuilder.withPayload(listOfMaps).build();
	}

}
