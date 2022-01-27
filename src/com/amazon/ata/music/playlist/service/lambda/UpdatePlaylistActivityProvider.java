package com.amazon.ata.music.playlist.service.lambda;

import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.models.requests.UpdatePlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.UpdatePlaylistResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class UpdatePlaylistActivityProvider implements RequestHandler<UpdatePlaylistRequest, UpdatePlaylistResult> {

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
        return DaggerServiceComponent.create()
                .provideUpdatePlaylistActivity()
                .handleRequest(updatePlaylistRequest, context);
    }

}

