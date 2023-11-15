package com.example.contactsapp.domain.usecase

import com.example.contactsapp.domain.model.Contact
import com.example.contactsapp.domain.model.LceState
import com.example.contactsapp.domain.repository.ContactLocalRepository
import com.example.contactsapp.domain.repository.ContactRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class GetContactUseCase(
    private val contactRemoteRepository: ContactRemoteRepository,
    private val contactLocalRepository: ContactLocalRepository
) {
    operator fun invoke(contactId: Int) : Flow<LceState<Contact>> = flow{

        val contact =
            contactRemoteRepository.getContact(contactId).fold(onSuccess = { contact ->
                LceState.Content(contact)
            }, onFailure = {err ->
                LceState.Error(err)
            })
        emit(contact)

    }.onStart {
        emit(LceState.Content(contactLocalRepository.getContactFromDao(contactId)))
    }


}