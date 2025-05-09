package com.example.login.domain.usecase

import com.example.login2.repository.AuthRepository
import javax.inject.Inject

class CheckIfUserExistsUseCase @Inject constructor(private val authRepository: AuthRepository){
    suspend operator fun invoke(): Boolean{
        return authRepository.checkIfUserExists()
    }
}