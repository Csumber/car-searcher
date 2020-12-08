package hu.bme.vik.ambrustorok.authserver.service;

import hu.bme.vik.ambrustorok.authserver.service.dto.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
@RequestMapping
@AllArgsConstructor
public class AuthController {

    @Autowired
    private final DataSource dataSource;

    @PostMapping("/register")
    public ResponseEntity<String> getRecommendation(@RequestBody UserRequest userRequest) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt;
        try {
            con = dataSource.getConnection();
            pstmt = con.prepareStatement("INSERT INTO USERS (username, password, enabled) " +
                    "VALUES (?, ?, ?) ");
            pstmt.setString(1, userRequest.getUsername());
            pstmt.setString(2, userRequest.getUsername());
            pstmt.setBoolean(3, userRequest.isEnabled());

            pstmt.executeUpdate();
            con.commit();
            pstmt.close();

        } catch (Exception e) {
        } finally {
            if (con != null) con.close();
        }
        return ResponseEntity.ok().build();
    }

}
