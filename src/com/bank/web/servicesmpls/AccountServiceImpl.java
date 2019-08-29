package com.bank.web.servicesmpls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.bank.web.domains.AccountBean;
import com.bank.web.services.AccountService;

public class AccountServiceImpl implements AccountService{
	
	private List<AccountBean> acc;
	public AccountServiceImpl() {
		acc = new ArrayList<>();
	}
	
	public void createAccount(int money) {
		AccountBean account = new AccountBean();
		account.setMoney(String.valueOf(money));
		account.setAccountNum(createAccountNum());
		account.setToday(findDate());
		acc.add(account);
		System.out.println(account);
		
	}

	public String createAccountNum() {
		String accNum = "";
		Random ran = new Random();
		for(int i=0;i<9;i++) {
			accNum += (i==4)?"-":ran.nextInt(10);
		}
		return accNum;
	}

	public List<AccountBean> findAll() {
		return acc;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean a = new AccountBean();
		for(AccountBean c : acc) {
			if(accountNum.equals(c.getAccountNum())) {
				a = c;
				break;
			}
		}
		return a;
	}

	public int countAccounts() {
		return acc.size();
	}

	public boolean existAccountNum(String accountNum) {
		AccountBean a = findByAccountNum(accountNum);
		return (acc.contains(a));
	}

	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
	}

	public void depositMoney(AccountBean param) {
	    int money = 0;
        for(AccountBean ac : acc) {
            if(ac.getAccountNum().equals(param.getMoney())) {
                money = Integer.parseInt(ac.getMoney()) + Integer.parseInt(param.getMoney());
                
                ac.setMoney(String.valueOf(money));
                ac.setToday(findDate());
                
                acc.add(acc.indexOf(ac), ac);
            }
        }
    }
	public void withdrawMoney(AccountBean param) {
		if(existAccountNum(param.getAccountNum()));
		int withdrawal = Integer.parseInt(param.getMoney());
		int index = acc.indexOf(param);
		int saving = Integer.parseInt(acc.get(index).getMoney());
		String rr = String.valueOf(saving-withdrawal);
		acc.get(index).setMoney(rr);
		
	}

	public boolean deleteAccountNum(String accountNum) {
		AccountBean a = findByAccountNum(accountNum);
		return acc.remove(a);
	}

}
