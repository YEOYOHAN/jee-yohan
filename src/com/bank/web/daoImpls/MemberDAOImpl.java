package com.bank.web.daoImpls;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.pool.Constants;
public class MemberDAOImpl implements MemberDAO{

	@Override
	public void insertCustomer(CustomerBean param) {
		try {
			File file = new File(Constants.FILE_PATH+"customer.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(String.format("%s,%s,%s,%s,%s", param.getId(),param.getName(),param.getPw(),param.getSsn(),param.getCredit()));
			writer.newLine();
			writer.flush();
			writer.close();
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

	@Override
	public CustomerBean login(CustomerBean param) {
			CustomerBean cc = new CustomerBean();
		try {
			File file = new File(Constants.FILE_PATH+"customer.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String pNum = reader.readLine();
			String[] spl = pNum.split(",");
			cc.setId(spl[0]);
			cc.setName(spl[1]);
			cc.setPw(spl[2]);
			cc.setSsn(spl[3]);
			cc.setCredit(spl[4]);
			if(param.getId().equals(cc.getId())&&param.getPw().equals(cc.getPw())) {
				cc = param;
			}else {
				cc = null;
			}
			reader.close();
		} catch (Exception e) {
		}
		return cc;
		
		
	}

}
