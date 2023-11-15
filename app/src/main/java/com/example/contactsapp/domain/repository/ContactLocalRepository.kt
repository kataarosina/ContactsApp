package com.example.contactsapp.domain.repository

import com.example.contactsapp.domain.model.Contact
import com.example.contactsapp.domain.model.Filters

interface ContactLocalRepository {

    suspend fun insertContacts(contacts: List<Contact>)

    suspend fun deleteContacts(contacts: List<Contact>)

    suspend fun getContactFromDao(Id: Int): Contact

    suspend fun getContactsFromDao(filters: Filters): List<Contact>

}
