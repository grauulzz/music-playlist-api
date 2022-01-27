package com.amazon.ata.music.playlist.service.dynamodb;

import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.dependency.ServiceComponent;
import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.initMocks;


class AlbumTrackDaoTest {

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @InjectMocks
    ServiceComponent sc = DaggerServiceComponent.create();

    @InjectMocks
    DynamoDBMapper dbMapper = sc.provideDynamoDBMapper();


    @Test
    void testGetAlbumTrack() {
        // GIVEN + WHEN
        AlbumTrackDao albumTrackDao = new AlbumTrackDao(dbMapper);

        // THEN
        assertEquals(albumTrackDao.getAlbumTrack("test", 1),
                dbMapper.load(AlbumTrack.class, "test", 1));
    }
}