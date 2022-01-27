package com.amazon.ata.music.playlist.service.models.results;

import com.amazon.ata.music.playlist.service.models.PlaylistModel;

/**
 * The type Update playlist result.
 */
public class UpdatePlaylistResult {
    private PlaylistModel playlist;

    /**
     * Instantiates a new Update playlist result.
     *
     * @param builder the builder
     */
    public UpdatePlaylistResult(Builder builder) {
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
         * @param playlistToUse the playlist to use
         * @return the builder
         */
        public Builder withPlaylist(PlaylistModel playlistToUse) {
            this.playlist = playlistToUse;
            return this;
        }

        /**
         * Build update playlist result.
         *
         * @return the update playlist result
         */
        public UpdatePlaylistResult build() {
            return new UpdatePlaylistResult(this);
        }
    }
}

