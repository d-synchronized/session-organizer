package com.thoughtworks.session.organizer.dto.constants;

/**
 * The Enum SessionType.
 */
public enum Session {

    /** The morning session. */
    MORNING_SESSION(240, 9, 12, SessionType.INTERACTIVE),

    /** The lunch session. */
    LUNCH_SESSION(60, 12, 1, SessionType.BREAK),

    /** The evening session. */
    EVENING_SESSION(240, 1, 5, SessionType.INTERACTIVE),

    /** The networking session. */
    NETWORKING_SESSION(60, 5, 6, SessionType.OTHER);

    /** The duration in minutes. */
    private int durationInMinutes;

    /** The start time. */
    private int startTime;

    /** The end time. */
    private int endTime;

    /** The session type. */
    private SessionType sessionType;

    /**
     * Instantiates a new session type.
     * 
     * @param durationInMinutes the duration in minutes
     * @param startTime the start time
     * @param endTime the end time
     * @param sessionType the session type
     */
    private Session(int durationInMinutes, int startTime, int endTime, SessionType sessionType) {
        this.durationInMinutes = durationInMinutes;
        this.startTime = startTime;
        this.endTime = endTime;
        this.setSessionType(sessionType);
    }

    /**
     * Gets the duration in minutes.
     * 
     * @return the durationInMinutes
     */
    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    /**
     * Sets the duration in minutes.
     * 
     * @param durationInMinutes the durationInMinutes to set
     */
    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    /**
     * Gets the start time.
     * 
     * @return the startTime
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time.
     * 
     * @param startTime the startTime to set
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the end time.
     * 
     * @return the endTime
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time.
     * 
     * @param endTime the endTime to set
     */
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets the session type.
     * 
     * @return the sessionType
     */
    public SessionType getSessionType() {
        return sessionType;
    }

    /**
     * Sets the session type.
     * 
     * @param sessionType the sessionType to set
     */
    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

}
