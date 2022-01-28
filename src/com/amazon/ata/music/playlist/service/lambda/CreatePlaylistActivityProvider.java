package com.amazon.ata.music.playlist.service.lambda;

import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.dependency.ServiceComponent;
import com.amazon.ata.music.playlist.service.models.requests.CreatePlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.CreatePlaylistResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

// com.amazon.ata.music.playlist.service.lambda.CreatePlaylistActivityProvider::handleRequest

public class CreatePlaylistActivityProvider implements RequestHandler<CreatePlaylistRequest, CreatePlaylistResult> {

    ServiceComponent sc = DaggerServiceComponent.create();

    /**
     * Empty constructor for the lambda function.
     */
    public CreatePlaylistActivityProvider() {
    }

    /**
     * @param createPlaylistRequest the input to the function
     * @param context the context of the function
     * @return the output of the function
     */
    @Override
    public CreatePlaylistResult handleRequest(final CreatePlaylistRequest createPlaylistRequest,
                                              Context context) {
        return sc.provideCreatePlaylistActivity().handleRequest(createPlaylistRequest,
                context);

    }

}

