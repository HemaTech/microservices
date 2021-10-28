package com.student.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.filters.CsrfPreventionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.dto.Certificate_student_infoDTO;
import com.student.dto.Course_completionDTO;
import com.student.dto.StudentDTO;
import com.student.dto.Student_ReportDTO;
import com.student.dto.Student_admission_detailDTO;
import com.student.dto.Student_attendanceDTO;
import com.student.dto.Student_hostelDTO;
import com.student.dto.Student_tution_fee_detailDTO;
import com.student.modal.Certificate_student_info;
import com.student.modal.Course_completion;
import com.student.modal.Student;
import com.student.modal.Student_admission_detail;
import com.student.modal.Student_attendance;
import com.student.modal.Student_hostel;
import com.student.modal.Student_tution_fee_detail;

@Service
public class StudentService {
@Autowired(required=true)
StudentDao studentDao;



public Optional<Student> getStudentByID(int id)
{
	return studentDao.findById(id);
}

public Optional<Student> getStudentByUID(String uid)
{
	return studentDao.findByUid(uid);
}

public Optional<Student_ReportDTO> findByStudent_By_Uid_Info(String uid_no)
{
	return studentDao.findByStudent_By_Uid_Info(uid_no);
}


public boolean isStudenExist(String uid)
{
	Optional<Student> studentexists= studentDao.findByUid(uid);
	
	return studentexists.isPresent();
}


public boolean StudenExist(int id)
{
	Optional<Student> studentexists= studentDao.findById(id);
	
	return studentexists.isPresent();
}



public Student save(Student student)
{
	return studentDao.save(student);
}

public Student studentupdate(StudentDTO studentdto,Student student)
{
	try
	{
	if(studentdto!=null)
	{
			/*
			 * student.setActual_fee(studentdto.getActual_fee());
			 * student.setAddress(studentdto.getAddress());
			 * student.setAdmission_year(studentdto.getAdmission_year());
			 * student.setBord_generated_admission_no(studentdto.
			 * getBord_generated_admission_no());
			 * student.setBranch_id(studentdto.getBranch_id());
			 */
		
		if(studentdto.getCourse_completion()!=null)
		{
			Course_completion cc=student.getCourse_completion();
			if(cc==null)
			{
				cc=new  Course_completion();
			}
			Course_completionDTO ccd=	studentdto.getCourse_completion();
			cc.setCourse_completed(ccd.getCourse_completed());
			cc.setTc_issued(ccd.getTc_issued());
			cc.setTc_issued_date(ccd.getTc_issued_date());
			
			student.setCourse_completion(cc);
		
		
		}
		
		if(studentdto.getStudent_admission_detail()!=null)
		{
			Student_admission_detail sad=student.getStudent_admission_detail();
			if(sad==null)
			{
				sad=new  Student_admission_detail();
			}
			Student_admission_detailDTO sadd=	studentdto.getStudent_admission_detail();
			sad.setAdmissionid(sadd.getAdmissionid());
			
			
			
			if(sadd.getHallticketno()!=null && !sadd.getHallticketno().equalsIgnoreCase("") && sadd.getHallticketno()!="")
			{
			sad.setHallticketno(sadd.getHallticketno());
			}
			if(sadd.getBoard_generated_admission_no()!=null &&
					!sadd.getBoard_generated_admission_no().equalsIgnoreCase("")&&
					sadd.getBoard_generated_admission_no()!="")
			{
			student.setBord_generated_admission_no(sadd.getBoard_generated_admission_no());
			sad.setBoard_generated_admission_no(sadd.getBoard_generated_admission_no());
			}
			student.setStudent_admission_detail(sad);
		
		
		}
		
		
		if(studentdto.getStudent_tution_fee_detail()!=null)
		{
			List<Student_tution_fee_detailDTO> stfd=studentdto.getStudent_tution_fee_detail();
			Student_tution_fee_detail stf=new Student_tution_fee_detail();
			
			stf.setFee_amount(stfd.get(0).getFee_amount());
			stf.setFee_type(stfd.get(0).getFee_type());
			stf.setPaid_on(stfd.get(0).getPaid_on());
			
			if(studentdto.getStudent_tution_fee_detail().get(0).getChallen_no()==null ||
					studentdto.getStudent_tution_fee_detail().get(0).getChallen_no().equalsIgnoreCase(""))
			{
			stf.setReceipt_no(getFeeReciptNumber(student.getUid(),student.getId()));
			}
			else
			{
				stf.setReceipt_no(studentdto.getStudent_tution_fee_detail().get(0).getChallen_no());	
			}
			List<Student_tution_fee_detail> stflist=new ArrayList<Student_tution_fee_detail>();
			stflist.add(stf);
			
			student.setStudent_tution_fee_detail(stflist);
		
		
		}
		
		
		if(studentdto.getStudent_hostel() !=null)
		{
			
			
			
			Student_hostel shd=student.getStudent_hostel();
			if(shd==null)
			{
				shd=new  Student_hostel();
			}
			Student_hostelDTO shdt=	studentdto.getStudent_hostel();
			
			if(shd.getAvailed_from()!=null)
			{
			shd.setAvailed_from(new java.util.Date());
			}
			//=============================================//
			
			Calendar cal = Calendar.getInstance();
			
			cal.add(Calendar.YEAR, 1); // to get previous year add -1
			Date nextYear = cal.getTime();
			
			//==============================================//
			shd.setDiscontinued_on(nextYear);
			
			shd.setHostel_fee(shdt.getHostel_fee());
		//	shd.setHostel_prev_fee(shdt.getHostel_prev_fee());
			
			student.setStudent_hostel(shd);
			
			
		
		
		}
		
		
		if(studentdto.getCertificate_student_info()!=null)
		{
			List<Certificate_student_infoDTO> stfd=studentdto.getCertificate_student_info();
			List<Certificate_student_info> stflist=new ArrayList<Certificate_student_info>();
			for(int i=0;i<stfd.size();i++)
			{
			Certificate_student_info stf=new Certificate_student_info();
			
			stf.setAction(stfd.get(i).getAction());
			stf.setCertificate_id(stfd.get(i).getCertificate_id());
			stf.setGenerateTime(stfd.get(i).getGenerateTime() );
			stf.setRemarks(stfd.get(i).getRemarks());
			
			stflist.add(stf);
			
			student.setCertificate_student_info(stflist); 
		
			}
		}
		
		if(studentdto.getStudent_attendance()!=null)
		{
			List<Student_attendanceDTO> stfd=studentdto.getStudent_attendance();
			List<Student_attendance> stflist=new ArrayList<Student_attendance>();
			for(int i=0;i<stfd.size();i++)
			{
				Student_attendance stf=new Student_attendance();
			
			stf.setAcademic_year_id(stfd.get(i).getAcademic_year_id());
			stf.setAttendance_month(stfd.get(i).getAttendance_month());
			stf.setAttendance_year(stfd.get(i).getAttendance_year());
			stf.setAttendance_date(stfd.get(i).getAttendance_date());
			stf.setIs_present(true);
			stf.setAttendance_type(stfd.get(i).getAttendance_type());
			
			
			stflist.add(stf);
			
			student.setStudent_attendance(stflist) ;
		
			}
		}
		
		/*
		 * if(student.getActual_fee()!=studentdto.getActual_fee()) {
		 * student.setActual_fee(studentdto.getActual_fee()); }
		 */
		
		
		if(studentdto.getActual_fee()!=0)
		{
			student.setActual_fee(studentdto.getActual_fee());
		}
		
		
		
			/*
			 * student.setUid(studentdto.getUid()); student.setName(studentdto.getName());
			 */
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return studentDao.save(student);
}

public String	findByAdmissionNO (String uid_no)
{
	return studentDao.findByAdmissionNO(uid_no).get();
}

public String	getFeeReciptNumber(String uid_no,int id)
{
	return studentDao.getFeeReciptNumber(uid_no,id).get();
}

public boolean	findByUidBranch(String uid,int branch_id)
{
	return studentDao.findByUidBranch(uid, branch_id).isPresent();
}
}
