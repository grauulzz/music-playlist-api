package com.amazon.ata.music.playlist.service.dependency;


import com.amazon.ata.music.playlist.service.activity.AddSongToPlaylistActivity;
import com.amazon.ata.music.playlist.service.activity.CreatePlaylistActivity;
import com.amazon.ata.music.playlist.service.activity.GetPlaylistActivity;
import com.amazon.ata.music.playlist.service.activity.GetPlaylistSongsActivity;
import com.amazon.ata.music.playlist.service.activity.UpdatePlaylistActivity;
import com.amazon.ata.music.playlist.service.dynamodb.AlbumTrackDao;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Component;

import javax.inject.Singleton;

/**
 * The interface Service component.
 */
@Component(modules = {DaoModule.class})
@Singleton
public interface ServiceComponent {

    /**
     * Provide dynamo db mapper dynamo db mapper.
     *
     * @return a new DynamoDBMapper with injected dependencies.
     */
    DynamoDBMapper provideDynamoDBMapper();

    /**
     * Provide album track dao album track dao.
     *
     * @return a new AlbumTrackDao with injected dependencies.
     */
    AlbumTrackDao provideAlbumTrackDao();

    /**
     * Provide playlist dao playlist dao.
     *
     * @return a new PlaylistDao with injected dependencies.
     */
    PlaylistDao providePlaylistDao();

    /**
     * Provides a new CreatePlaylistActivity with injected dependencies.
     *
     * @return createPlaylistActivity a new CreatePlaylistActivity with injected dependencies.
     */
    CreatePlaylistActivity provideCreatePlaylistActivity();

    /**
     * Provides a new AddTrackToPlaylistActivity with injected dependencies.
     *
     * @return addTrackToPlaylistActivity a new AddTrackToPlaylistActivity with injected dependencies.
     */
    AddSongToPlaylistActivity provideAddSongToPlaylistActivity();

    /**
     * Provides a new DeletePlaylistActivity with injected dependencies.
     *
     * @return getPlaylistSongsActivity a new GetPlaylistSongsActivity with injected dependencies.
     */
    GetPlaylistSongsActivity provideGetPlaylistSongsActivity();

    /**
     * Provides a new GetPlaylistActivity with injected dependencies.
     *
     * @return getPlaylistActivity a new GetPlaylistActivity with injected dependencies.
     */
    GetPlaylistActivity provideGetPlaylistActivity();

    /**
     * Provides a new UpdatePlaylistActivity with injected dependencies.
     *
     * @return updatePlaylistActivity a new UpdatePlaylistActivity with injected dependencies.
     */
    UpdatePlaylistActivity provideUpdatePlaylistActivity();

}
