package MyShop.entity;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "orders")
@DynamicUpdate
@DynamicInsert
@EqualsAndHashCode(of = "id")

public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @NotNull
    private String  created;

    public long getId() {
        return id;
    }

    public Orders(Account account) {
        this.account = account;
    }

    public String getCreated() {
        return created;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setCreated(String created) {
        this.created = created;
    }

    public Orders(int id) {
        this.id = id;
    }

    public Orders(){

    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", accountId=" + account.getId() +
                ", created=" + created +
                '}';
    }
}
