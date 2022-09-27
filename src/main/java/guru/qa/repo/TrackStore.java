package guru.qa.repo;

import guru.qa.db.TrackRepository;
import guru.qa.db.impl.PostgresTrackRepository;
import guru.qa.entity.TrackEntity;

import java.util.List;

public class TrackStore {
    private TrackRepository trackRepository = new PostgresTrackRepository();

    public TrackEntity lookup(String trackName) {
        TrackEntity someTrack = trackRepository.getByName(trackName.toLowerCase());
        if (someTrack != null) {
            return someTrack;
        } else {
            throw new IllegalArgumentException("Car not found for given name: " + trackName);
        }
    }

    public String[] getTracks() {
        List<TrackEntity> tracks = trackRepository.getAll();
        String[] tracksName = new String[tracks.size()];
        for (int i = 0; i < tracks.size(); i++) {
            String oneOfCars = tracks.get(i).getName();
            tracksName[i] = oneOfCars.substring(0, 1).toUpperCase() + oneOfCars.substring(1);
        }
        return tracksName;
    }
}
