package co.ias.bootcamp.springworkshop.repositories;

import co.ias.bootcamp.springworkshop.domain.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class KeysRepository {

    //

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public KeysRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Key> findAllKeys() {

        return jdbcTemplate.query("SELECT * FROM KEYS", new RowMapper<Key>() {
            @Override
            public Key mapRow(ResultSet resultSet, int i) throws SQLException {
                String id = resultSet.getString("ID");
                String name = resultSet.getString("KEY_NAME");
                String value = resultSet.getString("KEY_VALUE");
                return new Key(id, name, value);
            }
        });
    }
}
