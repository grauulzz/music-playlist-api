package com.amazon.ata.music.playlist.service.models.requests;

import com.amazon.ata.music.playlist.service.models.SongOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.MockitoAnnotations.initMocks;

class GetPlaylistSongsRequestTest {

    private final String id = "123";
    private final SongOrder songOrder = SongOrder.DEFAULT;


    private final String newId = "newId";
    private final SongOrder shuffled = SongOrder.SHUFFLED;

    private final GetPlaylistSongsRequest sameRequestDiffObject = new GetPlaylistSongsRequest(id, songOrder);
    private final GetPlaylistSongsRequest newRequest = new GetPlaylistSongsRequest(newId, shuffled);

    @Mock
    private GetPlaylistSongsRequest request;


    @BeforeEach
    void setUp() {
        initMocks(this);
        request = new GetPlaylistSongsRequest(id, songOrder);
    }

    @Test
    void testGetters() {
        assertAll(
                () -> Assertions.assertEquals(id, request.getId()),
                () -> Assertions.assertEquals(songOrder, request.getOrder())
        );
    }

    @Test
    void testSetters() {

        request.setId(newId);
        request.setOrder(shuffled);


        assertAll(
                () -> Assertions.assertEquals(newId, request.getId()),
                () -> Assertions.assertEquals(shuffled, request.getOrder())
        );
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
        GetPlaylistSongsRequest obj1 = GetPlaylistSongsRequest.builder().build();
        GetPlaylistSongsRequest obj2 = GetPlaylistSongsRequest.builder()
                .withId(newId)
                .withOrder(shuffled)
                .build();

        assertAll(
                () -> Assertions.assertNotEquals(obj1, obj2),
                () -> Assertions.assertNotEquals(obj1.hashCode(), obj2.hashCode()),
                () -> Assertions.assertNotEquals(obj1.getOrder(), obj2.getOrder()),
                () -> Assertions.assertNotEquals(obj1.getId(), obj2.getId())
        );
    }

    @Test
    void testToString() {
        Assertions.assertEquals(
                "GetPlaylistSongsRequest{id='" + id + "', order=" + songOrder + "}",
                request.toString()
        );
    }
}
