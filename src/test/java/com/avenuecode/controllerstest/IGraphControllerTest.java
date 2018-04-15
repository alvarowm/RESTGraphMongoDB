package com.avenuecode.controllerstest;

public interface IGraphControllerTest {
	
	static final String LOCALHOST_8080_GRAPH = "http://localhost:8080/graph";
	static final String LOCALHOST_8080_ROUTES_CC_3 = "http://localhost:8080/routes/from/C/to/C?maxStops=3";
	static final String LOCALHOST_8080_ROUTES_AC_4 = "http://localhost:8080/routes/from/A/to/C?maxStops=4";
	static final String LOCALHOST_8080_DISTANCE = "http://localhost:8080/distance";
	static final String LOCALHOST_8080_DISTANCE_A_TO_C =   "http://localhost:8080/distance/from/A/to/C";
	static final String LOCALHOST_8080_DISTANCE_B_TO_B =   "http://localhost:8080/distance/from/B/to/B";
	static final String JSON_GET_ID = "{\r\n" + 
			"  \"data\":[\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"A\", \"target\": \"B\", \"distance\":6\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"A\", \"target\": \"E\", \"distance\":4\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"B\", \"target\": \"A\", \"distance\":6\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"B\", \"target\": \"C\", \"distance\":2\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"B\", \"target\": \"D\", \"distance\":4\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"C\", \"target\": \"B\", \"distance\":3\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"C\", \"target\": \"D\", \"distance\":1\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"C\", \"target\": \"E\", \"distance\":7\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"B\", \"target\": \"D\", \"distance\":8\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"E\",  \"target\": \"B\", \"distance\":5\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"E\", \"target\": \"D\", \"distance\":7\r\n" + 
			"    }\r\n" + 
			"  ]\r\n" + 
			"}\r\n" + 
			"";
	
	static final String APPLICATION_JSON = "application/json";
	
	static final String DISTANCE_ABC = "{\r\n" + 
			"  \"path\":[\"A\", \"B\", \"C\"],\r\n" + 
			"  \"data\":[\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"A\", \"target\": \"B\", \"distance\":5\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"B\", \"target\": \"C\", \"distance\":4\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"C\", \"target\": \"D\", \"distance\":8\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"D\", \"target\": \"C\", \"distance\":8\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"D\", \"target\": \"E\", \"distance\":6\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"A\", \"target\": \"D\", \"distance\":5\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"C\", \"target\": \"E\", \"distance\":2\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"E\", \"target\": \"B\", \"distance\":3\r\n" + 
			"    },\r\n" + 
			"    { \r\n" + 
			"      \"source\": \"A\", \"target\": \"E\", \"distance\":7\r\n" + 
			"    }\r\n" + 
			"  ]\r\n" + 
			"}";

		String DISTANCE_9 = "{\r\n" + 
				"  \"distance\" : 9\r\n" + 
				"}";
		
		String DISTANCE_5 = "{\r\n" + 
				"  \"distance\" : 5\r\n" + 
				"}";
		
		String DATA = "{\r\n" + 
				"  \"path\":[\"A\", \"D\"],\r\n" + 
				"  \"data\":[\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"A\", \"target\": \"B\", \"distance\":5\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"B\", \"target\": \"C\", \"distance\":4\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"C\", \"target\": \"D\", \"distance\":8\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"D\", \"target\": \"C\", \"distance\":8\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"D\", \"target\": \"E\", \"distance\":6\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"A\", \"target\": \"D\", \"distance\":5\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"C\", \"target\": \"E\", \"distance\":2\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"E\", \"target\": \"B\", \"distance\":3\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"A\", \"target\": \"E\", \"distance\":7\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}\r\n" + 
				"";
		
		String DISTANCE_ADC = "{\r\n" + 
				"  \"path\":[\"A\", \"D\", \"C\"],\r\n" + 
				"  \"data\":[\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"A\", \"target\": \"B\", \"distance\":5\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"B\", \"target\": \"C\", \"distance\":4\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"C\", \"target\": \"D\", \"distance\":8\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"D\", \"target\": \"C\", \"distance\":8\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"D\", \"target\": \"E\", \"distance\":6\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"A\", \"target\": \"D\", \"distance\":5\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"C\", \"target\": \"E\", \"distance\":2\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"E\", \"target\": \"B\", \"distance\":3\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"A\", \"target\": \"E\", \"distance\":7\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}\r\n" + 
				"";
		
		String DISTANCE_AEBCD = "{\r\n" + 
				"  \"path\":[\"A\", \"E\", \"D\", \"C\", \"D\"],\r\n" + 
				"  \"data\":[\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"A\", \"target\": \"B\", \"distance\":5\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"B\", \"target\": \"C\", \"distance\":4\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"C\", \"target\": \"D\", \"distance\":8\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"D\", \"target\": \"C\", \"distance\":8\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"D\", \"target\": \"E\", \"distance\":6\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"A\", \"target\": \"D\", \"distance\":5\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"C\", \"target\": \"E\", \"distance\":2\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"E\", \"target\": \"B\", \"distance\":3\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"A\", \"target\": \"E\", \"distance\":7\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}\r\n" + 
				"";
		
		
		String DISTANCE_AED = "{\r\n" + 
				"  \"path\":[\"A\", \"E\", \"D\"],\r\n" + 
				"  \"data\":[\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"A\", \"target\": \"B\", \"distance\":5\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"B\", \"target\": \"C\", \"distance\":4\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"C\", \"target\": \"D\", \"distance\":8\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"D\", \"target\": \"C\", \"distance\":8\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"D\", \"target\": \"E\", \"distance\":6\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"A\", \"target\": \"D\", \"distance\":5\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"C\", \"target\": \"E\", \"distance\":2\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"E\", \"target\": \"B\", \"distance\":3\r\n" + 
				"    },\r\n" + 
				"    { \r\n" + 
				"      \"source\": \"A\", \"target\": \"E\", \"distance\":7\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}\r\n" + 
				"";
		
		String DISTANCE_M_1 = "{\r\n" + 
				"  \"distance\" : -1\r\n" + 
				"}";
		
		String DISTANCE_BB_0 = "{\r\n" + 
				"  \"distance\" : 0,\r\n" + 
				"  \"path\" : [ \"B\" ]\r\n" + 
				"}";
		
		String ROUTES_CC_3 = "{\r\n" + 
				"  \"routes\" : [ {\r\n" + 
				"    \"route\" : \"C\",\r\n" + 
				"    \"stops\" : 0,\r\n" + 
				"    \"distancia\" : 0.0\r\n" + 
				"  }, {\r\n" + 
				"    \"route\" : \"CBC\",\r\n" + 
				"    \"stops\" : 2,\r\n" + 
				"    \"distancia\" : 5.0\r\n" + 
				"  }, {\r\n" + 
				"    \"route\" : \"CEBC\",\r\n" + 
				"    \"stops\" : 3,\r\n" + 
				"    \"distancia\" : 14.0\r\n" + 
				"  } ]\r\n" + 
				"}";
		
		String ROUTES_AC_4 = "{\r\n" + 
				"  \"routes\" : [ {\r\n" + 
				"    \"route\" : \"ABC\",\r\n" + 
				"    \"stops\" : 2,\r\n" + 
				"    \"distancia\" : 8.0\r\n" + 
				"  }, {\r\n" + 
				"    \"route\" : \"ABCBC\",\r\n" + 
				"    \"stops\" : 4,\r\n" + 
				"    \"distancia\" : 13.0\r\n" + 
				"  }, {\r\n" + 
				"    \"route\" : \"ABABC\",\r\n" + 
				"    \"stops\" : 4,\r\n" + 
				"    \"distancia\" : 20.0\r\n" + 
				"  }, {\r\n" + 
				"    \"route\" : \"AEBC\",\r\n" + 
				"    \"stops\" : 3,\r\n" + 
				"    \"distancia\" : 11.0\r\n" + 
				"  } ]\r\n" + 
				"}";
		
		String DISTANCE_ABC_9 = "{\r\n" + 
				"  \"distance\" : 9,\r\n" + 
				"  \"path\" : [ \"A\", \"B\", \"C\" ]\r\n" + 
				"}";
}
