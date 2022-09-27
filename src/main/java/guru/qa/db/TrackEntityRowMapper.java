package guru.qa.db;

import guru.qa.entity.TrackEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackEntityRowMapper implements RowMapper<TrackEntity> {
    @Override
    public TrackEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TrackEntity()
                .setName(rs.getString("name"))
                .setLaps(rs.getInt("laps"))
                .setLapDistance(rs.getInt("lap_distance"));
    }
}
