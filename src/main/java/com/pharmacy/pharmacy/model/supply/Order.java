package com.pharmacy.pharmacy.model.supply;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medi_order")
public class Order {
    @Id
    private String id;
    private String itemCode;
    private String description;
    private long quantity;
    private String patient;
    private String bht;
    private String urgentLevel;
    private Integer urgentRep;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Colombo")
    private Date orderTime;
    private Integer status;
    private boolean readStatus;
}
