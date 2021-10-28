package com.student.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.student.dto.Admission_Receipt;
import com.student.dto.Student_ReportDTO;
import com.student.modal.Student;
@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

	public Optional<Student>	findByUid(String uid);
	
	//public Optional<Student>	findById(int id);
	
	
	
@Query("select s.name as student_name,s.father_name,s.admission_year,s.uid as uid_no ,s.registered_on,c.name as course_name,b.name as branch_name," + 
	  		"m.name as medium_name ,g.name as gender_name from Student s ,Course c, Branch b,Medium m ,Gender g where  " + 
	  		"s.course_id=c.id and s.branch_id=b.id and s.gender_id=g.id and s.medium_id=m.id and s.uid=?1 ")
	  
	  public Optional<Student_ReportDTO> findByStudent_By_Uid_Info(String uid);
	
	
	 
		@Query(value = "  select concat(course_id,admission_year,substr(uid_no,7)) as admission_no  from student where uid_no=? ", nativeQuery = 
		        true)
		
		public Optional<String>	findByAdmissionNO (String uid_no);
		
		

		@Query(value = "  select concat('SSS/',concat(course_id,'/'),nextval('print_serno_seq')) as recipt_no from  student  where uid_no  =? and id=? ", nativeQuery = 
		        true)
		
		public Optional<String>	getFeeReciptNumber(String uid_no,int id);
		
		
		@Query(value = "  select uid_no from  student  where uid_no  =? and branch_id=? ", nativeQuery = 
		        true)
		public Optional<Student>	findByUidBranch(String uid,int branch_id);
}
