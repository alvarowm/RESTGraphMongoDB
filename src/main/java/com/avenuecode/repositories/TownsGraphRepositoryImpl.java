package com.avenuecode.repositories;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;

import com.avenuecode.converters.GraphPathConverter;
import com.avenuecode.graphhelper.GraphHelper;
import com.avenuecode.models.Distance;
import com.avenuecode.models.DistanceWithPath;
import com.avenuecode.models.Path;
import com.avenuecode.models.PathGraph;
import com.avenuecode.models.Route;
import com.avenuecode.models.Routes;
import com.avenuecode.models.TownsGraph;

public class TownsGraphRepositoryImpl implements TownsGraphRepositoryCustom {
	
	@Autowired
    MongoTemplate mongoTemplate;

	@Override
	public TownsGraph saveGraphConfiguration(TownsGraph townsGraph) {
		mongoTemplate.save(townsGraph);
		return townsGraph;
	}

	@Override
	@Query("{graph:'?0'}")
	public TownsGraph retrieveGraphConfiguration(BigInteger id) {
		TownsGraph retrieved = mongoTemplate.findById(id, TownsGraph.class);
		return retrieved;
	}

	@Override
	public Routes findAvailableRoutesFromAGivenPairOfTowns(String source, String target, Integer stops, TownsGraph townsGraph) {
		GraphHelper helper = new GraphHelper(townsGraph);
		List<GraphPath<String, DefaultWeightedEdge>> graphPath = helper.getAllPaths(source, target, stops);
		Routes routes = new Routes();
		
		if (graphPath == null) {
			routes.setRoutes(new ArrayList<Route>());
			return routes;
		}
		
		routes = GraphPathConverter.getInstance().converter(graphPath);
		return routes;
	}
	
	public Distance findDistanceForPath(PathGraph pathGraph, List<String> path) {
		Distance distance = new Distance();
		
		if (pathGraph == null) {
			distance.setDistance(-1);
			return distance; 
		}
		
		if (pathGraph.getPath().size() <=1) { 
			distance.setDistance(0);
		}
		
		TownsGraph townsGraph = new TownsGraph();
		townsGraph.setData(pathGraph.getData());
		GraphHelper helper = new GraphHelper(townsGraph);
		Route route = helper.getPathIgual(pathGraph);
		
		if (route == null) {
			distance.setDistance(-1);
			return distance; 
		}
		
		distance.setDistance(route.getDistancia().intValue());
			
		return distance;
	}

	@Override
	public Distance findDistanceForPath(TownsGraph retrieved, Path path) {
		PathGraph pathGraph = new PathGraph();
		pathGraph.setData(retrieved.getData());
		pathGraph.setPath(path.getPath());
		
		return findDistanceForPath(pathGraph, path.getPath());
	}

	@Override
	public DistanceWithPath findDistanceBetwaeenTwoTowns(String source, String target, TownsGraph townsGraph) {
		DistanceWithPath distancePath = new  DistanceWithPath();
		
		if (source.equals(target)) {
			distancePath.setDistance(0);
			List<String> path = new ArrayList<String>();
			path.add(source);
			path.add(target);
			distancePath.setPath(path);
		}
		
		GraphHelper helper = new GraphHelper(townsGraph);
		GraphPath<String, DefaultWeightedEdge> graphPath = helper.findDijkstraShortestPath(source, target);
		
		if (graphPath == null) {
			distancePath.setDistance(-1);
			List<String> path = new ArrayList<String>();
			path.add(source);
			path.add(target);
			distancePath.setPath(path);
			return distancePath;
		}
		
		distancePath.setDistance(new Double(graphPath.getWeight()).intValue());
		distancePath.setPath(graphPath.getVertexList());
		
		return distancePath;
	}

	

}
