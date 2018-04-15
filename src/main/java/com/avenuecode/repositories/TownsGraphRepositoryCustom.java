package com.avenuecode.repositories;

import java.math.BigInteger;
import java.util.List;

import com.avenuecode.models.Distance;
import com.avenuecode.models.DistanceWithPath;
import com.avenuecode.models.Path;
import com.avenuecode.models.PathGraph;
import com.avenuecode.models.Routes;
import com.avenuecode.models.TownsGraph;

public interface TownsGraphRepositoryCustom {
	
	public TownsGraph saveGraphConfiguration(TownsGraph townsGraph);
	public TownsGraph retrieveGraphConfiguration(BigInteger id);
	public Routes findAvailableRoutesFromAGivenPairOfTowns(String town1, String town2,Integer stops, TownsGraph townsGraph);
	public Distance findDistanceForPath (TownsGraph retrieved, Path path);
	public DistanceWithPath findDistanceBetwaeenTwoTowns (String town1, String town2, TownsGraph graph);
	public Distance findDistanceForPath(PathGraph pathGraph, List<String> path);

}
