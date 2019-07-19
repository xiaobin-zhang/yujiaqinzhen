package com.yjqz.binge.batch.xml.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name= "CUSTOMER")
public class Customer implements Serializable {
	private static final long serialVersionUID = 244350752925607100L;

    @Id
    @GeneratedValue(generator="GEN_CUSTOMER")
    @GenericGenerator(name="GEN_CUSTOMER", strategy="native")
    @Column(name="SEQ_ID", nullable=false)
    private Integer seqId;

    @Column(name="CUST_ID", nullable=false)
    private Integer custId;
    
    @Column(name="FLAG_ID", nullable=false)
    private Integer flagId;

    @Column(name="JPA_VERSION", nullable=true)
    @Version
    private Integer jpaVersion;

	public Integer getSeqId() {
		return seqId;
	}

	public void setSeqId(Integer seqId) {
		this.seqId = seqId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Integer getCustId() {
		return custId;
	}

	public Integer getJpaVersion() {
		return jpaVersion;
	}

	public void setJpaVersion(Integer jpaVersion) {
		this.jpaVersion = jpaVersion;
	}

	public Integer getFlagId() {
		return flagId;
	}

	public void setFlagId(Integer flagId) {
		this.flagId = flagId;
	}
    
}