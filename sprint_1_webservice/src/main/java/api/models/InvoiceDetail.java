package api.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "invoice_detail")
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @ManyToOne()
    @JoinColumn(name = "invoice_id", nullable = false, referencedColumnName = "id")
    private Invoice invoice;

//    @OneToMany(mappedBy = "")
//    private Product product;

//    @ManyToOne
//    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
//    private Product product;

//    @ManyToOne
//    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
//    private Customer customer;

}
