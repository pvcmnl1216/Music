/*
 * Author Name: Philip Meshach
 * Date: 27-12-2022
 * Praise The Lord
 */
package com.niit.Music.service;

import com.niit.Music.domain.Track;
import com.niit.Music.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    @Autowired
    TrackRepository trackRepository;

    @Override
    public Track addTrack(Track track) {
        if (trackRepository.findById(track.getTrackId()).isEmpty()) {
            return trackRepository.save(track);
        }
        return null;
    }

    @Override
    public List<Track> getAll() {
        return trackRepository.findAll();
    }

    @Override
    public String deleteTrack(Integer trackId) {
        if (trackRepository.findById(trackId).isEmpty()) {
            return "Track does not exist";
        }
        trackRepository.deleteById(trackId);
        return "Track delete successfully";
    }

    @Override
    public Track updateTrack(Track track) {
        if(trackRepository.findById(track.getTrackId()).isEmpty()){
            return null;
        }
       Track track1 = trackRepository.findById(track.getTrackId()).get();
        track1.setTrackArtist(track.getTrackArtist());
        track1.setTrackName(track.getTrackName());
        track1.setTrackRating(track.getTrackRating());
        track1.setTrackComments(track.getTrackComments());
        return trackRepository.save(track1);
    }
}
