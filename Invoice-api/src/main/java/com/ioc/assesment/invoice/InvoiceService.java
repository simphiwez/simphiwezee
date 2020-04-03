package com.ioc.assesment.invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
	@Autowired
	InvoiceRepo invoiceRepo;
	
	public void addInvoice(Invoice invoice){
		invoiceRepo.save(invoice);
		
	}
	
	public List<Invoice> getAllInvoices(){	
		List<Invoice> invoices = new ArrayList<>();
		invoiceRepo.findAll().forEach(invoices::add);
		return invoices;
	}
	public Optional<Invoice> getInvoiceById(Long id){		
		return invoiceRepo.findById(id);
	}

}
