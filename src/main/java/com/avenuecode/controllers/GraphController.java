package com.avenuecode.controllers;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avenuecode.models.Distance;
import com.avenuecode.models.DistanceWithPath;
import com.avenuecode.models.Path;
import com.avenuecode.models.PathGraph;
import com.avenuecode.models.Routes;
import com.avenuecode.models.TownsGraph;
import com.avenuecode.repositories.TownsGraphRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class GraphController {

	@Autowired
	private TownsGraphRepositoryImpl repository;
	@Autowired
	ObjectMapper mapper;

	@PostMapping("/graph")
	public ResponseEntity<String> saveGraphConfiguration(@RequestBody TownsGraph townsGraph){
		repository.saveGraphConfiguration(townsGraph);
		String result = null;
		try {
			result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(townsGraph);
		} catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

	@RequestMapping("/graph/{id}")
	public ResponseEntity<String> retrieveGraphConfiguration(@PathVariable("id") BigInteger id){
		TownsGraph retrieved = repository.retrieveGraphConfiguration(id);
		if (retrieved == null)
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
		String result = null;
		try {
			result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(retrieved);
		} catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@PostMapping("/routes/from/{town1}/to/{town2}")
	public ResponseEntity<String> findAvailableRoutesFromAGivenPairOfTowns(@RequestBody TownsGraph townsGraph,
			@PathVariable("town1") String source, 
			@PathVariable("town2") String target, 
			@RequestParam("maxStops") String stops){

		Routes routes = repository.findAvailableRoutesFromAGivenPairOfTowns(source, target, Integer.parseInt(stops), townsGraph);

		try {
			String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(routes);
			return new ResponseEntity<String>(result, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/routes/{id}/from/{town1}/to/{town2}")
	public ResponseEntity<String> findAvailableRoutesFromAGivenPairOfTownsOnSavedGraph(@RequestBody TownsGraph townsGraph,
			@PathVariable("town1") String source, 
			@PathVariable("town2") String target, 
			@RequestParam("maxStops") String stops, 
			@PathVariable("id") BigInteger id){

		TownsGraph retrieved = repository.retrieveGraphConfiguration(id);
		if (retrieved == null)
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);

		Routes routes = repository.findAvailableRoutesFromAGivenPairOfTowns(source, target, Integer.parseInt(stops), townsGraph);

		try {
				String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(routes);
				return new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/distance")
	public ResponseEntity<String> findDistanceForPath(@RequestBody PathGraph pathGraph){
		Distance distance= repository.findDistanceForPath(pathGraph, pathGraph.getPath());
		String result;
		try {
			result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(distance);
		} catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@PostMapping("/distance/{id}")
	public ResponseEntity<String> findDistanceForPathOnSavedGraph( @PathVariable("id") BigInteger id, 
			@RequestBody Path path){

		TownsGraph retrieved = repository.retrieveGraphConfiguration(id);

		if (retrieved == null)
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);

		Distance distance= repository.findDistanceForPath(retrieved,path);
		String result;
		try {
			result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(distance);
		} catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@PostMapping("/distance/from/{town1}/to/{town2}")
	public ResponseEntity<String> findDistanceBetwaeenTwoTowns(@RequestBody TownsGraph townsGraph,
			@PathVariable("town1") String source, 
			@PathVariable("town2") String target) {

		DistanceWithPath distancePath = repository.findDistanceBetwaeenTwoTowns(source, target, townsGraph);
		String result;
		try {
			result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(distancePath);
		} catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@PostMapping("/distance/{id}/from/{town1}/to/{town2}")
	public ResponseEntity<String> findDistanceBetwaeenTwoTownsSavedGraph(@RequestBody TownsGraph townsGraph,
			@PathVariable("town1") String source, 
			@PathVariable("town2") String target, 
			@PathVariable("id") BigInteger id) {

		TownsGraph retrieved = repository.retrieveGraphConfiguration(id);
		if (retrieved == null)
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);

		DistanceWithPath distancePath = repository.findDistanceBetwaeenTwoTowns(source, target, townsGraph);
		String result;
		try {
			result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(distancePath);
		} catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
