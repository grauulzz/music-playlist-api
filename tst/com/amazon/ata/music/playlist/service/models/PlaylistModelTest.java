package com.amazon.ata.music.playlist.service.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.MockitoAnnotations.initMocks;

class PlaylistModelTest {

    private final String name = "name";
    private final String customerId = "customerId";
    private final String id = "id";

    private final Set<String> tags = Collections.singleton("tag");
    private final Set<String> newTags = Collections.singleton("newTag");


    private final String newName = "newName";
    private final String newCustomerId = "newCustomerId";


    @Mock
    private PlaylistModel request;

    @Mock
    private PlaylistModel newRequest = PlaylistModel.builder().build();

    @BeforeEach
    void setUp() {
        initMocks(this);
        request = PlaylistModel.builder()
                .withTags(tags)
                .withSongCount(2)
                .withCustomerId(customerId)
                .withId(id)
                .withName(name)
                .build();
    }

    @Test
    void testGetters() {
        assertAll(
                () -> Assertions.assertEquals(tags, request.getTags()),
                () -> Assertions.assertEquals(2, request.getSongCount()),
                () -> Assertions.assertEquals(customerId, request.getCustomerId()),
                () -> Assertions.assertEquals(id, request.getId()),
                () -> Assertions.assertEquals(name, request.getName())
        );
    }

    @Test
    void testSetters() {

        request.setTags(newTags);
        request.setSongCount(3);
        request.setCustomerId(newCustomerId);
        request.setId(id);
        request.setName(newName);

        assertAll(
                () -> Assertions.assertEquals(newName, request.getName()),
                () -> Assertions.assertEquals(newCustomerId, request.getCustomerId()),
                () -> Assertions.assertEquals(id, request.getId()),
                () -> Assertions.assertEquals(3, request.getSongCount()),
                () -> Assertions.assertEquals(newTags, request.getTags())
        );
    }

    @Test
    void testBuilder_allObjectEqualsMethods_assertNotEquals() {
        assertAll(
                () -> Assertions.assertNotEquals(request, newRequest),
                () -> Assertions.assertNotEquals(request.hashCode(), newRequest.hashCode()),
                () -> Assertions.assertNotEquals(request.getId(), newRequest.getId()),
                () -> Assertions.assertNotEquals(request.getCustomerId(), newRequest.getCustomerId()),
                () -> Assertions.assertNotEquals(request.getName(), newRequest.getName()),
                () -> Assertions.assertNotEquals(request.getSongCount(), newRequest.getSongCount()),
                () -> Assertions.assertNotEquals(request.getTags(), newRequest.getTags()),
                () -> Assertions.assertNotEquals(request.hashCode(), newRequest.hashCode())
        );
    }

    @Test
    void testToString() {
        assertAll(
                () -> Assertions.assertEquals("PlaylistModel{id='" + id +
                                "', name='" + name + "', customerId='" + customerId +
                                "', songCount=2, tags=" + tags + "}",
                        request.toString())
        );
    }

}