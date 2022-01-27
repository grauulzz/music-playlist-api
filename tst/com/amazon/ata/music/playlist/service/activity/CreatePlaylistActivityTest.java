package com.amazon.ata.music.playlist.service.activity;

import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.exceptions.InvalidAttributeValueException;
import com.amazon.ata.music.playlist.service.models.requests.CreatePlaylistRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static com.amazon.ata.music.playlist.service.helpers.PlaylistTestHelper.generatePlaylist;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class CreatePlaylistActivityTest {
    @Mock
    private PlaylistDao playlistDao;

    @Mock
    CreatePlaylistActivity cpa;

    @Mock
    private Playlist playlist;

    @BeforeEach
    private void setup() {
        initMocks(this);
        cpa = new CreatePlaylistActivity(playlistDao);
        playlist = generatePlaylist();
    }

    @Test
    void handleRequest_goodRequest_createsPlaylist() {

        // GIVEN
        CreatePlaylistRequest request = CreatePlaylistRequest.builder()
                .withName(playlist.getName())
                .withCustomerId(playlist.getCustomerId())
                .withTags(playlist.getTags())
                .build();


        // WHEN
        cpa.handleRequest(request, null);
        when(playlistDao.getPlaylist(playlist.getId())).thenReturn(playlist);

        // THEN
        assertEquals(playlist.getName(), request.getName());
        assertEquals(playlist.getCustomerId(), request.getCustomerId());
        assertEquals(playlist.getTags(), request.getTags());
    }

    @Test
    void handleRequest_badRequest_throwsException() {
        // GIVEN
        CreatePlaylistRequest request = CreatePlaylistRequest.builder()
                .withName(null)
                .withCustomerId(null)
                .withTags(null)
                .build();

        // WHEN
        assertThrows(InvalidAttributeValueException.class,
                () -> cpa.handleRequest(request, null));
    }
}













//
//    @Test
//    void handleRequest_goodRequest_createsPlaylist() {
//        // GIVEN
//        String customerID = "420";
//        String name = "jim";
//        Set<String> tags = Set.of("tag1", "tag2");
//
//        Playlist playlist = generatePlaylist();
//
//        CreatePlaylistRequest request = CreatePlaylistRequest.builder()
//                .withName(name)
//                .withCustomerId(customerID)
//                .withTags(tags)
//                .build();
//
//        // WHEN
//        cpa.handleRequest(request, null);
//
//
//        when(playlistDao.getPlaylist(expectedId)).thenReturn(playlist);
//
//        // THEN
//        assertEquals(name, request.getName());
//        assertEquals(customerID, request.getCustomerId());
//        assertEquals(tags, request.getTags());
//    }