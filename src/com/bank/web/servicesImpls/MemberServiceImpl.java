package com.bank.web.servicesImpls;

import java.util.ArrayList;
import java.util.List;

import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;

public class MemberServiceImpl implements MemberService{
	private List<CustomerBean> customers;
	private List<EmployeeBean> employees;
	
	public MemberServiceImpl() {
		customers = new ArrayList<>();
		employees = new ArrayList<>();
	}

	public void join(CustomerBean param) {
		customers.add(param);
	}


	public void register(EmployeeBean param) {
		employees.add(param);
	}

	public List<CustomerBean> findAllCustomers() {
		return customers;
	}
	public List<EmployeeBean> findAllEmployees() {
		return employees;
	}

	public List<MemberBean> findByName(String name) {
		List<MemberBean> k = new ArrayList<MemberBean>();
		int count = 0;
		for(CustomerBean c : customers) {
			if(name.equals(c.getName())) {
				count++;
			}
		}
		for(EmployeeBean e : employees) {
			if(name.equals(e.getName())) {
				count++;
			}
		}
		int j = 0;
		for(CustomerBean c : customers) {
			if(name.equals(c.getName())) {
				k.add(c);
				j++;
				if(j==count) {
					return k;
				}
			}
		}
		for(EmployeeBean e : employees) {
			if(name.equals(e.getName())) {
				k.add(e);
				j++;
				if(j==count) {
					break;
				}
			}
		}
		return k;
	}

	public MemberBean findById(String id) {
		MemberBean m = new MemberBean();
		for(CustomerBean c : customers) {
			if(id.equals(c.getId())) {
				m = c;
				break;
			}
		}
		for(EmployeeBean e : employees) {
			if(id.equals(e.getId())) {
				m = e;
				break;
			}
		}
		return m;
	}

	public boolean login(MemberBean param) {
		boolean flag = false;
		MemberBean m = findById(param.getId());
		for(CustomerBean c : customers) {
			if(m.equals(c.getId())) {
				flag = true;
				break;
			}
		}
		for(EmployeeBean e : employees) {
			if(m.equals(e.getId())) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}

	public int countCustomers() {
		return customers.size();
	}

	public int countEmployees() {
		return employees.size();
	}

	public boolean existId(String id) {
		MemberBean m = findById(id);
		return (employees.contains(m) || customers.contains(m));
	}

	public void updatePass(MemberBean param) {
		String id = param.getId();
		String oldPw = param.getPw().split(",")[0];
		String newPw = param.getPw().split(",")[1];
		MemberBean m = findById(id);
		if(m.getPw().equals(oldPw)) {
			int idx = (employees.contains(m)) 
					? employees.indexOf(m)
						:customers.indexOf(m);
			if(employees.contains(m)) {
				employees.get(idx).setPw(newPw);
			}else {
				customers.get(idx).setPw(newPw);
			}		
		}
	}

	public boolean deleteMember(MemberBean param) {
		MemberBean m = findById(param.getId());
			return (employees.contains(m))
					? employees.remove(m)
							:customers.remove(m);
		
	}
}
