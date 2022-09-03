package model;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="number_of_product")
public class NumberOfProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "number")
    @NonNull
    private int number;

    public NumberOfProduct(@NonNull int number) {
        this.number = number;
    }
}
