package com.example.e_commerce_app.ui.theme.feature.Auth.ui.screens.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_app.ui.theme.feature.Auth.domain.entities.register.RegisterRequest
import com.example.e_commerce_app.ui.theme.feature.Auth.domain.useCases.RegisterUseCase
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.utility.Resource
import com.example.e_commerce_app.ui.theme.feature.network.utility.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

//todo : states
data class RegisterStates (
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val password: String = "",
    val rePassword: String = "",
    val registerState: Resource<Unit> = Resource.Initial
)
//todo : intent
sealed interface RegisterIntent{
    data class EmailChanged (val email: String) : RegisterIntent
    data class PhoneChanged (val phone: String) : RegisterIntent
    data class PasswordChanged (val password: String) : RegisterIntent
    data class RePasswordChanged (val rePassword: String) : RegisterIntent
    data class NameChanged (val name: String) : RegisterIntent
    data object OnSignupClick: RegisterIntent

}
//todo : effects
sealed interface RegisterEffects {
    data class ShowToast ( val message :String) :  RegisterEffects
    data object OnNavigateToHome : RegisterEffects
}
@HiltViewModel
class RegisterViewModel@Inject constructor(val registerUseCase : RegisterUseCase ) : ViewModel(){
    private val _states : MutableStateFlow<RegisterStates> = MutableStateFlow(RegisterStates())
    val states : StateFlow<RegisterStates> = _states.asStateFlow()

    private val _effects : Channel<RegisterEffects> = Channel<RegisterEffects>(Channel.BUFFERED)
    val effects : Flow<RegisterEffects> = _effects.receiveAsFlow()
    fun onIntent (intent : RegisterIntent){
        //todo :
        when(intent){
            is RegisterIntent.EmailChanged -> changeEmail(email = intent.email)
            is RegisterIntent.NameChanged -> changeName(name = intent.name)
            RegisterIntent.OnSignupClick -> onSignupClicked()
            is RegisterIntent.PasswordChanged -> changePassword(password = intent.password)
            is RegisterIntent.PhoneChanged -> changePhone(phone = intent.phone)
            is RegisterIntent.RePasswordChanged -> changeRePassword(rePassword = intent.rePassword)
        }
    }
    private fun changeEmail (email : String){
        _states.value=_states.value.copy(email= email)
    }
    private fun changePassword (password : String){
        _states.value=_states.value.copy(password = password)
    }
    private fun changeName (name : String){
        _states.value=_states.value.copy(name = name)
    }
    private fun changePhone (phone : String){
        _states.value=_states.value.copy(phone = phone)
    }
    private fun changeRePassword (rePassword : String){
        _states.value=_states.value.copy(rePassword = rePassword)
    }
    private fun onSignupClicked(){
        viewModelScope.launch {
            //todo : Loading
            _states.update { it.copy(registerState = Resource.Loading) }
            when(val result = registerUseCase.invoke(
                registerRequest = RegisterRequest(
                    password = _states.value.password,
                    email = _states.value.email,
                    name = _states.value.name,
                    phone = _states.value.phone,
                    rePassword = _states.value.rePassword
                )
            )) {
                is ApiResult.ErrorApiResult -> {
                    _states.update {
                        it.copy(registerState = Resource.Error(errorMessage = result.error.errorMessage)) }
                    // todo : show toast
                    _effects.send(RegisterEffects.ShowToast(message = result.error.errorMessage))
                }
                is ApiResult.SuccessApiResult<Unit> -> {
                    _states.update {
                        it.copy(registerState = Resource.Success(data = Unit))
                    }
                    // todo : show toast
                    _effects.send(RegisterEffects.ShowToast(message = "Account Created Successfully"))
                    // todo : navigate to home screen
                    _effects.send(RegisterEffects.OnNavigateToHome)
                }


            }
        }
    }

}
