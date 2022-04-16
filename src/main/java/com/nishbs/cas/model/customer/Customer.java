package com.nishbs.cas.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nishbs.cas.model.file.File;
import com.nishbs.cas.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @NotBlank(message = "Customer name is not null")
    private String customerName;
    @NotBlank(message = "İnfo is not null")
    private String info;
    private Instant createdDate;
    private Long createdUser;
//    @OneToMany(mappedBy="cart")
//    private Set<File> items;
}
