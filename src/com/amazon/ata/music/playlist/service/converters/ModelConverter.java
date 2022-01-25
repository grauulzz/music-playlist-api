package com.amazon.ata.music.playlist.service.converters;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.models.PlaylistModel;
import com.amazon.ata.music.playlist.service.models.SongModel;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Model converter.
 */
public class ModelConverter {

    /**
     * To playlist model.
     *
     * @param playlist DynamoDB Playlist
     * @return PlaylistModel playlist model
     */
    public PlaylistModel toPlaylistModel(Playlist playlist) {
        return PlaylistModel.builder()
                .withId(playlist.getId())
                .withName(playlist.getName())
                .withCustomerId(playlist.getCustomerId())
                .withSongCount(playlist.getSongCount())
                .withTags(playlist.getTags())
                .build();
    }

    /**
     * To song model list.
     *
     * @param list DynamoDB Playlist list
     * @return PlaylistModel list
     */
    public List<SongModel> toSongModelList(List<AlbumTrack> list) {
        List<SongModel> songModelList = new ArrayList<>(list.size());
        list.forEach(albumTrack -> songModelList.add(SongModel.builder()
                .withTrackNumber(albumTrack.getTrackNumber())
                .withAsin(albumTrack.getAsin())
                .withAlbum(albumTrack.getAlbumName())
                .withTitle(albumTrack.getSongTitle())
                .build()));

        return songModelList;
    }

}

