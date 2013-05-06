package br.com.gigio.db_adapter_kickstart.service;

import java.util.Map;

public interface QueryParser {

	public String parse(String sqlQuery, Map<String, Object> map);

}