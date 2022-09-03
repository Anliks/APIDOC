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
@Table(name="store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "amount")
    @JsonProperty("amount")
    private int amount;
    @ManyToOne
    @JoinColumn(name = "product_id" , referencedColumnName = "id")
    @JsonProperty("product_id")
    private Product productId;
    @ManyToOne
    @JoinColumn(name = "store_id" , referencedColumnName = "id")
    @JsonProperty("store_id")
    private NumberOfStore numberOfStoreId;




}
