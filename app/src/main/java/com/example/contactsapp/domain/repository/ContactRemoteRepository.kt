package com.example.contactsapp.domain.repository

import com.example.contactsapp.domain.model.Contact

interface ContactRemoteRepository {

    suspend fun getContact(id: Int): Result<Contact>

    suspend fun getContacts(
        page: Int,
        pageSize:Int,
        gender: String?,
    ): Result<List<Contact>>

}