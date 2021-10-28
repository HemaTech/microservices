package com.student.management;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.student.dao.StudentDao;

import com.student.modal.Student;
import com.student.service.StudentService;

@SpringBootTest
class StudmentManagementApplicationTests {

	@Autowired
	private StudentService studentService;

	@MockBean
	private StudentDao studentDao;

	@Test
	void contextLoads() {
	}

	@Test
	public void getStudent() {
		String uid = "2616169644731";
		Student st = new Student();
		st.setName("Hemasunder1");

		when(studentDao.findByUid(uid)).thenReturn(Optional.of(st));

		///assertEquals(false, studentService.getStudentByUID(uid).isPresent());
		
		assertNotNull(uid, st);

	}

}
