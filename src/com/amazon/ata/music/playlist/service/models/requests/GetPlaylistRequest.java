package com.amazon.ata.music.playlist.service.models.requests;

import java.util.Objects;

/**
 * The type Get playlist request.
 */
public class GetPlaylistRequest {
    private String id;

    /**
     * Instantiates a new Get playlist request.
     */
    public GetPlaylistRequest() {

    }

    /**
     * Instantiates a new Get playlist request.
     *
     * @param builder the builder
     */
    public GetPlaylistRequest(Builder builder) {
        this.id = builder.id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetPlaylistRequest that = (GetPlaylistRequest) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GetPlaylistRequest{" +
                "id='" + id + '\'' +
                '}';
    }

    /**
     * The type Builder.
     */
    public static final class Builder {
        private String id;

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
         * Build get playlist request.
         *
         * @return the get playlist request
         */
        public GetPlaylistRequest build() {
            return new GetPlaylistRequest(this);
        }
    }
}

