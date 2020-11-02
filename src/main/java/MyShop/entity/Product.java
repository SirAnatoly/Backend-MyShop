package MyShop.entity;

import com.sun.istack.internal.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "product")
@RequiredArgsConstructor
@DynamicUpdate
@DynamicInsert
@EqualsAndHashCode(of = "id")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private String image_link;

    @NotNull
    private double price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_producer")
    private Producer producer;

    public Product(@NonNull String name, @NonNull String description, @NonNull String image_link, double price, Category category, Producer producer) {
        this.name = name;
        this.description = description;
        this.image_link = image_link;
        this.price = price;
        this.category = category;
        this.producer = producer;
    }

    public Product() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage_link() {
        return image_link;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Producer getProducer() {
        return producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image_link='" + image_link + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", producer=" + producer +
                '}';
    }
}
