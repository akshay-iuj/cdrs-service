package com.cdrs.api.controllers;

import com.alogrithm.Graph;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/graphProblem")
public class GraphController {
    @GetMapping("/getMinDistance")
    public ResponseEntity<?> getMinDistance(@Valid @RequestParam char start, @RequestParam char end)  {

        return ResponseEntity.ok(Graph.getMinDistance(start, end));
    }
}

