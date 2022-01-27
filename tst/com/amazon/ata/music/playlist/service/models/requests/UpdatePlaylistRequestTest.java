package com.amazon.ata.music.playlist.service.models.requests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.MockitoAnnotations.initMocks;

class UpdatePlaylistRequestTest {

    private final String name = "name";
    private final String customerId = "customerId";
    private final String id = "id";


    private final String newName = "newName";
    private final String newCustomerId = "newCustomerId";

    private final UpdatePlaylistRequest sameRequestDiffObject = new UpdatePlaylistRequest(id,
            name, customerId);

    private final UpdatePlaylistRequest newRequest = new UpdatePlaylistRequest("diffId",
            "diffName", "diffCustomerId");


    @Mock
    private UpdatePlaylistRequest request;


    @BeforeEach
    void setUp() {
        initMocks(this);
        request = new UpdatePlaylistRequest(id, name, customerId);
    }

    @Test
    void testGetters() {
        assertAll(
                () -> Assertions.assertEquals(name, request.getName()),
                () -> Assertions.assertEquals(customerId, request.getCustomerId()),
                () -> Assertions.assertEquals(id, request.getId())
        );
    }

    @Test
    void testSetters() {

        request.setName(newName);
        request.setCustomerId(newCustomerId);
        request.setId(id);

        assertAll(
                () -> Assertions.assertEquals(newName, request.getName()),
                () -> Assertions.assertEquals(newCustomerId, request.getCustomerId()),
                () -> Assertions.assertEquals(id, request.getId())
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
        UpdatePlaylistRequest obj1 = UpdatePlaylistRequest.builder().build();
        UpdatePlaylistRequest obj2 = UpdatePlaylistRequest.builder()
                .withName(name)
                .withCustomerId(customerId)
                .withId(id)
                .build();


        assertAll(
                () -> Assertions.assertNotEquals(obj1, obj2),
                () -> Assertions.assertNotEquals(obj1.hashCode(), obj2.hashCode()),
                () -> Assertions.assertNotEquals(obj1.getId(), obj2.getId()),
                () -> Assertions.assertNotEquals(obj1.getCustomerId(), obj2.getCustomerId()),
                () -> Assertions.assertNotEquals(obj1.getName(), obj2.getName())
        );
    }

    @Test
    void testToString() {
        Assertions.assertEquals("UpdatePlaylistRequest{id='" + id + "', name='" +
                name + "', customerId='" + customerId + "'}", request.toString());
    }
}