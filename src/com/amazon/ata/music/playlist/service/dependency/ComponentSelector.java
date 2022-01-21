package com.amazon.ata.music.playlist.service.dependency;


import com.amazon.ata.music.playlist.service.activity.AddSongToPlaylistActivity;
import com.amazon.ata.music.playlist.service.activity.CreatePlaylistActivity;
import com.amazon.ata.music.playlist.service.activity.GetPlaylistActivity;
import com.amazon.ata.music.playlist.service.activity.UpdatePlaylistActivity;

// TODO: theres a better way to do this
public class ComponentSelector {

    public static GetPlaylistActivity daggerGetPlaylistActivity() {
        return DaggerServiceComponent.builder().build().provideGetPlaylistActivity();
    }

    public static UpdatePlaylistActivity daggerUpdatePlaylistActivity() {
        return DaggerServiceComponent.builder().build().provideUpdatePlaylistActivity();
    }

    public static CreatePlaylistActivity daggerCreatePlaylistActivityProvider() {
        return DaggerServiceComponent.builder().build().provideCreatePlaylistActivity();
    }

    public static AddSongToPlaylistActivity daggerAddSongToPlaylistActivity() {
        return DaggerServiceComponent.builder().build().provideAddSongToPlaylistActivity();
    }

    // TODO: think I forget to have daggerr generate the GetPlaylistSongsActivity
    //    GetPlaylistSongsActivity daggerGetPlaylistSongsActivity() {
    //        return DaggerServiceComponent.builder().build().provideGetPlaylistSongsActivity();
    //    }

    //    UpdatePlaylistActivity daggerUpDatePlaylistActivity() {
    //        if (serviceComponent == null) {
    //            serviceComponent = DaggerServiceComponent.create();
    //        }
    //        return serviceComponent.provideUpdatePlaylistActivity();
    //    }
}