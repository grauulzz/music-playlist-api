package com.amazon.ata.music.playlist.service.models.requests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.MockitoAnnotations.initMocks;

class AddSongToPlaylistRequestTest {

    private final String id = "123";
    private final String asin = "asin";
    private final int trackNum = 3;
    private final boolean queueNext = false;

    private final String newId = "newId";
    private final String newAsin = "newAsin";
    private final int newTrackNum = 4;
    private final boolean newQueueNext = true;

    private final AddSongToPlaylistRequest sameRequestDiffObject = new AddSongToPlaylistRequest(id, asin,
            trackNum, false);

    private final AddSongToPlaylistRequest newRequest = new AddSongToPlaylistRequest("diffId", "diffAsin",
            4, true);

    @Mock
    private AddSongToPlaylistRequest request;


    @BeforeEach
    void setUp() {
        initMocks(this);
        request = new AddSongToPlaylistRequest(id, asin, trackNum, queueNext);
    }

    @Test
    void testGetters() {
        assertAll(
                () -> Assertions.assertEquals(id, request.getId()),
                () -> Assertions.assertEquals(asin, request.getAsin()),
                () -> Assertions.assertEquals(trackNum, request.getTrackNumber()),
                () -> Assertions.assertEquals(queueNext, request.isQueueNext())
        );
    }

    @Test
    void testSetters() {

        request.setId(newId);
        request.setAsin(newAsin);
        request.setTrackNumber(newTrackNum);
        request.setQueueNext(newQueueNext);

        assertAll(
                () -> Assertions.assertEquals(newId, request.getId()),
                () -> Assertions.assertEquals(newAsin, request.getAsin()),
                () -> Assertions.assertEquals(newTrackNum, request.getTrackNumber()),
                () -> Assertions.assertEquals(newQueueNext, request.isQueueNext())
        );
    }

    @Test
    void testToString() {
        Assertions.assertEquals("AddSongToPlaylistRequest{id='" + id + "', asin='" + asin + "', trackNumber="
                + trackNum + ", queueNext=" + queueNext + "}", request.toString());
    }


    @Test
    void testAllEquals() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(request, sameRequestDiffObject),
                () -> Assertions.assertNotEquals(request, newRequest),
                () -> Assertions.assertNotEquals(null, request)
        );
    }

    @Test
    void testAllHashCode() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(request.hashCode(),
                        sameRequestDiffObject.hashCode()),
                () -> Assertions.assertNotEquals(request.hashCode(), newRequest.hashCode()),
                () -> Assertions.assertNotEquals(Objects.hashCode(null), request.hashCode())
        );
    }

    @Test
    void testBuilder_allObjectEqualsMethods_assertNotEquals() {
        AddSongToPlaylistRequest obj1 = AddSongToPlaylistRequest.builder().build();
        AddSongToPlaylistRequest obj2 = AddSongToPlaylistRequest.builder()
                .withTrackNumber(4234)
                .withAsin("adsf")
                .withId("asdfg")
                .withQueueNext(true)
                .build();

        assertAll(
                () -> Assertions.assertNotEquals(obj1, obj2),
                () -> Assertions.assertNotEquals(obj1.hashCode(), obj2.hashCode()),
                () -> Assertions.assertNotEquals(obj1.getTrackNumber(), obj2.getTrackNumber()),
                () -> Assertions.assertNotEquals(obj1.getAsin(), obj2.getAsin()),
                () -> Assertions.assertNotEquals(obj1.getId(), obj2.getId()),
                () -> Assertions.assertNotEquals(obj1.isQueueNext(), obj2.isQueueNext())
        );
    }
}

