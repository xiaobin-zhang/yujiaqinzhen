package com.yjqz.binge.batch.xml.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
public class IbCustomerProduct implements Serializable {
	private static final long serialVersionUID = 244350752925607100L;

	public static final String TABLE_NAME = "IB_CUSTOMER_PRODUCT";

    @Id
    @Column(name="PRODUCT_CUSTOMER_NO", nullable=false, length=21)
    private String productCustomerNo;

    @Column(name="CUST_ID", nullable=false)
    private Integer custId;

    @Temporal(value=TemporalType.DATE)
    @Column(name="BIZ_DATE", nullable=false)
    private Date bizDate;

    @Column(name="ACCOUNT_NO", nullable=false)
    private Integer accountNo;

    @Column(name="PRODUCT_CODE", nullable=false, length=30)
    private String productCode;

    @Column(name="PRODUCT_NAME", nullable=true, length=80)
    private String productName;
    
    @Column(name="JPA_VERSION", nullable=false)
    @Version
    private Integer jpaVersion;
}