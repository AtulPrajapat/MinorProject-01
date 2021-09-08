package in.atul.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.atul.entity.Contact;

@Service
public interface ContactService {
	
	public boolean saveContact(Contact contact); 
	
	public List<Contact> getAllContacts();
	
	public Contact getContactByIdContact(Integer contactId);
	
	public boolean deleteContactById(Integer contactId);                                                                                                                                                                            
	

}
