package com.amazon.ata.music.playlist.service.lambda;

import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.models.requests.GetPlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.GetPlaylistResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class GetPlaylistActivityProvider implements RequestHandler<GetPlaylistRequest, GetPlaylistResult> {

    /**
     * Empty constructor for the lambda function.
     */
    public GetPlaylistActivityProvider() {
    }

    /**
     * @param getPlaylistRequest the input to the function
     * @param context the context of the function
     * @return the output of the function
     */
    @Override
    public GetPlaylistResult handleRequest(final GetPlaylistRequest getPlaylistRequest,
                                           Context context) {
        return DaggerServiceComponent.create()
                .provideGetPlaylistActivity()
                .handleRequest(getPlaylistRequest, context);
    }

}

