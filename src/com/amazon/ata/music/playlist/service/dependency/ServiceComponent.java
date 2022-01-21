package com.amazon.ata.music.playlist.service.dependency;


import com.amazon.ata.music.playlist.service.activity.AddSongToPlaylistActivity;
import com.amazon.ata.music.playlist.service.activity.CreatePlaylistActivity;
import com.amazon.ata.music.playlist.service.activity.GetPlaylistActivity;
import com.amazon.ata.music.playlist.service.activity.UpdatePlaylistActivity;
import com.amazon.ata.music.playlist.service.dynamodb.AlbumTrackDao;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Component;

import javax.inject.Singleton;
import java.security.Provider;

@Component(modules = {
        DaoModule.class,
})
@Singleton
public interface ServiceComponent {

    DynamoDBMapper provideDynamoDBMapper();
    PlaylistDao providePlaylistDao();
    AlbumTrackDao provideAlbumTrackDao();

    PlaylistDao getPlaylistDao();

//    void inject(CreatePlaylistActivity createPlaylistActivity);
//    void inject(GetPlaylistActivity getPlaylistActivity);
//    void inject(AddSongToPlaylistActivity addSongToPlaylistActivity);
//    void inject(UpdatePlaylistActivity updatePlaylistActivity);


    /**
     * Provides a new CreatePlaylistActivity with injected dependencies.
     *
     * @return createPlaylistActivity a new CreatePlaylistActivity with injected dependencies.
     */
    CreatePlaylistActivity provideCreatePlaylistActivity();

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

    /**
     * Provides a new AddTrackToPlaylistActivity with injected dependencies.
     *
     * @return addTrackToPlaylistActivity a new AddTrackToPlaylistActivity with injected dependencies.
     */
    AddSongToPlaylistActivity provideAddSongToPlaylistActivity();


//    void inject(Provider.Service service);
//    Provider.Service getService();
//
//    @Component.Builder
//    interface Builder {
//        Builder serviceModule(DaoModule module);
//        ServiceComponent build();
//    }
}





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