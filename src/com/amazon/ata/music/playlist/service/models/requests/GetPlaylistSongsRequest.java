package com.amazon.ata.music.playlist.service.models.requests;

import com.amazon.ata.music.playlist.service.models.SongOrder;

import java.util.Objects;

/**
 * The type Get playlist songs request.
 */
public class GetPlaylistSongsRequest {
    private String id;
    private SongOrder order;

    /**
     * Instantiates a new Get playlist songs request.
     */
    public GetPlaylistSongsRequest() {
    }

    /**
     * Instantiates a new Get playlist songs request.
     *
     * @param id    the id
     * @param order the order
     */
    public GetPlaylistSongsRequest(String id, SongOrder order) {
        this.id = id;
        this.order = order;
    }

    /**
     * Instantiates a new Get playlist songs request.
     *
     * @param builder the builder
     */
    public GetPlaylistSongsRequest(Builder builder) {
        this.id = builder.id;
        this.order = builder.order;
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
     * Gets order.
     *
     * @return the order
     */
    public SongOrder getOrder() {
        return order;
    }

    /**
     * Sets order.
     *
     * @param order the order
     */
    public void setOrder(SongOrder order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetPlaylistSongsRequest that = (GetPlaylistSongsRequest) o;
        return Objects.equals(id, that.id) &&
                order == that.order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order);
    }

    @Override
    public String toString() {
        return "GetPlaylistSongsRequest{" +
                "id='" + id + '\'' +
                ", order=" + order +
                '}';
    }

    /**
     * The type Builder.
     */
    public static final class Builder {
        private String id;
        private SongOrder order;

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
         * With order builder.
         *
         * @param orderToUse the order to use
         * @return the builder
         */
        public Builder withOrder(SongOrder orderToUse) {
            this.order = orderToUse;
            return this;
        }

        /**
         * Build get playlist songs request.
         *
         * @return the get playlist songs request
         */
        public GetPlaylistSongsRequest build() {
            return new GetPlaylistSongsRequest(this);
        }
    }
}

