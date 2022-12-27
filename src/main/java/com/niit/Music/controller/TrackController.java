/*
 * Author Name: Philip Meshach
 * Date: 27-12-2022
 * Praise The Lord
 */
package com.niit.Music.controller;

import com.niit.Music.domain.Track;
import com.niit.Music.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    @Autowired
    TrackService trackService;
    @PostMapping("/Track")
    public ResponseEntity<?> addTracks(@RequestBody Track track){
        return new ResponseEntity<>(trackService.addTrack(track), HttpStatus.OK);
    }
    @GetMapping("/Track")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<>(trackService.getAll(),HttpStatus.OK);
    }
    @DeleteMapping("/Track/{trackId}")
    public ResponseEntity<?> deleteTracks(@PathVariable Integer trackId){
        return new ResponseEntity<>(trackService.deleteTrack(trackId),HttpStatus.OK);
    }
    @PutMapping("/Track")
    public ResponseEntity<?> updateTracks(@RequestBody Track track){
        return new ResponseEntity<>(trackService.updateTrack(track),HttpStatus.OK);
    }
}

