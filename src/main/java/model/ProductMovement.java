package model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="product_movement")
public class ProductMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "number_id", referencedColumnName = "id")
    @JsonProperty("number_id")
    private NumberOfProduct numberId;

    @ManyToOne
    @JoinColumn(name = "departure_store_id", referencedColumnName = "id")
    @JsonProperty("departure_store_id")
    private  NumberOfStore departureStoreId;

    @ManyToOne
    @JoinColumn(name = "catcher_store_id", referencedColumnName = "id")
    @JsonProperty("catcher_store_id")
    private  NumberOfStore catcherStoreId;

    @ManyToOne
    @JoinColumn(name ="list_of_product_id", referencedColumnName = "id")
    @JsonProperty("list_of_product_id")
    private ProductsList productsListId;

}
