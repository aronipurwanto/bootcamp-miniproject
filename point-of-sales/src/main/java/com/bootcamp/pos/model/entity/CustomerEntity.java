package com.bootcamp.pos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_customer")
public class CustomerEntity {
    @Id
    @TableGenerator(name = "tbl_customer_seq",
            table = "tbl_sequence",
            pkColumnName = "sequence_id",
            valueColumnName="sequence_value",
            pkColumnValue = "customer_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_customer_seq")
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_method_id", insertable = false, updatable = false)
    private RefPaymentMethod paymentCode;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AddressEntity> address = new ArrayList<>();

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_phone")
    private Integer customerPhone;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "date_customer")
    private Date dateCustomer;

    @Column(name = "payment_details")
    private String paymentDetails;

    @Column(name = "other_details")
    private String otherCustomerDetails;

}
