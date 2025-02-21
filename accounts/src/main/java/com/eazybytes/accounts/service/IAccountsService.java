package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {
	
	/**
	 * 
	 * @param customerDto = takes input of customerDto details
	 */
	public void createAccount(CustomerDto customerDto);
	
	/**
	 * 
	 * @param mobileNumber - based on mobile number we can fetch the details
	 * @return - we can return the Accounts details
	 */
	public CustomerDto fetchAccount(String mobileNumber);
	
	/**
	 * 
	 * @param customerDto - customerDto object
	 * @return boolean indicating if the updating of Account details is successfull or not
	 */
	public boolean updateAccount(CustomerDto customerDto);
	
	/**
	 * 
	 * @param mobileNumber - input mobile number
	 * @return boolean indicating if the delete Account details is successfull or not
	 */
	public boolean deleteAccount(String mobileNumber);

}
