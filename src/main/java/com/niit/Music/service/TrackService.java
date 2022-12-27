package com.niit.Music.service;

import com.niit.Music.domain.Track;

import java.util.List;

public interface TrackService {

    public Track addTrack(Track track);

    public List<Track> getAll();

    public String deleteTrack(Integer trackId);

    public Track updateTrack(Track track);

}
