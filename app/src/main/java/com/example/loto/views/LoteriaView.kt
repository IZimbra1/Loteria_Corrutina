import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoteriaView(viewModel: LoteriaViewModel) {
    val currentNumber by viewModel.currentNumber
    val isLoading by viewModel.isLoading

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        } else if (currentNumber != null) {
            Text(
                text = currentNumber.toString(),
                fontSize = 40.sp
            )
        } else {
            Text(text = "Loteria", fontSize = 40.sp)
        }

        Button(onClick = { viewModel.generateLotoNumbers() }) {
            Text(text = "Generar", fontSize = 20.sp)
        }
    }
}
