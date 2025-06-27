package airport.data;

import airport.domain.model.Passenger;
import airport.domain.reservation.ReservationSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CSVUtilTest {
    static final String SEED_FILE_PATH = "./data/reservations-seed.txt";
    static final String TEST_FILE_PATH = "./data/reservations-test.txt";

    CSVUtil csv = new CSVUtil(TEST_FILE_PATH);

    @BeforeEach
    void setupTest() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void findAll() throws DataAccessException {
        HashMap<String, ArrayList<Passenger>> actual = csv.loadReservationsFromCSV(SEED_FILE_PATH);
        System.out.println(actual);
        assertEquals(3, actual.size());
    }
}