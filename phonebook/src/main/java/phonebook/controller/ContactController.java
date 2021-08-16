package phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import phonebook.entity.Contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ContactController {

    private List<Contact> contacts;

    /* NOTE:
    * GetMapping allows only to list OR to add contacts
    * so we cant add and list at the same time
    * so first if we want to list constructor with added contacts
    * then comment it and call the method addContact() with default constructor
    **/
    public ContactController(){
        this.contacts = new ArrayList<>();
                //Arrays.asList(new Contact("Pencho", "06642212131"), new Contact("Gabriel","0895654973")));
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelandView){
        modelandView.setViewName("index.html");
        modelandView.addObject("contacts", contacts);
        return modelandView;
    }

    @PostMapping("/")
    public String addContact(Contact contact){
        this.contacts.add(contact);
        return "redirect:/";
    }
}
