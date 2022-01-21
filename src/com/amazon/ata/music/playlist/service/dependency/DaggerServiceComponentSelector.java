
//package com.amazon.ata.music.playlist.service.dependency;
//
//import com.amazon.ata.music.playlist.service.activity.AddSongToPlaylistActivity;
//import com.amazon.ata.music.playlist.service.activity.CreatePlaylistActivity;
//import com.amazon.ata.music.playlist.service.activity.GetPlaylistActivity;
//import com.amazon.ata.music.playlist.service.activity.UpdatePlaylistActivity;
//
//
//public enum DaggerServiceComponentSelector {
//    INSTANCE;
//
//    GetPlaylistActivity daggerGetPlaylistActivity() {
//        return DaggerServiceComponent.builder().build().provideGetPlaylistActivity();
//    }
//
//    UpdatePlaylistActivity daggerUpdatePlaylistActivity() {
//        return DaggerServiceComponent.builder().build().provideUpdatePlaylistActivity();
//    }
//
//    CreatePlaylistActivity daggerCreatePlaylistActivityProvider() {
//        return DaggerServiceComponent.builder().build().provideCreatePlaylistActivity();
//    }
//
//    AddSongToPlaylistActivity daggerAddSongToPlaylistActivity() {
//        return DaggerServiceComponent.builder().build().provideAddSongToPlaylistActivity();
//    }
//
//}