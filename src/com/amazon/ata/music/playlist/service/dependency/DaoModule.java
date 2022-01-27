package com.amazon.ata.music.playlist.service.dependency;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazon.ata.music.playlist.service.dynamodb.AlbumTrackDao;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Dagger module for DAO dependencies.
 */
@Module
public class DaoModule {

    /**
     * Provide dynamo db mapper dynamo db mapper.
     *
     * @return A {@link DynamoDBMapper} instance.
     * @see DynamoDBMapper
     */
    @Provides
    @Singleton
    public DynamoDBMapper provideDynamoDBMapper() {
        return new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.US_EAST_2));
    }

    /**
     * Provide playlist dao playlist dao.
     *
     * @return A {@link PlaylistDao} instance.
     * @see PlaylistDao
     */
    @Provides
    @Singleton
    public PlaylistDao providePlaylistDao() {
        return new PlaylistDao(provideDynamoDBMapper());
    }

    /**
     * Provide album track dao album track dao.
     *
     * @return A {@link AlbumTrackDao} instance.
     * @see AlbumTrackDao
     */
    @Provides
    @Singleton
    public AlbumTrackDao provideAlbumTrackDao() {
        return new AlbumTrackDao(provideDynamoDBMapper());
    }

}
