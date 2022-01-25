package com.amazon.ata.music.playlist.service.models.results;

import com.amazon.ata.music.playlist.service.models.PlaylistModel;

/**
 * The type Get playlist result.
 */
public class GetPlaylistResult {
    private PlaylistModel playlist;

    /**
     * Instantiates a new Get playlist result.
     *
     * @param builder the builder
     */
    public GetPlaylistResult(Builder builder) {
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
         * Build get playlist result.
         *
         * @return the get playlist result
         */
        public GetPlaylistResult build() {
            return new GetPlaylistResult(this);
        }
    }
}

