package com.avenuecode.converters;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;

import com.avenuecode.models.Route;
import com.avenuecode.models.Routes;

public class GraphPathConverter {
	
	private GraphPathConverter() {
		
	}
	
	public static GraphPathConverter getInstance() {
		return new GraphPathConverter();  
	}
	
	public Routes converter(List<GraphPath<String, DefaultWeightedEdge>> graphPath) {
		Routes routes = new Routes();
		routes.setRoutes(new ArrayList<Route>());
		for (GraphPath<String, DefaultWeightedEdge> graphWalk : graphPath) {
			Route route = new Route();
			String strRoute = graphWalk.getVertexList().toString();
			strRoute = formatarARota(strRoute);
			route.setDistancia(getPeso(graphWalk.getEdgeList()));
			route.setRoute(strRoute);
			route.setStops(graphWalk.getVertexList().size()- 1);
			routes.getRoutes().add(route);
		}
		return routes;
	}
	
	public Routes ordenarRoutes (Routes routes) {
		String rota;
		for (Route route : routes.getRoutes()) {
			rota = route.getRoute();
			char[] charArray = rota.toCharArray();
			Arrays.sort(charArray);
			rota = new String(charArray);
			route.setRoute(rota);
		}
		return routes;
	}
	
	public String formatarARota (String rota) {
		rota = rota.replaceAll(" ", "");
		rota = rota.replaceAll(",", "");
		rota = rota.replaceAll("[\\[\\]]", "");
		return rota ;
	}
	
	private Double getPeso (List<DefaultWeightedEdge> pesos) {
		Double peso = 0d;
		for (DefaultWeightedEdge edge : pesos) {
			Field field;
			try {
				field = DefaultWeightedEdge.class.getSuperclass().getDeclaredField("weight");
				field.setAccessible(true);
				Double weight = field.getDouble(edge);
				peso = peso + weight ;
			} catch (Exception e) {
				return 0d;
			} 
		}
		return peso;
		
	}
	
	
	
}
