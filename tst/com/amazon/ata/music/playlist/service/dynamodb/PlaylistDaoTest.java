package com.amazon.ata.music.playlist.service.dynamodb;

import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.dependency.ServiceComponent;
import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.helpers.PlaylistTestHelper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;
import java.util.Set;

import static com.amazon.ata.music.playlist.service.helpers.PlaylistTestHelper.generatePlaylist;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.initMocks;

class PlaylistDaoTest {

    @InjectMocks
    PlaylistDao injectedDao;

    @InjectMocks
    ServiceComponent sc = DaggerServiceComponent.create();

    @InjectMocks
    DynamoDBMapper dbMapper = sc.provideDynamoDBMapper();

    @BeforeEach
    void setUp() {
        initMocks(this);
        injectedDao = sc.providePlaylistDao();
        injectedDao.savePlaylist(playlist);
    }

    Playlist playlist = generatePlaylist();
    String playlistId = playlist.getId();

    @Test
    void daoSavePlaylist_returnsNotNullPlaylist() {
        assertNotNull(injectedDao.getPlaylist(playlistId));
    }

    @Test
    void daoGetPlaylist_returnsPlaylistWithSameId() {
        assertEquals(playlistId, injectedDao.getPlaylist(playlistId).getId());
    }

    @Test
    void daoGetPlaylist_returnsPlaylistWithSameName() {
        assertEquals(playlist.getName(), injectedDao.getPlaylist(playlistId).getName());
    }

    @Test
    void daoGetPlaylist_returnsPlaylistWithSameTags() {
        assertEquals(playlist.getTags(), injectedDao.getPlaylist(playlistId).getTags());
    }

    @Test
    void daoGetPlaylist_returnsPlaylistWithSameCustomerId() {
        assertEquals(playlist.getCustomerId(), injectedDao.getPlaylist(playlistId).getCustomerId());
    }

    @Test
    void daoGetPlaylist_returnsPlaylistWithSameSongCount() {
        assertEquals(playlist.getSongCount(), injectedDao.getPlaylist(playlistId).getSongCount());
    }


    @Test
    void getPlaylistDao_withInjectedMapper_returnsNotNull() {
        PlaylistDao dao  = new PlaylistDao(dbMapper);
        assertNotNull(dao);
    }

    @Test
    void getInjectPlaylistDao_returnsNotNull() {
        assertNotNull(injectedDao);
    }

    @Test
    void getPlaylist_withValidId_returnsPlaylist() {
        Playlist playlist = injectedDao.getPlaylist(playlistId);
        assertNotNull(playlist);
    }

    @Test
    void getPlaylist_withInvalidId_returnsNull() {
        Playlist playlist = injectedDao.getPlaylist("invalidId");
        assertNull(playlist);
    }

    @Test
    void dbMapper_loadId_returnsEqualId() {
        dbMapper.save(playlist);
        Playlist playlistFromDb = dbMapper.load(Playlist.class, playlistId);
        assertEquals(playlistId, playlistFromDb.getId());
    }

    @Test
    void dbMapper_delete_returnsNullPlaylist() {
        dbMapper.save(playlist);
        dbMapper.delete(playlist);
        Playlist playlistFromDb = dbMapper.load(Playlist.class, playlist.getId());
        assertNull(playlistFromDb);
    }

    @Test
    void dbMapper_update_returnsUpdatedPlaylist() {
        dbMapper.save(playlist);
        Playlist playlistFromDb = dbMapper.load(Playlist.class, playlist.getId());
        assertEquals(playlist.getId(), playlistFromDb.getId());
        playlistFromDb.setName("new name");
        dbMapper.save(playlistFromDb);
        Playlist updatedPlaylist = dbMapper.load(Playlist.class, playlist.getId());
        assertEquals("new name", updatedPlaylist.getName());
    }

    @Test
    void dbMapper_create_returnsNewPlaylist() {
        Playlist newPlaylist = new Playlist();
        newPlaylist.setId("PPT03");
        newPlaylist.setName("PPT03 playlist");
        newPlaylist.setCustomerId("1");
        newPlaylist.setSongCount(0);
        newPlaylist.setTags(null);
        dbMapper.save(newPlaylist);
        Playlist playlistFromDb = dbMapper.load(Playlist.class, newPlaylist.getId());
        assertEquals(newPlaylist.getId(), playlistFromDb.getId());
        assertEquals(newPlaylist.getName(), playlistFromDb.getName());
        assertEquals(newPlaylist.getCustomerId(), playlistFromDb.getCustomerId());
        assertEquals(newPlaylist.getTags(), playlistFromDb.getTags());
        assertEquals(newPlaylist.getSongCount(), playlistFromDb.getSongCount());
    }

}
