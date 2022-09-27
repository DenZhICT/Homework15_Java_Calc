package guru.qa.db.impl;

import guru.qa.db.CarEntityRowMapper;
import guru.qa.db.CarRepository;
import guru.qa.db.DataSourceProvider;
import guru.qa.entity.CarEntity;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;

import java.util.List;

public class PostgresCarRepository implements CarRepository {

    private static final JdbcTemplate tamplate =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    @Override
    public List<CarEntity> getAll() {
        return tamplate.query("SELECT * FROM cars", new CarEntityRowMapper());
    }

    @Override
    public @Nullable
    CarEntity getByName(String carName) {
        try {
            return tamplate.queryForObject("SELECT * FROM cars WHERE name = ?", new CarEntityRowMapper(), carName);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
