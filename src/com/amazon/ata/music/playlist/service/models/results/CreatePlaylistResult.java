package com.amazon.ata.music.playlist.service.models.results;

import com.amazon.ata.music.playlist.service.models.PlaylistModel;

/**
 * The type Create playlist result.
 */
public class CreatePlaylistResult {
    private PlaylistModel playlist;

    /**
     * Create playlist result.
     *
     * @param builder the builder
     */
    public CreatePlaylistResult(Builder builder) {
        this.playlist = builder.playlist;
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
     * Gets playlist.
     *
     * @return the playlist
     */
    public PlaylistModel getPlaylist() {
        return playlist;
    }

    /**
     * Sets playlist.
     *
     * @param playlist the playlist
     */
    public void setPlaylist(PlaylistModel playlist) {
        this.playlist = playlist;
    }

    /**
     * The type Builder.
     */
    public static final class Builder {
        private PlaylistModel playlist;

        /**
         * With playlist builder.
         *
         * @param playlist the playlist
         * @return the builder
         */
        public Builder withPlaylist(PlaylistModel playlist) {
            this.playlist = playlist;
            return this;
        }

        /**
         * Build create builderPlaylist result.
         *
         * @return create builderPlaylist result
         */
        public CreatePlaylistResult build() {
            return new CreatePlaylistResult(this);
        }
    }

}

