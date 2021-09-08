package in.atul.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.atul.entity.Contact;
import in.atul.repository.ContactRepository;

@Service
public class ImplService implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSw('Y');
		Contact save = contactRepo.save(contact);

		if (save != null && save.getContactId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> findAll = contactRepo.findAll();

		return findAll.stream().filter(contact -> contact.getActiveSw() == 'Y')
				.collect(Collectors.toList());

	}

	@Override
	public Contact getContactByIdContact(Integer contactId) {
		Optional<Contact> findById = contactRepo.findById(contactId);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
//		boolean status = contactRepo.existsById(contactId);
//
//		if (status) {
//			contactRepo.deleteById(contactId);
//			return true;
//		}

		Optional<Contact> optional = contactRepo.findById(contactId);

		if (optional.isPresent()) {

			Contact contact = optional.get();
			contact.setActiveSw('N');
			contactRepo.save(contact);
			return true;
		}

		return false;
	}

}
