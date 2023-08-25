package org.jsp.shoppingcartapi.service;

import java.util.Optional;

import org.jsp.shoppingcartapi.dao.AddressDao;
import org.jsp.shoppingcartapi.dao.UserDao;
import org.jsp.shoppingcartapi.dto.Address;
import org.jsp.shoppingcartapi.dto.ResponseStructure;
import org.jsp.shoppingcartapi.dto.User;
import org.jsp.shoppingcartapi.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address, int user_id) {
		Optional<User> recUser = userDao.findById(user_id);
		if (recUser.isPresent()) {
			recUser.get().getAddresses().add(address);
			address.setUser(recUser.get());
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setData(dao.saveAddress(address));
			structure.setMessage("Address saved succesfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);

		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address, int user_id) {
		Optional<User> recUser = userDao.findById(user_id);
		if (recUser.isPresent()) {
			recUser.get().getAddresses().add(address);
			address.setUser(recUser.get());
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setData(address);
			structure.setMessage("Address saved succesfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);

		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Address>> findAddressById(int id) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		Optional<Address> recAddress = dao.findById(id);
		if (recAddress.isEmpty()) {
			structure.setData(null);
			structure.setMessage("address Not found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.NOT_FOUND);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteAddress(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Address> recAddress = dao.findById(id);
		if (recAddress.isEmpty()) {
			structure.setMessage("Address Not deleted");
			structure.setData("Address not found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
		}
		throw new IdNotFoundException();
	}

//	public ResponseEntity<ResponseStructure<List<Address>>> findAddressByUserId(int id) {
//		ResponseStructure<List<Address>> structure = new ResponseStructure<>();
//		structure.setBody(dao.findAddressByUserId(id));
//		structure.setCode(HttpStatus.OK.value());
//		structure.setMessage("The list of address for the user");
//		return new ResponseEntity<ResponseStructure<List<Address>>>(structure, HttpStatus.OK);
//	}
}
