package com.sim.SimApi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Record {

    @Id
    @Column(name = "SIM_CARD_NO")
    private Integer simCardNo;

    @Column(name = "MOBILE_NO")
    private Integer mobileNo;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "EXPIRY_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date expiryDate;

    @Column(name = "STATE_OF_REGISTRATION")
    private String stateOfRegistration;

    @Column(name = "KYC")
    private Boolean kyc;

    @Column(name = "TELECOM_PROVIDER")
    private String telecomProvider;

    @Column(name = "FULL_NAME")
    private String fullName;
}
