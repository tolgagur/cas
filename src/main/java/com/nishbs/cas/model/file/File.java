package com.nishbs.cas.model.file;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nishbs.cas.model.customer.Customer;
import com.nishbs.cas.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long fileId;
    @NotBlank(message = "File Name not empty or null")
    private String fileName;
    private Instant createdDate;
    private Long customerId;

//    @ManyToOne
//    @JoinColumn(name="cart_id", nullable=false)
//    private Customer cart;

}
