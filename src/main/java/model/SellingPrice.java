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
@Table(name="selling_price")
public class SellingPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty("id")
    private int id;
    @Column(name = "price")
    @JsonProperty("price")
    private int price;

    public SellingPrice(int price) {
        this.price = price;
    }
}
