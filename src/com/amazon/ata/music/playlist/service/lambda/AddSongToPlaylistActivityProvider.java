package com.amazon.ata.music.playlist.service.lambda;

import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.dependency.ServiceComponent;
import com.amazon.ata.music.playlist.service.models.requests.AddSongToPlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.AddSongToPlaylistResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

// com.amazon.ata.music.playlist.service.lambda.AddSongToPlaylistActivityProvider::handleRequest

public class AddSongToPlaylistActivityProvider implements RequestHandler<AddSongToPlaylistRequest,
        AddSongToPlaylistResult> {

    ServiceComponent sc = DaggerServiceComponent.create();


    /**
     * empty constructor for the lambda function.
     */
    public AddSongToPlaylistActivityProvider() {
    }

    /**
     * @param addSongToPlaylistRequest the input to the lambda function
     * @param context the context of the lambda function
     * @return  the result of the lambda function
     */
    @Override
    public AddSongToPlaylistResult handleRequest(final AddSongToPlaylistRequest addSongToPlaylistRequest,
                                                 Context context) {
        return sc.provideAddSongToPlaylistActivity().handleRequest(addSongToPlaylistRequest,
                context);

    }

}

