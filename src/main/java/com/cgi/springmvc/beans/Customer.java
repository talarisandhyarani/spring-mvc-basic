package com.cgi.springmvc.beans;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="Customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Nullable
    @Column(name = "address")
    private String address;

    @Nullable
    @Column(name = "phoneNumber")
    private String phoneNumber;
}