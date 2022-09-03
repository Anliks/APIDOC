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
@Table(name="product_setting")
public class ProductSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn( name = "number_id", referencedColumnName = "id")
    @JsonProperty("number_id")
    private NumberOfProduct numberId;
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    @JsonProperty("store_id")
    private NumberOfStore storeId;
    @ManyToOne
    @JoinColumn(name = "products_list" , referencedColumnName = "id")
    @JsonProperty("products_list")
    private ProductsList productsListId;

    public ProductSetting(NumberOfProduct numberId, NumberOfStore storeId, ProductsList productsListId) {
        this.numberId = numberId;
        this.storeId = storeId;
        this.productsListId = productsListId;
    }
}
