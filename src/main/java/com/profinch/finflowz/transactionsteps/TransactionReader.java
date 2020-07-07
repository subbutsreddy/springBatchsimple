package com.profinch.finflowz.transactionsteps;


import com.profinch.finflowz.model.TransactionDetails;
import com.profinch.finflowz.repository.TransactionDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.List;

@Configuration
public class TransactionReader implements ItemReader<TransactionDetails> {

    /*@Value("${spring.replicationStatus}")
    private String replicationStatus ;
    @Value("${spring.transactionStatus}")
    private String transactionStatus;*/
    private Logger log = LoggerFactory.getLogger(TransactionReader.class);

    private TransactionDetailsRepo transactionDetailsRepo;


    public TransactionReader(TransactionDetailsRepo transactionDetailsRepo) {
        this.transactionDetailsRepo = transactionDetailsRepo;
    }

    @Override
    public TransactionDetails read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        List<TransactionDetails> transactionDetails = transactionDetailsRepo.findByApplicationStatusAndReplicationStatus("UNPROCESSED","PROCESSED");


        for (TransactionDetails details : transactionDetails) {

            return details;

        }

        return null;
    }
}
