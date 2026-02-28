package vizitka.kamenskiy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vizitka.kamenskiy.ui.theme.VizitkaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VizitkaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    VizitkaCard(
                        phoneNumber = stringResource(R.string.phone_string),
                        username = stringResource(R.string.username_string),
                        email = stringResource(R.string.email_string),
                        fullName = stringResource(R.string.name_string),
                        title = stringResource(R.string.title_string)
                    )
                }
            }
        }
    }
}

@Composable
fun VizitkaCard(
    phoneNumber: String,
    username: String,
    email: String,
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier.weight(1f))

        CenterText(
            fullName = fullName,
            title = title,
            modifier = Modifier
        )

        Spacer(modifier.weight(1f))
        BottomInfo(
            phoneNumber = phoneNumber,
            username = username,
            email = email,
            modifier = Modifier
                .padding(bottom = 10.dp)
        )
    }
}

@Composable
fun CenterText(
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        IconImage(
            R.drawable.person_icon,
        )
        Text(
            text = fullName,
            fontWeight = FontWeight.Thin,
            fontSize = 44.sp,
            lineHeight = 40.sp,
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
        )
    }
}

@Composable
fun BottomInfo(
    phoneNumber: String,
    username: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        BottomInfoRow(phoneNumber, R.drawable.phone_icon, 0xFF3dda00, modifier)
        BottomInfoRow(username, R.drawable.username_icon, 0xFF3dda11, modifier)
        BottomInfoRow(email, R.drawable.email_icon, 0xFF3dda99, modifier)
    }
}

@Composable
fun BottomInfoRow(
    text: String,
    @DrawableRes id : Int,
    color : Long,
    modifier : Modifier = Modifier)
{
    Row(
        modifier = modifier
    ) {
        IconImage(id)
        Text(
            text = text,
            color = Color(color),
            modifier = modifier
                .padding(start = 10.dp)
        )
    }
}

@Composable
fun IconImage(@DrawableRes id: Int, modifier : Modifier = Modifier) {
    val image = painterResource(id)

    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VizitkaTheme {
        VizitkaCard(
            phoneNumber = stringResource(R.string.phone_string),
            username = stringResource(R.string.username_string),
            email = stringResource(R.string.email_string),
            fullName = stringResource(R.string.name_string),
            title = stringResource(R.string.title_string)
        )
    }
}