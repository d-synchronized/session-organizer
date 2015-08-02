package com.thoughtworks.session.organizer.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.thoughtworks.session.organizer.core.OrganizerCore;
import com.thoughtworks.session.organizer.dto.constants.Track;
import com.thoughtworks.session.organizer.exceptions.GenericException;
import com.thoughtworks.session.organizer.utils.TrackReader;
import com.thoughtworks.session.organizer.utils.TrackReaderImpl;

/**
 * The Class SessionOrganizerTest.
 */
public class SessionOrganizerTest {

    /**
     * The main method.
     * 
     * @param args the arguments
     */
    public static void main(final String args[]) {

        final TrackReader trackReader = new TrackReaderImpl();
        try {
            final InputStream inputStream = new FileInputStream(new File("C:/Users/Dishant/session-organizer/src/test/java/com/thoughtworks/track-list.txt"));
            final List<Track> tracks = trackReader.readTrackList(inputStream);
            OrganizerCore organizerCore = new OrganizerCore();
            organizerCore.planAndOrganizeTracks(tracks);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (GenericException genericException) {
            genericException.printStackTrace();
        }
    }

}
