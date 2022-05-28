package api.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time", nullable = false, length = 50)
    private String createTime;
    @Column(name = "create_date", nullable = false, length = 50)
    private String createDate;
    @Column(name = "total_money", nullable = false)
    private Double totalMoney;
    @Column(name = "payments", nullable = false, length = 50)
    private String payments;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    private Customer customer;

//    @OneToOne
//    @JoinColumn(name = "invoiceDetail_id", nullable = false, referencedColumnName = "id")
//    private InvoiceDetail invoiceDetail;

    @OneToMany(mappedBy = "invoice")
    private Set<InvoiceDetail> invoiceDetailSet;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    private Product product;

}
