package com.contacts.service;

import com.contacts.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    // Dummy data
    List<Contact> list = List.of(
        new Contact(1L, "john@example.com", "9999999999", 101L),
        new Contact(2L, "jane@example.com", "8888888888", 101L),
        new Contact(3L, "sara@example.com", "7777777777", 102L)
    );

    @Override
    public List<Contact> getContactsOfUser(Long userId) {
        return list.stream()
                .filter(contact -> contact.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
