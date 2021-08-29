package com.cdrs.api.repository;
import com.cdrs.api.models.CdrsDbDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CdrsRepository extends JpaRepository<CdrsDbDetails, Long> {
    List<CdrsDbDetails> findAll();

    @Query(value="select * from cdrs_details c where c.service_type =1 and date_format(c.start_datetime,'%Y-%m-%d') = :inputDate", nativeQuery = true)
    List<CdrsDbDetails> getTotalDurationPerDay(@Param("inputDate") String inputDate);

    @Query(value="select * from cdrs_details c where c.service_type =3 and date_format(c.start_datetime,'%Y-%m-%d') = :inputDate", nativeQuery = true)
    List<CdrsDbDetails> getTotalVolumePerDay(@Param("inputDate") String inputDate);


    @Query(value="SELECT o.* FROM cdrs_details o LEFT JOIN cdrs_details b ON date_format(o.start_datetime,'%Y-%m-%d') = date_format(b.start_datetime,'%Y-%m-%d') AND o.charge < b.charge WHERE b.charge is NULL", nativeQuery = true)
    List<CdrsDbDetails> getHighestChargePerDayByANUM();

    @Query(value="SELECT * FROM cdrs_details t where t.service_type = 1 ORDER BY t.used_amount DESC LIMIT 1", nativeQuery = true)
    CdrsDbDetails getLongestDurationANUM();

    @Query(value="SELECT sum(t.actual_used_amount) ,sum(t.used_amount*60),sum(t.charge) ,t.file_name FROM cdrs_details t where t.service_type = 1 group by t.file_name", nativeQuery = true)
    List<Object[]> getTotalDurationForEachCallCategoryForVoice();


    @Query(value="SELECT sum(t.actual_used_amount) ,sum(t.used_amount*1024),sum(t.charge) ,date_format(t.start_datetime,'%Y-%m-%d') FROM cdrs_details t where t.service_type = 3 group by date_format(t.start_datetime,'%Y-%m-%d')", nativeQuery = true)
    List<Object[]> getTotalVolumeForEachSubscriberTypeForGPRS();
}
