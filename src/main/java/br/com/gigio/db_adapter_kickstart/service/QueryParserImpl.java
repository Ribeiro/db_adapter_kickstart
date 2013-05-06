package br.com.gigio.db_adapter_kickstart.service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryParserImpl implements QueryParser {
	
	private static final String QUERY_ARGUMENT_REGEX = "#\\{[\\w]+}";
	private static final int REGEX_DEFAULT_START_POSITION = 2; 
	private static final String REGEX_CLOSING_BRACKET = "}";
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.ib.bil.template.util.QueryParse#parse(java.lang.String, java.util.Map)
	 */
	public String parse(String sqlQuery, Map<String, Object> map){
		Pattern regexPattern = Pattern.compile(QUERY_ARGUMENT_REGEX);
		StringBuffer stringBuffer = new StringBuffer();
		Matcher matcher = regexPattern.matcher(sqlQuery);
			
		while (matcher.find()) {
		    findAndReplacePatternMatch(map, stringBuffer, matcher);

		}
			
		matcher.appendTail(stringBuffer);
		return stringBuffer.toString();
			
	}

	private void findAndReplacePatternMatch(Map<String, Object> map, StringBuffer stringBuffer, Matcher matcher) {
		String replacement = matcher.group().substring(REGEX_DEFAULT_START_POSITION, matcher.group().indexOf(REGEX_CLOSING_BRACKET));
		if (map.get(replacement) != null) {
			matcher.appendReplacement(stringBuffer, map.get(replacement).toString() );
		}
	}

}