package com.thoughtworks.session.organizer.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.session.organizer.dto.constants.Track;
import com.thoughtworks.session.organizer.exceptions.GenericException;

/**
 * The Class TrackReaderImpl.
 */
public class TrackReaderImpl extends TrackReader {

    /** The Constant REGEX_EXP. */
    private static final String REGEX_EXP = ",";

    /** The Constant TIME_SUFFIX. */
    private static final String TIME_SUFFIX = "min";

    /** The Constant LIGHTNING. */
    private static final String LIGHTNING = "lightning";

    /** The Constant BLANK. */
    private static final String BLANK = "";

    /*
     * (non-Javadoc)
     * 
     * @see com.thoughtworks.session.organizer.utils.TrackReader#readTrackList(java.io.InputStream)
     */
    @Override
    public List<Track> readTrackList(final InputStream inputStream) throws IOException, GenericException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = null;
        List<Track> tracks = null;
        while ((line = bufferedReader.readLine()) != null) {
            final String[] tokens = line.split(REGEX_EXP);
            final int numberOfTokens = tokens.length;

            if (numberOfTokens < 2) {
                throw new GenericException("Error occurred while reading track list from file stream , Error - 'Invalid file Content'");
            }

            if (tracks == null) {
                tracks = new ArrayList<Track>();
            }

            final Track track = new Track();
            for (int counter = 0; counter < tokens.length; counter++) {
                String token = tokens[counter];
                if (token != null && !token.equals(BLANK)) {
                    if (counter == 0) {
                        track.setDescription(token);
                    } else if (LIGHTNING.equals(token)) {
                        track.setDuration(Integer.valueOf(5));
                    } else {
                        token = token.replaceAll(TIME_SUFFIX, "");
                        track.setDuration(Integer.valueOf(token));
                    }
                }
            }
            tracks.add(track);
        }
        return tracks;
    }

}
