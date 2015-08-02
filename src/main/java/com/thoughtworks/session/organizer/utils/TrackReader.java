package com.thoughtworks.session.organizer.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.thoughtworks.session.organizer.dto.constants.Track;
import com.thoughtworks.session.organizer.exceptions.GenericException;

/**
 * The Interface TrackReader.
 */
public abstract class TrackReader {

    /**
     * Read track list.
     * 
     * @param inputStream the input stream
     * @return the list
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws GenericException
     */
    public abstract List<Track> readTrackList(final InputStream inputStream) throws IOException, GenericException;

}
