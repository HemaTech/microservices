package com.student.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentAdmissionDetailDAO;
import com.student.dao.StudentDao;
import com.student.modal.Student;
import com.student.modal.Student_admission_detail;

@Service
public class StudentAdmissionService {

	@Autowired(required=true)
	StudentAdmissionDetailDAO studentAdmissionDetailDAO;
	
	public int getStudentByAdmissionId(String admission_id)
	{
		int id=0;
		Optional<Student_admission_detail> stadmdetails=	studentAdmissionDetailDAO.findByAdmissionid(admission_id);
		if(stadmdetails.isPresent())
		{
			id=stadmdetails.get().getId();
		}
		return id;
	}


}
