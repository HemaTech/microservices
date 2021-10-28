package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.CertificateMasterDAO;
import com.student.dao.StudentDao;

@Service
public class CertificateService {
	@Autowired(required=true)
	CertificateMasterDAO certificateMasterDAO;
	
	public String findByCertificateName(int course_id,int certificate_id)
	{
		return certificateMasterDAO.findByCertificateName(course_id,certificate_id).get();
	}

}
