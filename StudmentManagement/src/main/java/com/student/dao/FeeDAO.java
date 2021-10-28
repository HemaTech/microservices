package com.student.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.modal.Fee;
import com.student.modal.Student_admission_detail;

@Repository
public interface FeeDAO extends JpaRepository<Fee, Integer>{

	@Query(" select fee_type from Fee where id=?1 ")
	public Optional<String> findByFeetype(int fee_id);
}
