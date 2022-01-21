package com.amazon.ata.music.playlist.service.dependency;

public class DaoSelector {

    private final ServiceComponent component;

    DaoSelector(DaoModule daoModule) {
        component = DaggerServiceComponent.builder().daoModule(daoModule).build();
    }
}
