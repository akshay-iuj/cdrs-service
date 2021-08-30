package com.cdrs.api.controllers;

import com.alogrithm.Edge;
import com.alogrithm.Graph;
import com.alogrithm.PathAlgorithm;
import com.alogrithm.Vertex;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/graphProblem")
public class GraphController {
    private List<Vertex> nodes;
    private List<Edge> edges;


    @GetMapping("/getMinDistance")
    public ResponseEntity<?> getMinDistance(@Valid @RequestParam char start, @RequestParam char end)  {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();

        nodes.add(new Vertex('A'));
        nodes.add(new Vertex('B'));
        nodes.add(new Vertex('C'));
        nodes.add(new Vertex('D'));
        nodes.add(new Vertex('E'));
        nodes.add(new Vertex('F'));

        addLane('A', 'B', 2);
        addLane('A', 'D', 1);
        addLane('A', 'C', 5);
        addLane( 'B', 'C', 3);
        addLane( 'B', 'D', 2);
        addLane( 'C', 'D', 3);
        addLane( 'C', 'E', 1);
        addLane( 'C', 'F', 5);
        addLane( 'C', 'A', 5);
        addLane( 'C', 'B', 3);
        addLane( 'D', 'A', 1);
        addLane( 'D', 'B', 2);
        addLane( 'D', 'C', 3);
        addLane( 'D', 'E', 1);
        addLane( 'E', 'D', 1);
        addLane( 'E', 'C', 1);
        addLane( 'E', 'F', 2);
        addLane( 'F', 'C', 5);
        addLane( 'F', 'E', 2);

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        PathAlgorithm algo = new PathAlgorithm(graph);
        algo.execute(nodes.get(start-'A'));
        LinkedList<Vertex> path = algo.getPath(nodes.get(end-'A'));
        return ResponseEntity.ok(path);
    }

    private void addLane( char sourceLocNo, char destLocNo,
                         int duration) {
        Edge lane = new Edge(nodes.get(sourceLocNo-'A'), nodes.get(destLocNo-'A'), duration );
        edges.add(lane);
    }
}

