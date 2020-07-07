package com.profinch.finflowz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
@Setter
@Getter
@Table(name = "reportingT_devTTT")
public class ReportigTable {
@Id
    private String transactionReferanceNumber;
    private Long amount;
    private String replicationstatus;
    private String applicationStatus;

    @Override
    public String toString() {
        return "ReportigTable{" +
                "transactionReferanceNumber='" + transactionReferanceNumber + '\'' +
                ", amount=" + amount +
                ", replicationstatus=" + replicationstatus +
                ", applicationStatus=" + applicationStatus +
                '}';
    }
}
