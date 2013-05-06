package br.com.gigio.db_adapter_kickstart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:/main-test.xml" })
public class QueryParserTest {
	
	@Autowired
    private QueryParser queryParser;
	private String queryWithOneArgument;
	private String queryWithMoreThanOneArgument;
	private String queryWithoutMapKeyValuePairMatching;
	private String queryWithMapKeyValuePairPartialMatching;
	private List<Map<String, Object>> payload;
	private static final int DEFAULT_PAYLOAD_LIST_SIZE = 3;
	
	@Before
	public void setUp(){
		queryWithOneArgument = "select client_account from ACCOUNTS where client_cpf = #{cpf}";
		queryWithMoreThanOneArgument = "select client_account from ACCOUNTS where client_cpf = #{cpf} and client_name = #{name} and credit_account = #{credit_account} and date = #{date}";
		queryWithoutMapKeyValuePairMatching = "select client_account from ACCOUNTS where client_address = #{address}";
		queryWithMapKeyValuePairPartialMatching = "select client_account from ACCOUNTS where client_address = #{address} and client_cpf = #{cpf}";
		addMapsToPayload();
		populatePayloadMaps();
		
	}

	private void populatePayloadMaps() {
		payload.get(0).put("cpf", "'123.456.789-00'");
		payload.get(0).put("value", "12555.00");
		payload.get(0).put("date", "'2013-05-02'");
		payload.get(0).put("credit_account", "'112233-4'");
		payload.get(0).put("name", "'Geovanny Ribeiro'");
		
		payload.get(1).put("cpf", "'753.951.852-00'");
		payload.get(1).put("value", "10555.00");
		payload.get(1).put("date", "'2013-05-02'");
		payload.get(1).put("credit_account", "'334455-6'");
		payload.get(1).put("name", "'Valterfi Oliveira'");
		
		payload.get(2).put("cpf", "'789.456.321-00'");
		payload.get(2).put("value", "11555.00");
		payload.get(2).put("date", "'2013-05-02'");
		payload.get(2).put("credit_account", "'223344-5'");
		payload.get(2).put("name", "'Claudemirton Macedo'");
	}

	private void addMapsToPayload() {
		payload = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < DEFAULT_PAYLOAD_LIST_SIZE; i++) {
			payload.add(new HashMap<String, Object>());
			
		}
	}
	
	@Test
	public void shouldSuccessfullyParseQueryWithOneArgumentMatchingMapKeyValuePair(){
		String expectedResult = "select client_account from ACCOUNTS where client_cpf = '123.456.789-00'";
		Map<String, Object> currentMapForTesting = payload.get(0); 
		assertThat(queryParser.parse(queryWithOneArgument, currentMapForTesting), equalTo(expectedResult));
		
	}
	
	@Test
	public void shouldSuccessfullyParseQueryWithMoreThanOneArgumentMatchingMapKeyValuePair(){
		String expectedResult = "select client_account from ACCOUNTS where client_cpf = '753.951.852-00' and client_name = 'Valterfi Oliveira' and credit_account = '334455-6' and date = '2013-05-02'";
		Map<String, Object> currentMapForTesting = payload.get(1);
		assertThat(queryParser.parse(queryWithMoreThanOneArgument, currentMapForTesting), equalTo(expectedResult));
		
	}
	
	@Test
	public void shouldNotParseQueryWithAnyArgumentMatchingMapKeyValuePair(){
		String expectedResult = queryWithoutMapKeyValuePairMatching;
		Map<String, Object> currentMapForTesting = payload.get(2);
		assertThat(queryParser.parse(queryWithoutMapKeyValuePairMatching, currentMapForTesting), equalTo(expectedResult));
		
	}
	
	@Test
	public void shouldPartiallyParseQueryWithMapKeyValuePairPartialArgumentMatching(){
		String expectedResult = "select client_account from ACCOUNTS where client_address = #{address} and client_cpf = '789.456.321-00'";
		Map<String, Object> currentMapForTesting = payload.get(2);
		assertThat(queryParser.parse(queryWithMapKeyValuePairPartialMatching, currentMapForTesting), equalTo(expectedResult));
		
	}

}