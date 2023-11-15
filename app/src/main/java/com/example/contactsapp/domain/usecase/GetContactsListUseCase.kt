package com.example.contactsapp.domain.usecase

import com.example.contactsapp.domain.model.Contact
import com.example.contactsapp.domain.model.Filters
import com.example.contactsapp.domain.model.LceState
import com.example.contactsapp.domain.repository.ContactLocalRepository
import com.example.contactsapp.domain.repository.ContactRemoteRepository

class GetContactsListUseCase(
    private val contactRemoteRepository: ContactRemoteRepository,
) {
    private val pageSize = 50

    suspend operator fun invoke(
        filterQuery: Filters,
        currentPage:Int
    ):Result<List<Contact>>{
        return contactRemoteRepository.getContacts(
            currentPage,
            pageSize,
            filterQuery.gender,
        )
    }
}