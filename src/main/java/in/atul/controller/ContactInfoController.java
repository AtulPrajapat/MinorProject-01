package in.atul.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.atul.AppConstants;
import in.atul.entity.Contact;
import in.atul.properties.AppProperties;
import in.atul.service.ContactService;

@Controller
public class ContactInfoController {
	
	@Autowired
	private AppProperties appProperties;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact")
	public String loadContactForm(Model model) {
		
		Contact contactObj=new Contact();
		model.addAttribute("contact", contactObj);
		return AppConstants.CONTACT_INFO;
	}
	
	@PostMapping("/saveContact")
	public String saveContact(Contact contact, Model model) {
		boolean isSaved = contactService.saveContact(contact);
		HashMap<String,String> messages = appProperties.getMessages();
		
		if (isSaved) {
			model.addAttribute(AppConstants.SUCCESS, messages.get(AppConstants.SAVE_SUCCESS));
		}else {
			model.addAttribute(AppConstants.FAIL, messages.get(AppConstants.SAVE_FAIL));
		}
		return AppConstants.CONTACT_INFO;
	}
	
	@GetMapping("/viewsContact")
	public String viewAllContact(Model model) {
		
		List<Contact> allContacts = contactService.getAllContacts();
		
		model.addAttribute(AppConstants.CONTACTS, allContacts);
		
		return AppConstants.CONTACTS;
		
	}

}
