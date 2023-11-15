package com.example.contactsapp.domain.usecase

import com.example.contactsapp.domain.model.Contact
import com.example.contactsapp.domain.model.Filters
import com.example.contactsapp.domain.repository.ContactLocalRepository

class GetContactsDaoUseCase(private val contactLocalRepository: ContactLocalRepository ) {

    suspend operator fun invoke(filter: Filters):List<Contact>{
        return contactLocalRepository.getContactsFromDao(filter)
    }
}
