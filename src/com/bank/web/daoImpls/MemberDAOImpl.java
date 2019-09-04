package com.bank.web.daoImpls;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.pool.Constants;
public class MemberDAOImpl implements MemberDAO{

	@Override
	public void insertCustomer(CustomerBean param) {
		try {
			File file = new File(Constants.FILE_PATH+"member.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
