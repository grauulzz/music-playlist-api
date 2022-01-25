package com.amazon.ata.music.playlist.service.models.results;

import com.amazon.ata.music.playlist.service.models.SongModel;

import java.util.List;

/**
 * The type Add song to playlist result.
 */
public class AddSongToPlaylistResult {
    private List<SongModel> songList;

    /**
     * Instantiates a new Add song to playlist result.
     *
     * @param builder the builder
     */
    public AddSongToPlaylistResult(Builder builder) {
        this.songList = builder.songList;
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
     * Gets song list.
     *
     * @return the song list
     */
    public List<SongModel> getSongList() {
        return songList;
    }

    /**
     * Sets song list.
     *
     * @param songList the song list
     */
    public void setSongList(List<SongModel> songList) {
        this.songList = songList;
    }

    /**
     * The type Builder.
     */
    public static final class Builder {
        private List<SongModel> songList;

        /**
         * With song list builder.
         *
         * @param songListToUse the song list to use
         * @return the builder
         */
        public Builder withSongList(List<SongModel> songListToUse) {
            this.songList = songListToUse;
            return this;
        }

        /**
         * Build add song to playlist result.
         *
         * @return the add song to playlist result
         */
        public AddSongToPlaylistResult build() {
            return new AddSongToPlaylistResult(this);
        }
    }
}

