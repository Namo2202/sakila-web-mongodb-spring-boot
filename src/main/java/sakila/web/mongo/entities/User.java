package sakila.web.mongo.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(value = "users")
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    @ToString.Exclude
    private byte[] picture;
    private Date dateCreation;
    private Boolean activated;

}
