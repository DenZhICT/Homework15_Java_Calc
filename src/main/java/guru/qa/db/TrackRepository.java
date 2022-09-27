package guru.qa.db;

import guru.qa.entity.TrackEntity;

import java.util.List;

public interface TrackRepository {

    List<TrackEntity> getAll();

    TrackEntity getByName(String trackName);
}
