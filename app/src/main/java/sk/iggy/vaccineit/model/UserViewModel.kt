package sk.iggy.vaccineit.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    private val _id = MutableLiveData("")
    val id: LiveData<String> get() = _id

    private val _fullname = MutableLiveData("")
    val fullname: LiveData<String> get() = _fullname

    private val _email = MutableLiveData("")
    val email: LiveData<String> get() = _email

    private val _phone = MutableLiveData("")
    val phone: LiveData<String> get() = _phone

    private val _vaccineType = MutableLiveData("")
    val vaccineType: LiveData<String> get() = _vaccineType

    private val _birthday = MutableLiveData("")
    val birthday: LiveData<String> get() = _birthday

    fun setId(userId: String) {
        if (userId.length == 10) {
            _id.value = userId
        }
    }

    fun setFullname(firstName: String, lastname: String) {
        _fullname.value = "$firstName $lastname"
    }

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPhone(phone: String) {
        _phone.value = phone
    }

    fun setBirthday(date: String) {
        _birthday.value = date
    }

    fun setVaccineType(vaccineType: String) {
        _vaccineType.value = vaccineType
    }
}