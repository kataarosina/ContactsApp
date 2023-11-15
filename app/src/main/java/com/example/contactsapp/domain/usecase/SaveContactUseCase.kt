package com.example.contactsapp.domain.usecase

import com.example.contactsapp.domain.model.Contact
import com.example.contactsapp.domain.repository.ContactLocalRepository

class SaveContactUseCase(private val contactLocalRepository: ContactLocalRepository ) {

    suspend operator fun invoke(listContacts: List<Contact>){
        contactLocalRepository.insertContacts(listContacts)
    }

}