package com.amazon.ata.music.playlist.service.models.requests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.MockitoAnnotations.initMocks;

class CreatePlaylistRequestTest {

    private final String name = "name";
    private final String customerId = "customerId";
    private final Set<String> tags = Collections.singleton("tag");


    private final String newName = "newName";
    private final String newCustomerId = "newCustomerId";

    private final CreatePlaylistRequest sameRequestDiffObject = new CreatePlaylistRequest(name,
            customerId, tags);

    private final CreatePlaylistRequest newRequest = new CreatePlaylistRequest("diffName",
            "diffCustomerId", Collections.singleton("diffTag"));


    @Mock
    private CreatePlaylistRequest request;


    @BeforeEach
    void setUp() {
        initMocks(this);
        request = new CreatePlaylistRequest(name, customerId, tags);
    }

    @Test
    void testGetters() {
        assertAll(
                () -> Assertions.assertEquals(name, request.getName()),
                () -> Assertions.assertEquals(customerId, request.getCustomerId()),
                () -> Assertions.assertEquals(tags, request.getTags())
        );
    }

    @Test
    void testSetters() {

        request.setName(newName);
        request.setCustomerId(newCustomerId);
        request.setTags(tags);

        assertAll(
                () -> Assertions.assertEquals(newName, request.getName()),
                () -> Assertions.assertEquals(newCustomerId, request.getCustomerId()),
                () -> Assertions.assertEquals(tags, request.getTags())
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
        CreatePlaylistRequest obj1 = CreatePlaylistRequest.builder().build();
        CreatePlaylistRequest obj2 = CreatePlaylistRequest.builder()
                        .withName(name)
                        .withCustomerId(customerId)
                        .withTags(tags)
                        .build();


        assertAll(
                () -> Assertions.assertNotEquals(obj1, obj2),
                () -> Assertions.assertNotEquals(obj1.hashCode(), obj2.hashCode()),
                () -> Assertions.assertNotEquals(obj1.getTags(), obj2.getTags()),
                () -> Assertions.assertNotEquals(obj1.getCustomerId(), obj2.getCustomerId()),
                () -> Assertions.assertNotEquals(obj1.getName(), obj2.getName())
        );
    }

    @Test
    void testToString() {
        Assertions.assertEquals(
                "CreatePlaylistRequest{name='" + name + "', customerId='"
                        + customerId + "', tags=" + tags + "}",
                request.toString());
    }
}