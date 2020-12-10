package com.sugarfactory.repository;

import com.sugarfactory.model.DistanceInfo;
import com.sugarfactory.model.DistanceInfoPK;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
//@Profile("admissions")
public interface DistanceRepository extends JpaRepository<DistanceInfo, DistanceInfoPK> {


    @Modifying
    @Query("Update DistanceInfo d SET d.actualDistance =:actualDistance, d.status =:status  WHERE d.distancePK=:distancePK ")
    public void updateDistance(@Param("distancePK") DistanceInfoPK distancePK, @Param("actualDistance") int actualDistance, @Param("status") String status);

    DistanceInfo getDistanceBySlipNum(int slipNum);
}