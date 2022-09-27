package guru.qa.db.impl;

import guru.qa.db.DataSourceProvider;
import guru.qa.db.TrackEntityRowMapper;
import guru.qa.db.TrackRepository;
import guru.qa.entity.TrackEntity;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;

import java.util.List;

public class PostgresTrackRepository implements TrackRepository {

    private static final JdbcTemplate tamplate =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    @Override
    public List<TrackEntity> getAll() {
        return tamplate.query("SELECT * FROM tracks", new TrackEntityRowMapper());
    }

    @Override
    public @Nullable
    TrackEntity getByName(String trackName) {
        try {
            return tamplate.queryForObject("SELECT * FROM tracks WHERE name = ?", new TrackEntityRowMapper(), trackName);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
