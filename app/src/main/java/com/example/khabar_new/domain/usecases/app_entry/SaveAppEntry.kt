package com.example.khabar_new.domain.usecases.app_entry

import com.example.khabar_new.domain.manager.LocalUserManager

class SaveAppEntry (
    private val localUserManager: LocalUserManager
){

    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }

}