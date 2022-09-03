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
@Table(name="list_of_product")
public class ProductsList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty("id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "selling_price_id", referencedColumnName = "id")
    @JsonProperty("selling_price_id")
    private SellingPrice sellingPriceId;
    @ManyToOne
    @JoinColumn(name = "purchase_price_id", referencedColumnName = "id")
    @JsonProperty("purchase_price_id")
    private PurchasePrice purchasePriceId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonProperty("product_id")
    private Product productId;
    @Column(name = "quantity")
    private int quantity;

    public ProductsList(SellingPrice sellingPriceId, PurchasePrice purchasePriceId, Product productId, int quantity) {
        this.sellingPriceId = sellingPriceId;
        this.purchasePriceId = purchasePriceId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
