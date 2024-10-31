import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoteriaViewModel : ViewModel() {
    private val _currentNumber = mutableStateOf<Int?>(null)
    val currentNumber: State<Int?> = _currentNumber

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun generateLotoNumbers() {
        viewModelScope.launch {
            val numbers = (1..60).shuffled().take(6).sorted()
            for (number in numbers) {
                _isLoading.value = true // Muestra el indicador de carga
                delay(2000) // Espera de 2 segundos para mostrar el indicador
                _isLoading.value = false // Oculta el indicador de carga
                _currentNumber.value = number // Muestra el número actual
                delay(2000) // Muestra el número durante 2 segundos
            }
            _currentNumber.value = null // Limpia el número actual
        }
    }
}
