package com.avenuecode.graphhelper;

import java.util.Arrays;
import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.WeightedGraph;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import com.avenuecode.converters.GraphPathConverter;
import com.avenuecode.models.Data;
import com.avenuecode.models.PathGraph;
import com.avenuecode.models.Route;
import com.avenuecode.models.Routes;
import com.avenuecode.models.TownsGraph;

@SuppressWarnings("deprecation")
public class GraphHelper {

	WeightedGraph<String, DefaultWeightedEdge> g;

	public GraphHelper(TownsGraph townsGraph) {

		g = new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

		for (Data d : townsGraph.getData()) {
			g.addVertex(d.getSource());
			g.addVertex(d.getTarget());
			g.addEdge(d.getSource(), d.getTarget(), g.getEdgeFactory().createEdge(d.getSource(), d.getTarget()));
			DefaultWeightedEdge edge = g.getEdge(d.getSource(), d.getTarget());
			g.setEdgeWeight(edge, d.getDistance());
		}
	}

	public List<GraphPath<String, DefaultWeightedEdge>> getAllPaths(String source, String target, Integer maxSteps){
		AllDirectedPaths<String, DefaultWeightedEdge> paths = new AllDirectedPaths<>(g);
		try {
			List<GraphPath<String, DefaultWeightedEdge>> listPaths = paths.getAllPaths(source, target, false, maxSteps); 
			return listPaths;

		} catch (Exception e) {
			return null;
		}
	}

	public GraphPath<String, DefaultWeightedEdge> findDijkstraShortestPath (String source, String target) {
		DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(g);
		try {
			return dijkstraShortestPath.getPath(source, target);
		} catch (Exception e) {
			return null;
		}
		
	}

	public Route getPathIgual(PathGraph pathGraph) {
		AllDirectedPaths<String, DefaultWeightedEdge> paths = new AllDirectedPaths<>(g);
		try {
			List<GraphPath<String, DefaultWeightedEdge>> listPaths = paths.getAllPaths(pathGraph.getPath().get(0)
					, pathGraph.getPath().get(pathGraph.getPath().size()-1), true, pathGraph.getPath().size()); 

			Routes routes = GraphPathConverter.getInstance().ordenarRoutes(GraphPathConverter.getInstance().converter(listPaths));
			
			if (routes == null || routes.getRoutes() == null || routes.getRoutes().isEmpty())
				return null;

			String path = Arrays.toString(pathGraph.getPath().toArray());
			path = GraphPathConverter.getInstance().formatarARota(path);
			
			for (Route route : routes.getRoutes()) {
				if (route.getRoute().trim().equals(path.trim()))
					return route;
			}

			return null;

		} catch (Exception e) {
			return null;
		}
	}

}
