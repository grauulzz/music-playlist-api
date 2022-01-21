//package com.amazon.ata.music.playlist.service.dependency;
//
//import com.amazon.ata.music.playlist.service.dynamodb.AlbumTrackDao;
//import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
//
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//public class ServiceCreator {
//
//
//
//    Set<PlaylistDao> services = new HashSet<>();
//    public void addService(PlaylistDao playlistDao) {
//        services.add(playlistDao);
//    }
//
//
//
//    public void makeAnyConfiguration() {
//        //...creatively combine Lego to existing creation
//    }
//
//    public static void main(String[] args) {
//        ServiceComponent component = DaggerServiceComponent.create();
//        ServiceCreator creator = new ServiceCreator();
//
//        creator.addService(component.getPlaylistDao());
//    }
//}






//    private static final Map<Class<?>, Object> services = new HashMap<>();
//
//static {
//        services.put(AlbumTrackDao.class, new AlbumTrackDao());
//        services.put(PlaylistDao.class, new PlaylistDao());
//        }
//
//public static <T> T getService(Class<T> serviceClass) {
//        return (T) services.get(serviceClass);
//        }
//
//public static Set<Class<?>> getAllServices() {
//        return new HashSet<>(services.keySet());
//        }










//Map<PlaylistDao, AlbumTrackDao> daoMap = new HashMap<>();
//
//    public void addDao(PlaylistDao playlistDao, AlbumTrackDao albumTrackDao) {
//        daoMap.put(playlistDao, albumTrackDao);
//    }
//
//    public PlaylistDao getPlaylistDao() {
//        return daoMap.keySet().iterator().next();
//    }