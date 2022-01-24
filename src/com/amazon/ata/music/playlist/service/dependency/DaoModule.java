package com.amazon.ata.music.playlist.service.dependency;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazon.ata.music.playlist.service.dynamodb.AlbumTrackDao;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DaoModule {

    // how dagger knows what to generate DI for
    // (marked by @Inject on constructors you want to generate instances of with dagger)
    @Provides
    @Singleton
    public DynamoDBMapper provideDynamoDBMapper() {
        return new DynamoDBMapper(DynamoDbClientProvider
                .getDynamoDBClient(Regions.US_EAST_2));
    }

    @Provides
    @Singleton
    public PlaylistDao providePlaylistDao() {
        return new PlaylistDao(provideDynamoDBMapper());
    }

    @Provides
    @Singleton
    public AlbumTrackDao provideAlbumTrackDao() {
        return new AlbumTrackDao(provideDynamoDBMapper());
    }

}
