package com.example.pmdm22_examen_3t.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.pmdm22_examen_3t.data.model.Client
import com.example.pmdm22_examen_3t.data.model.getFakeClients


enum class DialogKind { ERROR, CORRECT }

class ClientsViewModel : ViewModel() {

    private val _clientList = getFakeClients().toMutableStateList() //mutableStateListOf<Client>()
    val clientList get() = _clientList.toList()

    private var _alreadySignedUsername by mutableStateOf(false)
    val alreadySignedUsername: Boolean get() = _alreadySignedUsername
    fun clearAlreadySignedUserName() {
        _alreadySignedUsername = false
    }

    private var _alreadySignedEmail by mutableStateOf(false)
    val alreadySignedEmail: Boolean get() = _alreadySignedEmail
    fun clearAlreadySignedEmail() {
        _alreadySignedEmail = false
    }


    private var _dialogString: DialogKind? by mutableStateOf(null)
    val dialog: DialogKind? get() = _dialogString
    fun hideDialog() {
        _dialogString = null

    }

    fun signIn(username: String, email: String, password: String) {
        _clientList.find { it.username == username }?.let { _alreadySignedUsername = true }
        _clientList.find { it.email == email }?.let { _alreadySignedEmail = true }
        if (_alreadySignedEmail || _alreadySignedUsername)
            _dialogString = DialogKind.ERROR
        else {
            _dialogString = DialogKind.CORRECT
            _clientList.add(Client(username, email, password))
        }
    }


    fun removeClient(username: String) {
        _clientList.removeIf { it.username == username }
    }

    fun removeCheckedProducts() {
        _clientList.removeIf { it.checked }
    }


    fun changeChecked(username: String) {
        val index = _clientList.indexOf(_clientList.find { it.username == username })
        _clientList[index] =
           _clientList[index].copy(checked = !_clientList[index].checked)
    }

}