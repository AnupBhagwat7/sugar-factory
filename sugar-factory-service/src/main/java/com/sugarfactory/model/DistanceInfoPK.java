package com.sugarfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistanceInfoPK implements Serializable {

    @Column(name = "VYEAR_CODE")
    protected String yearCode;
    @Column(name = "NSLIP_NO")
    protected Integer slipNo;

    /*public DistanceInfoPK(String yearCode, Integer slipNo) {
        this.yearCode = yearCode;
        this.slipNo = slipNo;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistanceInfoPK that = (DistanceInfoPK) o;
        return Objects.equals(yearCode, that.yearCode) &&
                Objects.equals(slipNo, that.slipNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(yearCode, slipNo);
    }
}
