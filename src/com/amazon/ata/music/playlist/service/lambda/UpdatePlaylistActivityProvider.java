package com.amazon.ata.music.playlist.service.lambda;

import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.dependency.ServiceComponent;
import com.amazon.ata.music.playlist.service.models.requests.UpdatePlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.UpdatePlaylistResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

// com.amazon.ata.music.playlist.service.lambda.UpdatePlaylistActivityProvider::handleRequest
public class UpdatePlaylistActivityProvider implements RequestHandler<UpdatePlaylistRequest, UpdatePlaylistResult> {
    ServiceComponent sc = DaggerServiceComponent.create();
    /**
     * Empty constructor for the lambda function.
     */
    public UpdatePlaylistActivityProvider() {
    }

    /**
     * @param updatePlaylistRequest the input to the function
     * @param context the context of the function
     * @return the output of the function
     */
    @Override
    public UpdatePlaylistResult handleRequest(final UpdatePlaylistRequest updatePlaylistRequest, Context context) {
        return sc.provideUpdatePlaylistActivity().handleRequest(updatePlaylistRequest,
                context);
    }
}

