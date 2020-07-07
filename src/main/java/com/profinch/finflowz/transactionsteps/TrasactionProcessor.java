package com.profinch.finflowz.transactionsteps;

import com.profinch.finflowz.model.ReportigTable;
import com.profinch.finflowz.model.TransactionDetails;
import com.profinch.finflowz.repository.ReportingRepo;
import com.profinch.finflowz.repository.TransactionDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;

@Configuration
public class TrasactionProcessor implements ItemProcessor<TransactionDetails, TransactionDetails> {

    private Logger log = LoggerFactory.getLogger(TrasactionProcessor.class);

    @Autowired
    private ReportingRepo reportingRepo;

    @Override
    public TransactionDetails process(TransactionDetails transactionDetails) throws Exception {
        log.debug("Workflow Processor before  :{} {}{}",transactionDetails.getTransactionReferanceNumber(),transactionDetails.getReplicationStatus());
        ReportigTable reportigTable=new ReportigTable();
        reportigTable.setAmount(transactionDetails.getAmount());
        reportigTable.setReplicationstatus(transactionDetails.getReplicationStatus());
        reportigTable.setApplicationStatus(transactionDetails.getApplicationStatus());
        reportigTable.setTransactionReferanceNumber(transactionDetails.getTransactionReferanceNumber());

        reportingRepo.save(reportigTable);

        return transactionDetails;

    }
}
