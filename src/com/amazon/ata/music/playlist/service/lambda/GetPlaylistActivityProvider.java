package com.amazon.ata.music.playlist.service.lambda;

import com.amazon.ata.music.playlist.service.models.requests.GetPlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.GetPlaylistResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import static com.amazon.ata.music.playlist.service.dependency.ComponentSelector.daggerGetPlaylistActivity;

// TODO: these provider classes are the entry points for aws lambda
public class GetPlaylistActivityProvider implements RequestHandler<GetPlaylistRequest, GetPlaylistResult> {

    public GetPlaylistActivityProvider() {}

    @Override
    public GetPlaylistResult handleRequest(final GetPlaylistRequest getPlaylistRequest, Context context) {
        return daggerGetPlaylistActivity().handleRequest(getPlaylistRequest,
                context);
    }
}
