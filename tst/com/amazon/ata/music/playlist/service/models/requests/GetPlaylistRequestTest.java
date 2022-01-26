package com.amazon.ata.music.playlist.service.models.requests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.MockitoAnnotations.initMocks;

class GetPlaylistRequestTest {

    @Mock
    private GetPlaylistRequest request;
    private GetPlaylistRequest sameRequestDiffObject;

    private final String id = "id";

    @BeforeEach
    void setUp() {
        initMocks(this);
        request = new GetPlaylistRequest();
        sameRequestDiffObject = new GetPlaylistRequest();
    }

    @Test
    void testAllEquals() {
        Assertions.assertEquals(request, sameRequestDiffObject);
    }

    @Test
    void testAllHashCode() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(request.hashCode(),
                        sameRequestDiffObject.hashCode()),
                () -> Assertions.assertNotEquals(Objects.hashCode(null), request.hashCode())
        );
    }

    @Test
    void testBuilder_allObjectEqualsMethods_assertNotEquals() {
        GetPlaylistRequest obj1 = GetPlaylistRequest.builder().build();
        GetPlaylistRequest obj2 = GetPlaylistRequest.builder()
                .withId(id)
                .build();


        assertAll(
                () -> Assertions.assertNotEquals(obj1, obj2),
                () -> Assertions.assertNotEquals(obj1.hashCode(), obj2.hashCode()),
                () -> Assertions.assertNotEquals(obj1.getId(), obj2.getId())
        );
    }

    @Test
    void testToString() {
        Assertions.assertEquals("GetPlaylistRequest{id='" +
                null + "'}", request.toString());
    }
}