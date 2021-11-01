package com.student.controller;

import java.util.Calendar;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.student.dto.Certificate_student_infoDTO;
import com.student.dto.StudentDTO;
import com.student.dto.Student_ReportDTO;
import com.student.dto.Student_admission_detailDTO;
import com.student.dto.Student_tution_fee_detailDTO;
import com.student.exceptionhandler.ResourceNotFoundException;
import com.student.modal.Student;
import com.student.service.CertificateService;
import com.student.service.FeeService;
import com.student.service.StudentAdmissionService;
import com.student.service.StudentService;
import com.student.util.CustomErrorType;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://10.191.35.70:8080")
public class StudentController {

	public static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	StudentService studentService    ;

	@Autowired
	CertificateService certificateService;

	@Autowired
	StudentAdmissionService studentAdmissionService;

	@Autowired
	FeeService feeService;

	@Autowired
	private ModelMapper modelMapper;

	
	@GetMapping(value = "/student/{id}")
	//@CrossOrigin(origins = "http://localhost:4200")
	//@CrossOrigin(origins = "http://10.191.35.70:8080")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 422, message = "Username is already in use"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public ResponseEntity<?> getStudent(@PathVariable("id") int id) {

		logger.info("Fetching User with id {}", id);

		Optional<Student> student = studentService.getStudentByID(id);

		if (student.isPresent()) {
			StudentDTO studentdto = modelMapper.map(student.get(), StudentDTO.class);
			return new ResponseEntity<StudentDTO>(studentdto, HttpStatus.OK);
		}

		else {
			throw new ResourceNotFoundException("STUDENT WITH ID :  " + id + " NOT FOUND");
		}

	}

	@GetMapping(value = "/studentuid/{uid}")
	//@CrossOrigin(origins = "http://localhost:8080")
	//@CrossOrigin(origins = "http://10.191.35.70:8080")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 422, message = "Username is already in use"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public ResponseEntity<?> getStudentByUID(@PathVariable("uid") String uid) {

		logger.info("Fetching User with id {}", uid);

		Optional<Student> student = studentService.getStudentByUID(uid);

		if (student.isPresent()) {
			StudentDTO studentdto = modelMapper.map(student.get(), StudentDTO.class);
			for (Certificate_student_infoDTO ctd : studentdto.getCertificate_student_info()) {
				ctd.setCertificate_name(
						certificateService.findByCertificateName(studentdto.getCourse_id(), ctd.getCertificate_id()));
				if (ctd.getAction().equalsIgnoreCase("1")) {
					ctd.setAction_name("STUDENT TO COLLEGE APPROVAL PENDING");
				} else if (ctd.getAction().equalsIgnoreCase("2")) {
					ctd.setAction_name("COLLEGE TO STUDENT APPROVAL PENDING");
				} else if (ctd.getAction().equalsIgnoreCase("3")) {
					ctd.setAction_name("STUDENT TO COLLEGE APPROVED");
				}

				else if (ctd.getAction().equalsIgnoreCase("4")) {
					ctd.setAction_name("COLLEGE TO STUDENT APPROVED");
				} else {
					ctd.setAction_name("NA");
				}
			}

			for (Student_tution_fee_detailDTO stf : studentdto.getStudent_tution_fee_detail()) {
				stf.setFee_type_name(feeService.findByFeetype(stf.getFee_type()));
			}

			return new ResponseEntity<StudentDTO>(studentdto, HttpStatus.OK);
		}

		else {
			throw new ResourceNotFoundException("STUDENT WITH IS  " + uid + " NOT FOUND");
		}

	}

	@GetMapping(value = "/studentuidinfo/{uid}")
	//@CrossOrigin(origins = "http://localhost:8080")
	//@CrossOrigin(origins = "http://10.191.35.70:8080")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 422, message = "Username is already in use"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public ResponseEntity<?> getStudentByUIDINFO(@PathVariable("uid") String uid) {

		logger.info("Fetching User with id {}", uid);

		Optional<Student_ReportDTO> student = studentService.findByStudent_By_Uid_Info(uid);

		if (student.isPresent()) {
			Student_ReportDTO studentdto = modelMapper.map(student.get(), Student_ReportDTO.class);
			return new ResponseEntity<Student_ReportDTO>(studentdto, HttpStatus.OK);
		}

		else {
			throw new ResourceNotFoundException("STUDENT WITH IS  " + uid + " NOT FOUND");
		}

	}

	@GetMapping(value = "/studentadmission/{admission_id}")

	//@CrossOrigin(origins = "http://localhost:8080")

	@ApiResponses(value = { //

			@ApiResponse(code = 400, message = "Something went wrong"), //

			@ApiResponse(code = 403, message = "Access denied"), //

			@ApiResponse(code = 422, message = "Username is already in use"), //

			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public ResponseEntity<?> getStudentByAdmissionId(@PathVariable("admission_id") String admission_id) {

		logger.info("Fetching User with id {}", admission_id);

		int student_id = 0;
		student_id = studentAdmissionService.getStudentByAdmissionId(admission_id);

		if (student_id != 0) {
			Optional<Student> student = studentService.getStudentByID(student_id);

			if (student.isPresent()) {
				StudentDTO studentdto = modelMapper.map(student.get(), StudentDTO.class);
				return new ResponseEntity<StudentDTO>(studentdto, HttpStatus.OK);
			}

			else {
				throw new ResourceNotFoundException("STUDENT WITH IS  " + admission_id + " NOT FOUND");
			}
		} else {
			throw new ResourceNotFoundException("STUDENT WITH IS  " + admission_id + " NOT FOUND");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/student/create/", method = RequestMethod.POST)
	public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentdto, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", studentdto);

		try {
			if (studentService.findByUidBranch(studentdto.getUid(), studentdto.getBranch_id())) {
				logger.error("Unable to create. A User with UID {} already exist", studentdto.getUid());
				return new ResponseEntity(new CustomErrorType(
						"Unable to create. A Student with uid and Branch " + studentdto.getUid() + " already exist."),
						HttpStatus.CONFLICT);
			} else {
				try {
					String admission = null;
					Student_admission_detailDTO sadt = new Student_admission_detailDTO();
					int academic__year = Calendar.getInstance().get(Calendar.YEAR);
					admission = academic__year + "" + studentdto.getBranch_id() + ""
							+ studentdto.getUid().substring(6, 12);

					sadt.setAdmissionid(admission);

					studentdto.setStudent_admission_detail(sadt);

					studentdto.setRegistered_on(new java.util.Date());
					
					
					
					Student student = modelMapper.map(studentdto, Student.class);
					
					if(student.getStudent_hostel()!=null)
					{
					if(student.getStudent_hostel().getHostel_prev_fee()!=0)
					{
						student.getStudent_hostel().setAvailed_from(new java.util.Date());
						
						student.getStudent_hostel().setAvailed_from(new java.util.Date());
					}
					}
					if(student.getCourse_id()==1)
					{
						student.setActual_fee(2*student.getActual_fee());
					}
					else if(student.getCourse_id()==2)
					{
						student.setActual_fee(3*student.getActual_fee());
					}
					else if(student.getCourse_id()==3)
					{
						student.setActual_fee(2*student.getActual_fee());
					}
					else
					{
						
					}
					studentService.save(student);
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<String>(studentdto.getUid(), HttpStatus.EXPECTATION_FAILED);
				}

				return new ResponseEntity<String>(studentdto.getUid(), HttpStatus.CREATED);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(studentdto.getUid(), HttpStatus.EXPECTATION_FAILED);
		}

	}

	//@CrossOrigin(origins = "http://localhost:8080")
	//@CrossOrigin(origins = "http://10.191.35.70:8080")
	@RequestMapping(value = "/student/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentdto) {
		logger.info("Creating User : {}", studentdto);
			
		if (!studentService.StudenExist(studentdto.getId())) {
			logger.error("Unable to create. A User with UID {} already exist", studentdto.getUid());
			throw new ResourceNotFoundException("STUDENT WITH IS  " + studentdto.getUid() + " NOT FOUND");
		} else {
			try {
				Optional<Student> student = studentService.getStudentByID(studentdto.getId());

				if (student.isPresent()) {
					if (studentdto.getStudent_tution_fee_detail() != null) {
						studentdto.getStudent_tution_fee_detail().get(0).setPaid_on(new java.util.Date());
					}
					
					if (studentdto.getStudent_attendance() != null) {
					
						int academic__year = Calendar.getInstance().get(Calendar.YEAR);
						int academic__month = Calendar.getInstance().get(Calendar.MONTH)+1;
						
						
						studentdto.getStudent_attendance().get(0).setAttendance_date(new java.util.Date());
						studentdto.getStudent_attendance().get(0).setIs_present(true);
						studentdto.getStudent_attendance().get(0).setAttendance_month(academic__month);
						//studentdto.getStudent_attendance().get(0).setAcademic_year_id(studentdto);
						
					}
					
					studentService.studentupdate(studentdto, student.get());
				}
			} catch (Exception e) {
				 e.printStackTrace();
				return new ResponseEntity<String>(studentdto.getUid(), HttpStatus.CONFLICT);
			}

		}
		return new ResponseEntity<String>(studentdto.getUid(), HttpStatus.OK);
	}

	@GetMapping(value = "/studentid/{student_id}")
	//@CrossOrigin(origins = "http://localhost:8080")
	//@CrossOrigin(origins = "http://10.191.35.70:8080")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 422, message = "Username is already in use"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public ResponseEntity<?> getStudentByID(@PathVariable("student_id") String student_id) {

		logger.info("Fetching User with id {}", student_id);

		int s_id = Integer.valueOf(student_id);
		Optional<Student> student = studentService.getStudentByID(s_id);

		if (student.isPresent()) {
			StudentDTO studentdto = modelMapper.map(student.get(), StudentDTO.class);
			for (Certificate_student_infoDTO ctd : studentdto.getCertificate_student_info()) {
				ctd.setCertificate_name(
						certificateService.findByCertificateName(studentdto.getCourse_id(), ctd.getCertificate_id()));
				if (ctd.getAction().equalsIgnoreCase("1")) {
					ctd.setAction_name("STUDENT TO COLLEGE APPROVAL PENDING");
				} else if (ctd.getAction().equalsIgnoreCase("2")) {
					ctd.setAction_name("COLLEGE TO STUDENT APPROVAL PENDING");
				} else if (ctd.getAction().equalsIgnoreCase("3")) {
					ctd.setAction_name("STUDENT TO COLLEGE APPROVED");
				}

				else if (ctd.getAction().equalsIgnoreCase("4")) {
					ctd.setAction_name("COLLEGE TO STUDENT APPROVED");
				} else {
					ctd.setAction_name("NA");
				}
			}

			for (Student_tution_fee_detailDTO stf : studentdto.getStudent_tution_fee_detail()) {
				stf.setFee_type_name(feeService.findByFeetype(stf.getFee_type()));
			}

			return new ResponseEntity<StudentDTO>(studentdto, HttpStatus.OK);
		}

		else {
			throw new ResourceNotFoundException("STUDENT WITH IS  " + s_id + " NOT FOUND");
		}

	}
//=======================================================================//
	
	//@CrossOrigin(origins = "http://localhost:8080")
		//@CrossOrigin(origins = "http://10.191.35.70:8080")
		@RequestMapping(value = "/student/update", method = RequestMethod.PUT)
		public ResponseEntity<?> updateStudentTest(@RequestBody StudentDTO studentdto) {
			logger.info("Creating User : {}", studentdto);
				
			if (!studentService.StudenExist(studentdto.getId())) {
				logger.error("Unable to create. A User with UID {} already exist", studentdto.getUid());
				throw new ResourceNotFoundException("STUDENT WITH IS  " + studentdto.getUid() + " NOT FOUND");
			} else {
				try {
					Optional<Student> student = studentService.getStudentByID(studentdto.getId());

					if (student.isPresent()) {
						if (studentdto.getStudent_tution_fee_detail() != null) {
							studentdto.getStudent_tution_fee_detail().get(0).setPaid_on(new java.util.Date());
						}
						
						if (studentdto.getStudent_attendance() != null) {
						
							int academic__year = Calendar.getInstance().get(Calendar.YEAR);
							int academic__month = Calendar.getInstance().get(Calendar.MONTH)+1;
							
							
							studentdto.getStudent_attendance().get(0).setAttendance_date(new java.util.Date());
							studentdto.getStudent_attendance().get(0).setIs_present(true);
							studentdto.getStudent_attendance().get(0).setAttendance_month(academic__month);
							//studentdto.getStudent_attendance().get(0).setAcademic_year_id(studentdto);
							
						}
						
						studentService.studentupdate(studentdto, student.get());
					}
				} catch (Exception e) {
					 e.printStackTrace();
					return new ResponseEntity<String>(studentdto.getUid(), HttpStatus.CONFLICT);
				}

			}
			return new ResponseEntity<String>(studentdto.getUid(), HttpStatus.OK);
		}
	
}
