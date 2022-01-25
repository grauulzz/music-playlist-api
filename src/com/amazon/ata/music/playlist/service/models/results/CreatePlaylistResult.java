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
        this.playlist = builder.builderPlaylist;
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
        private PlaylistModel builderPlaylist;

        /**
         * With builderPlaylist builder.
         *
         * @param builderPlaylist the builderPlaylist
         * @return the builder
         */
        public Builder withPlaylist(PlaylistModel builderPlaylist) {
            this.builderPlaylist = builderPlaylist;
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

