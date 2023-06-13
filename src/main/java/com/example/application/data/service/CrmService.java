package com.example.application.data.service;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;
import com.example.application.data.repository.CompanyRepository;
import com.example.application.data.repository.ContactRepository;
import com.example.application.data.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrmService {
    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final StatusRepository statusRepository;

    public CrmService(ContactRepository contactRepository,
                      CompanyRepository companyRepository,
                      StatusRepository statusRepository) {

        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
        this.statusRepository = statusRepository;
    }

    // find all contacts if filterText box is empty or search contacts based on entered text
    public List<Contact> findAllContacts(String filterText) {
        if(filterText == null || filterText.isEmpty()) {
            return contactRepository.findAll();
        } else {
            return contactRepository.search(filterText);
        }
    }

    // count contacts
    public Long countContacts() {
        return contactRepository.count();
    }

    // delete contact
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

    // Save contact
    public void saveContact(Contact contact) {
        if(contact == null) {
            System.out.println("Contact is null");
            return;
        }
        contactRepository.save(contact);
    }

    // finding all companies
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    // finding  all statuses
    public List<Status> findAllStatuses() {
        return statusRepository.findAll();
    }
}
