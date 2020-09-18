package MyShop.entity;

import com.sun.istack.internal.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@DynamicUpdate
@DynamicInsert
@EqualsAndHashCode(of = "id")
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "id_product")
    private long IdProduct;

    @NonNull
    @Column(name = "id_order")
    private long IdOrder;

    @NotNull
    private long count;

}
