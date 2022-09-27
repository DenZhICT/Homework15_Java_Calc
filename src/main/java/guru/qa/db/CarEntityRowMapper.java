package guru.qa.db;

import guru.qa.entity.CarEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarEntityRowMapper implements RowMapper<CarEntity> {
    @Override
    public CarEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CarEntity()
                .setName(rs.getString("name"))
                .setFuelEconomy(rs.getDouble("fuel_economy"))
                .setFuelCapacity(rs.getInt("fuel_capacity"));
    }
}
