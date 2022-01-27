package com.amazon.ata.music.playlist.service.models;

import java.util.Objects;

/**
 * The type Song model.
 */
public class SongModel {
    private String asin;
    private String album;
    private int trackNumber;
    private String title;


    /**
     * Builder class.
     */
    public SongModel() {

    }


    /**
     * Instantiates a new Song model.
     *
     * @param builder {@link Builder}
     */
    public SongModel(Builder builder) {
        this.asin = builder.asin;
        this.album = builder.album;
        this.trackNumber = builder.trackNumber;
        this.title = builder.title;
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
     * Gets asin.
     *
     * @return asin asin
     */
    public String getAsin() {
        return asin;
    }


    /**
     * Sets asin.
     *
     * @param asin asin
     */
    public void setAsin(String asin) {
        this.asin = asin;
    }


    /**
     * Gets album.
     *
     * @return album album
     */
    public String getAlbum() {
        return album;
    }


    /**
     * Sets album.
     *
     * @param album album
     */
    public void setAlbum(String album) {
        this.album = album;
    }


    /**
     * Gets track number.
     *
     * @return trackNumber track number
     */
    public int getTrackNumber() {
        return trackNumber;
    }


    /**
     * Sets track number.
     *
     * @param trackNumber trackNumber
     */
    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }


    /**
     * Gets title.
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }


    /**
     * Sets title.
     *
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SongModel songModel = (SongModel) o;
        return trackNumber == songModel.trackNumber &&
                Objects.equals(asin, songModel.asin) &&
                Objects.equals(album, songModel.album) &&
                Objects.equals(title, songModel.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asin, album, trackNumber, title);
    }

    @Override
    public String toString() {
        return "SongModel{" +
                "asin='" + asin + '\'' +
                ", album='" + album + '\'' +
                ", trackNumber=" + trackNumber +
                ", title='" + title + '\'' +
                '}';
    }

    /**
     * The type Builder.
     */
    public static final class Builder {
        private String asin;
        private String album;
        private int trackNumber;
        private String title;


        /**
         * With asin builder.
         *
         * @param asinToUse the asin to use
         * @return {@link Builder}
         */
        public Builder withAsin(String asinToUse) {
            this.asin = asinToUse;
            return this;
        }


        /**
         * With album builder.
         *
         * @param albumToUse album
         * @return {@link Builder}
         */
        public Builder withAlbum(String albumToUse) {
            this.album = albumToUse;
            return this;
        }


        /**
         * With track number builder.
         *
         * @param trackNumberToUse trackNumber
         * @return {@link Builder}
         */
        public Builder withTrackNumber(int trackNumberToUse) {
            this.trackNumber = trackNumberToUse;
            return this;
        }


        /**
         * With title builder.
         *
         * @param titleToUse title
         * @return {@link Builder}
         */
        public Builder withTitle(String titleToUse) {
            this.title = titleToUse;
            return this;
        }


        /**
         * Build song model.
         *
         * @return {@link SongModel}
         */
        public SongModel build() {
            return new SongModel(this);
        }
    }

}


