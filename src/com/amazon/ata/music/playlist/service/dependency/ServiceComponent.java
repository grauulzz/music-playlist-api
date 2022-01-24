package com.amazon.ata.music.playlist.service.dependency;


import com.amazon.ata.music.playlist.service.activity.*;
import com.amazon.ata.music.playlist.service.dynamodb.AlbumTrackDao;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {
        DaoModule.class,
})
@Singleton
public interface ServiceComponent {

    DynamoDBMapper provideDynamoDBMapper();

    AlbumTrackDao provideAlbumTrackDao();

    PlaylistDao providePlaylistDao();

    /**
     * Provides a new CreatePlaylistActivity with injected dependencies.
     *
     * TODO: implement this CreatePlaylistActivity to bypass App
     *
     * @return createPlaylistActivity a new CreatePlaylistActivity with injected dependencies.
     */
    CreatePlaylistActivity provideCreatePlaylistActivity();

    /**
     * Provides a new AddTrackToPlaylistActivity with injected dependencies.
     *
     * TODO: implement this AddTrackToPlaylistActivity to bypass App
     *
     * @return addTrackToPlaylistActivity a new AddTrackToPlaylistActivity with injected dependencies.
     */
    AddSongToPlaylistActivity provideAddSongToPlaylistActivity();

    /**
     * Provides a new DeletePlaylistActivity with injected dependencies.
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


//    void inject(Provider.Service service);
//    Provider.Service getService();
//
//    @Component.Builder
//    interface Builder {
//        Builder serviceModule(DaoModule module);
//        ServiceComponent build();
//    }
//}


//    void inject(CreatePlaylistActivity createPlaylistActivity);
//    void inject(GetPlaylistActivity getPlaylistActivity);
//    void inject(AddSongToPlaylistActivity addSongToPlaylistActivity);
//    void inject(UpdatePlaylistActivity updatePlaylistAct




//@Component(modules = {
//        DaoModule.class,
//})
//@Singleton
//public interface ServiceComponent {
//    void inject(Service service);
//    Service getService();
//
//    @Component.Builder
//    interface Builder {
//        Builder serviceModule(DaoModule module);
//        ServiceComponent build();
//    }
//}