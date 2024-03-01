package com.system.futsal_management_system.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @SequenceGenerator(name = "shb_product_seq_gen", sequenceName = "shb_product_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "shb_product_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer bookId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_User_Id"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_id", referencedColumnName = "fut_salId",
            foreignKey = @ForeignKey(name = "FK_Futsal_Id"))
    private Futsal futsal;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    private String starting;
    private String email;

}
