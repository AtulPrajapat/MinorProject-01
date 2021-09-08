package in.atul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.atul.entity.Contact;
import in.atul.service.ContactService;

@Controller
public class ViewContactsController {

	@Autowired
	private ContactService service;

	@GetMapping("/edit")
	public String editContacts(@RequestParam("cid") Integer contactId, Model model) {

		Contact contact = service.getContactByIdContact(contactId);
		model.addAttribute("contact", contact);
		return "contactInfo";

	}

	@GetMapping("/delete")
	public String deleteContacts(@RequestParam("cid") Integer contactId, Model model) {
		service.deleteContactById(contactId);
		return "redirect:viewsContact";
	}

}
