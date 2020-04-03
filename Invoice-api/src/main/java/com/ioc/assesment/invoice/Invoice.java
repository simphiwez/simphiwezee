package com.ioc.assesment.invoice;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="INVOICE")
public class Invoice {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;
	
	@Column(name="CLIENT")
	private String client;
	
	@Column(name="VAT_RATE")
	private Long vatRate;
	
	@Column(name="INVOICE_DATE")
	private Date invoiceDate;
	
	 @OneToOne(targetEntity=LineItem.class,cascade=CascadeType.ALL)
	 @JoinColumn(name = "ID")
	private LineItem lineItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Long getVatRate() {
		return vatRate;
	}

	public void setVatRate(Long vatRate) {
		this.vatRate = vatRate;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public LineItem getLineItem() {
		return lineItem;
	}

	public void setLineItem(LineItem lineItem) {
		this.lineItem = lineItem;
	}
	
	public BigDecimal getSubTotal(){
		return lineItem.getLineItemTotal();
	}
	
	public BigDecimal getVat(){
		return getSubTotal().multiply(new BigDecimal((double)vatRate/100));
	}
	
	public BigDecimal getTotal(){
		return getVat().add(getSubTotal());
	}
}
