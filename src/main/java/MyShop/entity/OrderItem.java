package MyShop.entity;

import com.sun.istack.internal.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_item")
@DynamicUpdate
@DynamicInsert
@EqualsAndHashCode(of = "id")
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Orders order;

    @NotNull
    private long count;


    public OrderItem(Product product, Orders order, long count) {
        this.product = product;
        this.order = order;
        this.count = count;
    }

    public OrderItem() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Orders getOrder() {
        return order;
    }

    public long getCount() {
        return count;
    }
}
