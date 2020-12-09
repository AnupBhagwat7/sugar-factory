package com.sugarfactory.nirabhima1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="COM_WEIGHT_SLIP_DIST")
public class DistanceInfo
{
    @EmbeddedId
    private DistanceInfo distancePK;

    @Column(name = "NSHIFT_NO")
    private Integer shiftNumber;
    @Column(name = "DSLIP_DATE")
    private Date slipDate;
    @Column(name = "NPLOT_NO")
    private Integer plotNumber;
    @Column(name = "NTOKEN_NO")
    private Integer token;
    @Column(name = "NDISTANCE")
    private Integer distance;
    @Column(name = "NVEHICLE_TYPE")
    private Integer vehicleType;
    @Column(name = "NHARVESTOR_CODE")
    private Integer harvestorCode;
    @Column(name = "NTRANSPORTOR_CODE")
    private Integer transporterCode;
    @Column(name = "VVEHICLE_NO")
    private String vehicleNumber;
    @Column(name = "NBULLUCKCART_CODE")
    private Integer bulluckcartCode;
    @Column(name = "NBULLUCKCART_MAIN_CODE")
    private Integer bulluckcartMainCode;
    @Column(name = "DCREATE_DATE")
    private Date createDate;
    @Column(name = "DUPDATE_DATE")
    private Date udateDate;
    @Column(name = "NDISTANCEACTUAL")
    private Integer actualDistance;
    @Column(name ="NSTATUS")
    private String status;


}