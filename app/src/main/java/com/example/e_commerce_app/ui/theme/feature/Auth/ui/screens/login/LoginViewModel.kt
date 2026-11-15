package com.example.e_commerce_app.ui.theme.feature.Auth.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_app.ui.theme.feature.Auth.domain.entities.login.LoginRequest
import com.example.e_commerce_app.ui.theme.feature.Auth.domain.useCases.LoginUseCase
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.utility.Resource
import com.example.e_commerce_app.ui.theme.feature.network.utility.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

// todo : MVI -> states , intent  , events

//todo: states
data class LoginStates(
    val email : String = "" ,
    val password : String = "",
    val loginState: Resource<Unit> = Resource.Initial
)
//todo: intent
sealed interface LoginIntent {
    data class EmailChanged(val email : String) : LoginIntent
    data class  PasswordChanged (val password : String) : LoginIntent
    data object OnLoginClick : LoginIntent
    data object OnCreateAccountClick : LoginIntent
}

//todo : events  / effects
sealed interface LoginEffects {
    data class ShowToast (val message :String) : LoginEffects
    data object OnNavigateToRegister : LoginEffects
    data object OnNavigateToHome  : LoginEffects
}

@HiltViewModel
class LoginViewModel @Inject constructor(val loginUseCase : LoginUseCase): ViewModel(){
    private val _states : MutableStateFlow<LoginStates> = MutableStateFlow(LoginStates())
    val states : StateFlow<LoginStates> = _states.asStateFlow()

    private val _effects : Channel<LoginEffects> = Channel<LoginEffects>(Channel.BUFFERED)
    val effects : Flow<LoginEffects> = _effects.receiveAsFlow()
    fun onIntent (intent : LoginIntent){
        when(intent){
            is LoginIntent.EmailChanged -> changeEmail(email = intent.email)
            LoginIntent.OnCreateAccountClick -> onSignupClicked()
            LoginIntent.OnLoginClick -> login()
            is LoginIntent.PasswordChanged -> changePassword(password = intent.password)
        }
    }
    private fun changeEmail (email : String){
        _states.value=_states.value.copy(email= email)
    }
    private fun changePassword (password : String){
        _states.value=_states.value.copy(password = password)
    }
    private fun login(){
        viewModelScope.launch {
            //todo : Loading
            _states.update { it.copy(loginState = Resource.Loading) }
             when(val result = loginUseCase.invoke(
                loginRequest = LoginRequest(
                    password = _states.value.password,
                    email = _states.value.email,
                )
            )) {
                is ApiResult.ErrorApiResult -> {
                    _states.update {
                        it.copy(loginState = Resource.Error(errorMessage = result.error.errorMessage)) }
                    // todo : show toast
                    _effects.send(LoginEffects.ShowToast(message = result.error.errorMessage))
                }
                is ApiResult.SuccessApiResult<Unit> -> {
                    _states.update {
                        it.copy(loginState = Resource.Success(data = Unit))
                    }
                    // todo : show toast
                    _effects.send(LoginEffects.ShowToast(message = "Login Successfully"))
                    // todo : navigate to home screen
                    _effects.send(LoginEffects.OnNavigateToHome)
                }


            }
        }
    }
    private fun onSignupClicked(){
        //todo : navigate to register screen
        viewModelScope.launch {
            _effects.send(LoginEffects.OnNavigateToRegister)
        }
    }

}