package com.amazon.ata.music.playlist.service.models.requests;

import java.util.Objects;

/**
 * The type Add song to playlist request.
 */
public class AddSongToPlaylistRequest {
    private String id;
    private String asin;
    private int trackNumber;
    private boolean queueNext;

    /**
     * Instantiates a new Add song to playlist request.
     */
    public AddSongToPlaylistRequest() {
    }

    /**
     * Instantiates a new Add song to playlist request.
     *
     * @param id          the id
     * @param asin        the asin
     * @param trackNumber the track number
     * @param queueNext   the queue next
     */
    public AddSongToPlaylistRequest(String id, String asin, int trackNumber, boolean queueNext) {
        this.id = id;
        this.asin = asin;
        this.trackNumber = trackNumber;
        this.queueNext = queueNext;
    }

    /**
     * Instantiates a new Add song to playlist request.
     *
     * @param builder the builder
     */
    public AddSongToPlaylistRequest(Builder builder) {
        this.asin = builder.asin;
        this.id = builder.id;
        this.trackNumber = builder.trackNumber;
        this.queueNext = builder.queueNext;
    }

    /**
     * Builder builder.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets asin.
     *
     * @return the asin
     */
    public String getAsin() {
        return asin;
    }

    /**
     * Sets asin.
     *
     * @param asin the asin
     */
    public void setAsin(String asin) {
        this.asin = asin;
    }

    /**
     * Gets track number.
     *
     * @return the track number
     */
    public int getTrackNumber() {
        return trackNumber;
    }

    /**
     * Sets track number.
     *
     * @param trackNumber the track number
     */
    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    /**
     * Is queue next boolean.
     *
     * @return the boolean
     */
    public boolean isQueueNext() {
        return queueNext;
    }

    /**
     * Sets queue next.
     *
     * @param queueNext the queue next
     */
    public void setQueueNext(boolean queueNext) {
        this.queueNext = queueNext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddSongToPlaylistRequest that = (AddSongToPlaylistRequest) o;
        return trackNumber == that.trackNumber &&
                queueNext == that.queueNext &&
                Objects.equals(id, that.id) &&
                Objects.equals(asin, that.asin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, asin, trackNumber, queueNext);
    }

    @Override
    public String toString() {
        return "AddSongToPlaylistRequest{" +
                "id='" + id + '\'' +
                ", asin='" + asin + '\'' +
                ", trackNumber=" + trackNumber +
                ", queueNext=" + queueNext +
                '}';
    }

    /**
     * The type Builder.
     */
    public static final class Builder {
        private String id;
        private String asin;
        private int trackNumber;
        private boolean queueNext;

        private Builder() {

        }

        /**
         * With id builder.
         *
         * @param idToUse the id to use
         * @return the builder
         */
        public Builder withId(String idToUse) {
            this.id = idToUse;
            return this;
        }

        /**
         * With asin builder.
         *
         * @param asinToUse the asin to use
         * @return the builder
         */
        public Builder withAsin(String asinToUse) {
            this.asin = asinToUse;
            return this;
        }

        /**
         * With track number builder.
         *
         * @param trackNumberToUse the track number to use
         * @return the builder
         */
        public Builder withTrackNumber(int trackNumberToUse) {
            this.trackNumber = trackNumberToUse;
            return this;
        }

        /**
         * With queue next builder.
         *
         * @param queueNextToUse the queue next to use
         * @return the builder
         */
        public Builder withQueueNext(boolean queueNextToUse) {
            this.queueNext = queueNextToUse;
            return this;
        }

        /**
         * Build add song to playlist request.
         *
         * @return the add song to playlist request
         */
        public AddSongToPlaylistRequest build() {
            return new AddSongToPlaylistRequest(this);
        }
    }
}

