package com.profinch.finflowz.repository;

import com.profinch.finflowz.model.ReportigTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportingRepo extends JpaRepository<ReportigTable,String> {
}
