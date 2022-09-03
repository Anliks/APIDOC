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
@Table(name="number_of_store")
public class NumberOfStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty("id")
    private int id;
    @Column(name = "store_name")
    @JsonProperty("store_name")
    private String storeName;

    public NumberOfStore(String storeName) {
        this.storeName = storeName;
    }
}
