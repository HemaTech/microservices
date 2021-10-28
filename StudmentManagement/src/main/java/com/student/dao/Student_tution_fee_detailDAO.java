/*
 * package com.student.dao;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Query; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.student.modal.Fee; import
 * com.student.modal.Student_tution_fee_detail;
 * 
 * @Repository public interface Student_tution_fee_detailDAO extends
 * JpaRepository<Student_tution_fee_detail, Integer> {
 * 
 * @Query(value =
 * "  select concat('SSS/',concat(course_id,'/'),nextval('print_serno_seq')) as recipt_no from  student  where uid_no  =? "
 * , nativeQuery = true)
 * 
 * public Optional<String> getFeeReciptNumber(String uid_no); }
 */