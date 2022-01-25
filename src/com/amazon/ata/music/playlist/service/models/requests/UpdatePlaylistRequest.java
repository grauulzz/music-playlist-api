package com.amazon.ata.music.playlist.service.models.requests;

import java.util.Objects;

/**
 * The type Update playlist request.
 */
public class UpdatePlaylistRequest {
    private String id;
    private String name;
    private String customerId;

    /**
     * Instantiates a new Update playlist request.
     */
    public UpdatePlaylistRequest() {
    }

    /**
     * Instantiates a new Update playlist request.
     *
     * @param id         the id
     * @param name       the name
     * @param customerId the customer id
     */
    public UpdatePlaylistRequest(String id, String name, String customerId) {
        this.id = id;
        this.name = name;
        this.customerId = customerId;
    }

    /**
     * Instantiates a new Update playlist request.
     *
     * @param builder the builder
     */
    public UpdatePlaylistRequest(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.customerId = builder.customerId;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdatePlaylistRequest that = (UpdatePlaylistRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, customerId);
    }

    @Override
    public String toString() {
        return "UpdatePlaylistRequest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }

    /**
     * The type Builder.
     */
    public static final class Builder {
        private String id;
        private String name;
        private String customerId;

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
         * With name builder.
         *
         * @param nameToUse the name to use
         * @return the builder
         */
        public Builder withName(String nameToUse) {
            this.name = nameToUse;
            return this;
        }

        /**
         * With customer id builder.
         *
         * @param customerIdToUse the customer id to use
         * @return the builder
         */
        public Builder withCustomerId(String customerIdToUse) {
            this.customerId = customerIdToUse;
            return this;
        }

        /**
         * Build update playlist request.
         *
         * @return the update playlist request
         */
        public UpdatePlaylistRequest build() {
            return new UpdatePlaylistRequest(this);
        }
    }
}

