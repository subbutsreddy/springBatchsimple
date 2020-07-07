package com.profinch.finflowz.transactionsteps;


import com.profinch.finflowz.model.TransactionDetails;
import com.profinch.finflowz.repository.ReportingRepo;
import com.profinch.finflowz.repository.TransactionDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TrasactionWriter implements ItemWriter<TransactionDetails> {

    private Logger log = LoggerFactory.getLogger(TrasactionWriter.class);

    private TransactionDetailsRepo transactionDetailsRepo;


    public TrasactionWriter(TransactionDetailsRepo transactionDetailsRepo) {
        this.transactionDetailsRepo = transactionDetailsRepo;
    }

    @Override
    public void write(List<? extends TransactionDetails> list) throws Exception {

        for (TransactionDetails transactionDeta : list) {
            transactionDeta.setReplicationStatus("Completed");
            log.debug("Workflow Processor before  :{} {}{}",transactionDeta.getTransactionReferanceNumber(),transactionDeta.getReplicationStatus());
            transactionDetailsRepo.save(transactionDeta);
        }
    }
}
