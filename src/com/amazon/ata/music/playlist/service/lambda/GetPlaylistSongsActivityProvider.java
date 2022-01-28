package com.amazon.ata.music.playlist.service.lambda;

import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.dependency.ServiceComponent;
import com.amazon.ata.music.playlist.service.models.requests.GetPlaylistSongsRequest;
import com.amazon.ata.music.playlist.service.models.results.GetPlaylistSongsResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


// com.amazon.ata.music.playlist.service.lambda.GetPlaylistSongsActivityProvider::handleRequest

public class GetPlaylistSongsActivityProvider implements RequestHandler<GetPlaylistSongsRequest,
        GetPlaylistSongsResult> {

    ServiceComponent sc = DaggerServiceComponent.create();

    /**
     * Empty constructor for the lambda function.
     */
    public GetPlaylistSongsActivityProvider() {
    }

    /**
     * @param getPlaylistSongsRequest the input object
     * @param context the Lambda context
     * @return the output object
     */
    @Override
    public GetPlaylistSongsResult handleRequest(final GetPlaylistSongsRequest getPlaylistSongsRequest,
                                                Context context) {
        return sc.provideGetPlaylistSongsActivity().handleRequest(getPlaylistSongsRequest,
                context);
    }

}


