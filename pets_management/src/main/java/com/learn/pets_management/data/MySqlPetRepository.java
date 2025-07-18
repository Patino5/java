package com.learn.pets_management.data;

import com.learn.pets_management.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class MySqlPetRepository implements PetRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Pet> getAll() {
        final String sql = "SELECT * FROM pet;";
        try {
            return jdbc.query(sql, petRowMapper());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());; // log exception details
        }

        return List.of();
    }

    @Override
    public Optional<Pet> getById(int pet_id) {
        String sql = "SELECT * FROM pet WHERE pet_id = ?;";

        try {
            Pet pet = jdbc.queryForObject(sql, petRowMapper(), pet_id);
            return Optional.of(pet);
        } catch (Exception ex) {
            System.out.println(ex.getMessage()); // log exception details
        }
        return Optional.empty();
    }


    @Override
    public Pet add(Pet pet) {
        final String sql = "INSERT INTO pet (name, type) VALUES (?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        try {
            int rowsAffected = jdbc.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, pet.getName());
                ps.setString(2, pet.getType());

                return ps;
            }, keyHolder);

            if (rowsAffected <= 0) {
                return null;
            }
            pet.setPetID(keyHolder.getKey().intValue());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return pet;
    }

    @Override
    public boolean update(Pet pet) {
        final String sql = "UPDATE pet SET name = ?, type = ? WHERE pet_id = ?;";

        try {
            int rowsAffected = jdbc.update(sql,
                    pet.getName(),
                    pet.getType(),
                    pet.getPetID());

                return rowsAffected > 0;

        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(int petID) {
        final String sql = "DELETE FROM pet WHERE pet_id = ?;";

        try {
            int rowsAffected = jdbc.update(sql, petID);
            return rowsAffected > 0;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private RowMapper<Pet> petRowMapper() {
        return (rs, rowNum) -> {
            Pet pet = new Pet();
            pet.setPetID(rs.getInt("pet_id"));
            pet.setName(rs.getString("name"));
            pet.setType(rs.getString("type"));

            return pet;
        };
    }
}
