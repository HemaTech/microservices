package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.CertificateMasterDAO;
import com.student.dao.FeeDAO;

@Service
public class FeeService {

	@Autowired(required=true)
	FeeDAO feeDAO;
	
	public String findByFeetype(int fee_id)
	{
		return feeDAO.findByFeetype(fee_id).get();
	}
}
