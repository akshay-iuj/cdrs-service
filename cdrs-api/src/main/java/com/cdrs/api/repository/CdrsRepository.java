package com.cdrs.api.repository;
import com.cdrs.parser.models.CdrsDbDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdrsRepository extends JpaRepository<CdrsDbDetails, Long> {
}
