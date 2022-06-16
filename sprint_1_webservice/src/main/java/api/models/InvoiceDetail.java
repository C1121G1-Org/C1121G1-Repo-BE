
package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "invoice_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @ManyToOne()
    @JoinColumn(name = "invoice_id", nullable = false, referencedColumnName = "id")
    private Invoice invoice;

    @ManyToOne()
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    private Product product;


}
