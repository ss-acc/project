package com.soap.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="card")
public class Card implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cardno")
	private long cardno;
	
	@Column(name = "cardholdername")
	private String cardholdername;
	
	@Column(name = "cardbalance")
	private double cardbalance;
	
	@Column(name = "cardissueddate")
	private String cardissueddate;
	
	@Column(name = "cardexpirydate")
	private String cardexpirydate;
	
	
	@Column(name = "cardstatus")
	private String cardstatus;
	
	@Column(name = "bankid")
	private short bankid;
	
	public long getCardno() {
		return cardno;
	}

	public void setCardno(long cardno) {
		this.cardno = cardno;
	}

	public String getCardholdername() {
		return cardholdername;
	}

	public void setCardholdername(String cardholdername) {
		this.cardholdername = cardholdername;
	}

	public double getCardbalance() {
		return cardbalance;
	}

	public void setCardbalance(double cardbalance) {
		this.cardbalance = cardbalance;
	}

	public String getCardissueddate() {
		return cardissueddate;
	}

	public void setCardissueddate(String cardissueddate) {
		this.cardissueddate = cardissueddate;
	}

	public String getCardexpirydate() {
		return cardexpirydate;
	}

	public void setCardexpirydate(String cardexpirydate) {
		this.cardexpirydate = cardexpirydate;
	}

	public String getCardstatus() {
		return cardstatus;
	}

	public void setCardstatus(String cardstatus) {
		this.cardstatus = cardstatus;
	}

	public short getBankid() {
		return bankid;
	}

	public void setBankid(short bankid) {
		this.bankid = bankid;
	}
	


}
