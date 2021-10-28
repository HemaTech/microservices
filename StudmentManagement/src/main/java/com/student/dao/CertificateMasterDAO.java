package com.student.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.modal.Certificate_master;

@Repository
public interface CertificateMasterDAO  extends JpaRepository<Certificate_master, Integer>{

	@Query(" select certficateName from Certificate_master where id=?2 and  course_id =?1  ")
	  public Optional<String> findByCertificateName(int course_id,int certificate_id);
}
