package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }



    public List<String> getDogsByCountry(String country) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT name, country FROM dog_types WHERE country = ? ORDER BY name");
        ) {
            ps.setString(1, country);
            List<String> dogs = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    dogs.add(rs.getString("name").toLowerCase());
                }
            }
            return dogs;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select country", se);
        }
   }
}

