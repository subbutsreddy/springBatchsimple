package com.profinch.finflowz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;


@Getter
@Setter
@Entity
@Table(name = "transaxss_devTT")
public class TransactionDetails {
	@Id
    private String transactionReferanceNumber;
	private Long amount;
	private String replicationStatus;
    private String applicationStatus;


}