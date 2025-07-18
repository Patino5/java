package pets.data;

import javax.sql.DataSource;
// NEW: required imports
import pets.models.Pet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;


public class PetJdbcRepository {

    // 1. Dangerous initialization during construction
    private DataSource dataSource = initDataSource();
    private DataSource initDataSource() {
        MysqlDataSource result = new MysqlDataSource();

        try {
            Properties props = new Properties();
            try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
                if (input == null) {
                    throw new FileNotFoundException("db.properties not found in classpath");
                }
                props.load(input);
            }

            result.setUrl(props.getProperty("db.url"));
            result.setUser(props.getProperty("db.user"));
            result.setPassword(props.getProperty("db.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Failed to load DB configuration", ex);
        }

        return result;
    }


    public List<Pet> findAll() {
        ArrayList<Pet> result = new ArrayList<>();
        final String sql = "select pet_id, `name`, `type` from pet;";
        // 1. Ask the DataSource for a Connection - try with resources
        try (Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            // A statement executes a SQL query
            ResultSet rs = statement.executeQuery(sql)) {
        // Process a row at a time until there are no more...
                while (rs.next()) {
                    Pet pet = new Pet();
                    // column values are for the current row.
                    pet.setPetId(rs.getInt("pet_id"));
                    pet.setName(rs.getString("name"));
                    pet.setType(rs.getString("type"));
                    result.add(pet);
                }
            } catch (SQLException ex) {
            // 2. SQL classes have many checked exceptions.
            ex.printStackTrace();
        }
        return result;
    }

    public Pet findById(int petId) {
        // The '?' placeholder requires a value.
        final String sql = "select pet_id, `name`, `type` from pet where pet_id = ?;";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            // Replace the first '?' with petId.
            statement.setInt(1, petId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Pet pet = new Pet();
                    pet.setPetId(rs.getInt("pet_id"));
                    pet.setName(rs.getString("name"));
                    pet.setType(rs.getString("type"));
                    return pet;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Pet add(Pet pet) {
        final String sql = "insert into pet (`name`, `type`) values (?, ?);";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getType());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted <= 0) {
                return null;
            }
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    pet.setPetId(keys.getInt(1));
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pet;
    }
    public boolean update(Pet pet) {
        final String sql = "update pet set "
                + "`name` = ?, "
                + "`type` = ? "
                + "where pet_id = ?;";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getType());
            statement.setInt(3, pet.getPetId());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteById(int petId) {
        final String sql = "delete from pet where pet_id = ?;";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, petId);
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}