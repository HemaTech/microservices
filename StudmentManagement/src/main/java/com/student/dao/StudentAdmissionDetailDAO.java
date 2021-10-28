package com.student.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.modal.Student_admission_detail;


@Repository
public interface StudentAdmissionDetailDAO extends JpaRepository<Student_admission_detail, Integer> {

	
	public Optional<Student_admission_detail> findByAdmissionid(String admissionid);
}
