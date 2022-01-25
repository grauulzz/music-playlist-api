package com.amazon.ata.music.playlist.service.models.requests;

import java.util.Objects;
import java.util.Set;

/**
 * The type Create playlist request.
 */
public class CreatePlaylistRequest {
    private String name;
    private String customerId;
    private Set<String> tags;

    /**
     * Instantiates a new Create playlist request.
     *
     * @param name       the name
     * @param customerId the customer id
     * @param tags       the tags
     */
    public CreatePlaylistRequest(String name, String customerId, Set<String> tags) {
        this.name = name;
        this.customerId = customerId;
        this.tags = tags;
    }

    /**
     * Instantiates a new Create playlist request.
     */
    public CreatePlaylistRequest() {
    }

    /**
     * Instantiates a new Create playlist request.
     *
     * @param builder the builder
     */
    public CreatePlaylistRequest(Builder builder) {
        this.name = builder.name;
        this.customerId = builder.customerId;
        this.tags = builder.tags;
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

    /**
     * Gets tags.
     *
     * @return the tags
     */
    public Set<String> getTags() {
        return tags;
    }

    /**
     * Sets tags.
     *
     * @param tags the tags
     */
    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreatePlaylistRequest that = (CreatePlaylistRequest) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, customerId, tags);
    }

    @Override
    public String toString() {
        return "CreatePlaylistRequest{" +
                "name='" + name + '\'' +
                ", customerId='" + customerId + '\'' +
                ", tags=" + tags +
                '}';
    }

    /**
     * The type Builder.
     */
    public static final class Builder {
        private String name;
        private String customerId;
        private Set<String> tags;

        private Builder() {

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
         * With tags builder.
         *
         * @param tagsToUse the tags to use
         * @return the builder
         */
        public Builder withTags(Set<String> tagsToUse) {
            this.tags = tagsToUse;
            return this;
        }

        /**
         * Build create playlist request.
         *
         * @return the create playlist request
         */
        public CreatePlaylistRequest build() {
            return new CreatePlaylistRequest(this);
        }
    }
}

