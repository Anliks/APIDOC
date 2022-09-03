package model;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty("id")
    private int id;
    @Column(name = "article")
    @JsonProperty("article")
    private String article;

    @Column(name = "product_name")
    @JsonProperty("product_name")
    private String name;

    @Column(name = "last_purchase_price")
    @JsonProperty("last_purchase_price")
    private int lastPurchasePrice;

    @Column(name = "last_sales_price")
    @JsonProperty("last_sales_price")
    private int lastSalesPrice;

    public Product(String article, String name, int lastPurchasePrice, int lastSalesPrice) {
        this.article = article;
        this.name = name;
        this.lastPurchasePrice = lastPurchasePrice;
        this.lastSalesPrice = lastSalesPrice;
    }
}
