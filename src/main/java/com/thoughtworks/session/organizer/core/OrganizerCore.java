package com.thoughtworks.session.organizer.core;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.knapsack.utils.core.KnapsackCoreImpl;
import com.thoughtworks.knapsack.utils.core.interfaces.KnapsackCore;
import com.thoughtworks.knapsack.utils.dto.KnapsackDetailRequest;
import com.thoughtworks.session.organizer.dto.constants.Session;
import com.thoughtworks.session.organizer.dto.constants.Track;
import com.thoughtworks.session.organizer.exceptions.GenericException;

/**
 * The Class OrganizerCore.
 */
public class OrganizerCore {

    /**
     * Plan and organize tracks.
     * 
     * @param tracks the tracks
     * @throws GenericException the generic exception
     */
    public void planAndOrganizeTracks(final List<Track> tracks) throws GenericException {

        if (tracks == null || tracks.isEmpty()) {
            throw new GenericException("Error occurred while organing and planning the tracks ,Error -  'Invalid track list'");
        }

        final int numberOfTracks = tracks.size();

        for (final Session session : Session.values()) {
            if (Session.LUNCH_SESSION.equals(session) || Session.NETWORKING_SESSION.equals(session)) {
                continue;
            }

            final int sessionDuration = session.getDurationInMinutes();

            int numberOfCountableTracks = 0;
            final List<Track> trackList = new ArrayList<Track>();
            for (int trackCounter = 0; trackCounter < numberOfTracks; trackCounter++) {
                final Track track = tracks.get(trackCounter);
                if (track.isAllocated()) {
                    continue;
                }
                numberOfCountableTracks++;
                trackList.add(track);
            }
            
            final int[] trackDuration = new int[numberOfCountableTracks + 1];
            final int[] preferenceValue = new int[numberOfCountableTracks + 1];

            for (int trackCounter = 0; trackCounter < numberOfCountableTracks; trackCounter++) {
                final Track track = trackList.get(trackCounter);
                trackDuration[trackCounter + 1] = preferenceValue[trackCounter + 1] = track.getDuration();
            }

            final KnapsackDetailRequest knapsackDetailRequest = new KnapsackDetailRequest();
            knapsackDetailRequest.setMaxWeight(sessionDuration);
            knapsackDetailRequest.setNumberOfItems(numberOfCountableTracks);
            knapsackDetailRequest.setWeights(trackDuration);
            knapsackDetailRequest.setBenefits(preferenceValue);

            final KnapsackCore knapsackCore = new KnapsackCoreImpl();
            final boolean[] selectedItems = knapsackCore.fetchMaxBenfitItems(knapsackDetailRequest);

            for (int trackCounter = 0; trackCounter < numberOfCountableTracks; trackCounter++) {
                final boolean trackSelected = selectedItems[trackCounter];
                if (trackSelected) {
                    final Track track = trackList.get(trackCounter);
                    track.setAllocated(true);
                    track.setSession(session);
                }
            }
        }
    }

}
