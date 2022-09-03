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
@Table(name="sale_of_product")
public class SaleOfProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "number_id" , referencedColumnName = "id")
    @JsonProperty("number_id")

    private NumberOfProduct numberId;
    @ManyToOne
    @JoinColumn(name = "store_id" , referencedColumnName = "id")
    @JsonProperty("store_id")
    private NumberOfStore storeId;
    @ManyToOne
    @JoinColumn(name = "list_of_product_id" , referencedColumnName = "id")
    @JsonProperty("list_of_product_id")
    private ProductsList listOfProductId;
}
