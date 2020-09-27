package MyShop.entity;

import MyShop.model.CurrentAccount;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "account")
@EqualsAndHashCode(of = "id")
public class Account implements Serializable, CurrentAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String email;


    @Override
    public String getDescription() {
        return name + "   <span class=\"label label-success\">"+ email +"</span>"+"   ";
    }

    @Override
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Account(@NonNull String name, @NonNull String email) {
        this.name = name;
        this.email = email;
    }

    public Account() {
    }
}
