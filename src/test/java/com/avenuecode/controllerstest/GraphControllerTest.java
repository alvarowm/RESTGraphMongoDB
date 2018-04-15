package com.avenuecode.controllerstest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class GraphControllerTest implements IGraphControllerTest{

	@Test
	public void testGetByIdOK() {
		HttpPost request  = new HttpPost(LOCALHOST_8080_GRAPH);
		StringEntity params;
		try {
			params = new StringEntity(JSON_GET_ID);

			request.addHeader("content-type", APPLICATION_JSON);
			request.setEntity(params);

			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			assertEquals(httpResponse.getStatusLine().getStatusCode(), 201);
		} catch (Exception e) {
			assertFalse(true);
		} 
	}

	@Test
	public void testDistanciaofRouteABC() {
		HttpPost request  = new HttpPost(LOCALHOST_8080_DISTANCE);
		StringEntity params;
		try {
			params = new StringEntity(DISTANCE_ABC);

			request.addHeader("content-type", APPLICATION_JSON);
			request.setEntity(params);

			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			String json = EntityUtils.toString(httpResponse.getEntity());
			assertEquals(json.trim(), DISTANCE_9.trim());
		} catch (Exception e) {
			assertFalse(true);
		} 
	}
	
	@Test
	public void testDistanciaofRouteAD() {
		HttpPost request  = new HttpPost(LOCALHOST_8080_DISTANCE);
		StringEntity params;
		try {
			params = new StringEntity(DATA);

			request.addHeader("content-type", APPLICATION_JSON);
			request.setEntity(params);

			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			String json = EntityUtils.toString(httpResponse.getEntity());
			assertEquals(json.trim(), DISTANCE_5.trim());
		} catch (Exception e) {
			assertFalse(true);
		} 
	}
	
	@Test
	public void testDistanciaofRouteADC() {
		HttpPost request  = new HttpPost(LOCALHOST_8080_DISTANCE);
		StringEntity params;
		try {
			params = new StringEntity(DISTANCE_ADC);

			request.addHeader("content-type", APPLICATION_JSON);
			request.setEntity(params);

			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			String json = EntityUtils.toString(httpResponse.getEntity());
			assertEquals(json.trim(), DISTANCE_M_1.trim());
		} catch (Exception e) {
			assertFalse(true);
		} 
	}
	
	@Test
	public void testDistanciaofRouteAEBCD() {
		HttpPost request  = new HttpPost(LOCALHOST_8080_DISTANCE);
		StringEntity params;
		try {
			params = new StringEntity(DISTANCE_AEBCD);

			request.addHeader("content-type", APPLICATION_JSON);
			request.setEntity(params);

			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			String json = EntityUtils.toString(httpResponse.getEntity());
			assertEquals(json.trim(), DISTANCE_M_1.trim());
		} catch (Exception e) {
			assertFalse(true);
		} 
	}
	
	@Test
	public void testDistanciaofRouteAED() {
		HttpPost request  = new HttpPost(LOCALHOST_8080_DISTANCE);
		StringEntity params;
		try {
			params = new StringEntity(DISTANCE_AED);

			request.addHeader("content-type", APPLICATION_JSON);
			request.setEntity(params);

			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			String json = EntityUtils.toString(httpResponse.getEntity());
			assertEquals(json.trim(), DISTANCE_M_1.trim());
		} catch (Exception e) {
			assertFalse(true);
		} 
	}
	
	@Test
	public void testRoutesCC3() {
		HttpPost request  = new HttpPost(LOCALHOST_8080_ROUTES_CC_3);
		StringEntity params;
		try {
			params = new StringEntity(JSON_GET_ID);

			request.addHeader("content-type", APPLICATION_JSON);
			request.setEntity(params);

			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			String json = EntityUtils.toString(httpResponse.getEntity());
			assertEquals(json.trim(), ROUTES_CC_3.trim());
		} catch (Exception e) {
			assertFalse(true);
		} 
	}
	
	@Test
	public void testRoutesAC4() {
		HttpPost request  = new HttpPost(LOCALHOST_8080_ROUTES_AC_4);
		StringEntity params;
		try {
			params = new StringEntity(JSON_GET_ID);

			request.addHeader("content-type", APPLICATION_JSON);
			request.setEntity(params);

			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			String json = EntityUtils.toString(httpResponse.getEntity());
			assertEquals(json.trim(), ROUTES_AC_4.trim());
		} catch (Exception e) {
			assertFalse(true);
		} 
	}
	
	@Test
	public void testDistanciaofRouteAC() {
		HttpPost request  = new HttpPost(LOCALHOST_8080_DISTANCE_A_TO_C);
		StringEntity params;
		try {
			params = new StringEntity(DATA);

			request.addHeader("content-type", APPLICATION_JSON);
			request.setEntity(params);

			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			String json = EntityUtils.toString(httpResponse.getEntity());
			assertEquals(json.trim(), DISTANCE_ABC_9.trim());
		} catch (Exception e) {
			assertFalse(true);
		} 
	}
	
	@Test
	public void testDistanciaofRouteBB() {
		HttpPost request  = new HttpPost(LOCALHOST_8080_DISTANCE_B_TO_B);
		StringEntity params;
		try {
			params = new StringEntity(DATA);

			request.addHeader("content-type", APPLICATION_JSON);
			request.setEntity(params);

			HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
			String json = EntityUtils.toString(httpResponse.getEntity());
			assertEquals(json.trim(), DISTANCE_BB_0.trim());
		} catch (Exception e) {
			assertFalse(true);
		} 
	}
	
	
	
}


