package cz.upce.cv04.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;

    @Column()
    private String email;

    @Column()
    private String password;
    
    @OneToMany(mappedBy = "id")
    private Set<UserHasProfile> userProfile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserHasProfile> getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(Set<UserHasProfile> userProfile) {
        this.userProfile = userProfile;
    }
}
