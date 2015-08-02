package com.thoughtworks.session.organizer.dto.constants;

/**
 * The Class Track.
 */
public class Track {

    /** The description. */
    private String description;

    /** The duration. */
    private int duration;

    /** The session. */
    private Session session;

    /** The is allocated. */
    private boolean isAllocated;

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * 
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the duration.
     * 
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the duration.
     * 
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets the session.
     * 
     * @return the session
     */
    public Session getSession() {
        return session;
    }

    /**
     * Sets the session.
     * 
     * @param session the session to set
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * Checks if is allocated.
     * 
     * @return the isAllocated
     */
    public boolean isAllocated() {
        return isAllocated;
    }

    /**
     * Sets the allocated.
     * 
     * @param isAllocated the isAllocated to set
     */
    public void setAllocated(boolean isAllocated) {
        this.isAllocated = isAllocated;
    }

}
