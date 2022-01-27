package com.amazon.ata.music.playlist.service.models;


import java.util.Objects;
import java.util.Set;

/**
 * The type Playlist model.
 */
public class PlaylistModel {
    private String id;
    private String name;
    private String customerId;
    private int songCount;
    private Set<String> tags;

    /**
     * Builder class.
     */
    public PlaylistModel() {

    }

    /**
     * Instantiates a new Playlist model.
     *
     * @param builder {@link Builder}
     */
    public PlaylistModel(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.customerId = builder.customerId;
        this.songCount = builder.songCount;
        this.tags = builder.tags;
    }

    /**
     * Builder builder.
     *
     * @return {@link Builder}
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Gets id.
     *
     * @return playlist id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id set playlist id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return customer name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name playlist name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets customer id.
     *
     * @return customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets song count.
     *
     * @return song count
     */
    public int getSongCount() {
        return songCount;
    }

    /**
     * Sets song count.
     *
     * @param songCount song count
     */
    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    /**
     * Gets tags.
     *
     * @return tags tags
     */
    public Set<String> getTags() {
        return tags;
    }

    /**
     * Sets tags.
     *
     * @param tags playlist tags
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
        PlaylistModel that = (PlaylistModel) o;
        return songCount == that.songCount &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, customerId, songCount, tags);
    }

    @Override
    public String toString() {
        return "PlaylistModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", customerId='" + customerId + '\'' +
                ", songCount=" + songCount +
                ", tags=" + tags +
                '}';
    }

    /**
     * The type Builder.
     */
    public static final class Builder {
        private String id;
        private String name;
        private String customerId;
        private int songCount;
        private Set<String> tags;


        /**
         * With id builder.
         *
         * @param idToUse playlist id
         * @return {@link Builder}
         */
        public Builder withId(String idToUse) {
            this.id = idToUse;
            return this;
        }

        /**
         * With name builder.
         *
         * @param nameToUse playlist name
         * @return {@link Builder}
         */
        public Builder withName(String nameToUse) {
            this.name = nameToUse;
            return this;
        }

        /**
         * With customer id builder.
         *
         * @param customerIdToUse customer id
         * @return {@link Builder}
         */
        public Builder withCustomerId(String customerIdToUse) {
            this.customerId = customerIdToUse;
            return this;
        }

        /**
         * With song count builder.
         *
         * @param songCountToUse song count
         * @return {@link Builder}
         */
        public Builder withSongCount(int songCountToUse) {
            this.songCount = songCountToUse;
            return this;
        }

        /**
         * With tags builder.
         *
         * @param tagsToUse playlist tags
         * @return {@link Builder}
         */
        public Builder withTags(Set<String> tagsToUse) {
            this.tags = tagsToUse;
            return this;
        }

        /**
         * Build playlist model.
         *
         * @return {@link PlaylistModel}
         */
        public PlaylistModel build() {
            return new PlaylistModel(this);
        }
    }
}

