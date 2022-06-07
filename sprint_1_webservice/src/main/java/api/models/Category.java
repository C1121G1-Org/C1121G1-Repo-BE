package api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name", length = 255)
    private String name;

    @Column(name = "category_image", columnDefinition = "LONGTEXT")
    private String image;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private Set<Product> productSet;
}




