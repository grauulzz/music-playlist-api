package com.amazon.ata.music.playlist.service.dependency;

public class DaoSelector {

    private final ServiceComponent component;

    // don't know if this is necessary
    DaoSelector(DaoModule daoModule) {
        component = DaggerServiceComponent.builder().daoModule(daoModule)
                .build();
    }
}
