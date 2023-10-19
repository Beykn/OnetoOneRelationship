package onetoonerelation.onetoone.entity;

import jakarta.persistence.*;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "up_id")

    private UserProfile userProfile;

    public User() {

    }

    //    In Spring Boot entity classes, you often do not include the id parameter in the constructor because the id field is typically managed by the underlying JPA (Java Persistence API) framework.
//    JPA will automatically generate and assign values to the id field, such as auto-incremented primary keys in a database.
//    Including the id field in the constructor and trying to set its value manually would interfere with JPA's management of entity IDs.
    public User(String name, String email, UserProfile userProfile) {
        this.name = name;
        this.email = email;
        this.userProfile = userProfile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
