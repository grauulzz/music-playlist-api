package com.amazon.ata.music.playlist.service.dynamodb.models;

import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.dependency.ServiceComponent;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.amazon.ata.music.playlist.service.helpers.PlaylistTestHelper.generatePlaylist;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.initMocks;

class PlaylistTest {

    @InjectMocks
    PlaylistDao dao;

    @InjectMocks
    ServiceComponent sc = DaggerServiceComponent.create();

    @InjectMocks
    DynamoDBMapper dbMapper = sc.provideDynamoDBMapper();

    Playlist playlist;

    @BeforeEach
    void setUp() {
        initMocks(this);
        playlist = generatePlaylist();
        sc.providePlaylistDao().savePlaylist(playlist);
    }


    String playlistId = "setId";
    String customerId = "setCustomerId";
    String name = "setName";
    Set<String> tags = Set.of("setTags");
    Integer songCount = 1;
    List<AlbumTrack> songList = Collections.emptyList();


    @Test
    void testAllGetters_whenAllSettersAreSet_returnNotNull() {
        // GIVEN + WHEN
        playlist.setId(playlistId);
        playlist.setCustomerId(customerId);
        playlist.setName(name);
        playlist.setTags(tags);
        playlist.setSongCount(songCount);
        playlist.setSongList(songList);

        // THEN
        assertAll(
                () -> assertNotNull(playlist.getId()),
                () -> assertNotNull(playlist.getCustomerId()),
                () -> assertNotNull(playlist.getName()),
                () -> assertNotNull(playlist.getTags()),
                () -> assertNotNull(playlist.getSongCount()),
                () -> assertNotNull(playlist.getSongList())
        );
    }
}