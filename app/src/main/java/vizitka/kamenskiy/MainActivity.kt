package vizitka.kamenskiy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                    VizitkaText(
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
fun VizitkaText(
    phoneNumber: String,
    username: String,
    email: String,
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier.weight(1f))

        CenterText(
            fullName = fullName,
            title = title,
            modifier = Modifier
        )

        Spacer(modifier.weight(1f))
        BottomText(
            phoneNumber = phoneNumber,
            username = username,
            email = email,
            modifier = Modifier
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
        PersonImage()
        Text(
            text = fullName,
            fontWeight = FontWeight.Bold,
            fontSize = 44.sp,
            lineHeight = 40.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun BottomText(
    phoneNumber: String,
    username: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .padding(bottom = 30.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(bottom = 10.dp)
        ) {
            PhoneImage()
            Text(
                text = phoneNumber,
                color = Color(0xFF3ddc84),
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(bottom = 10.dp)
        ) {
            UsernameImage()
            Text(
                text = username,
                color = Color(0xFF3ddc11)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(bottom = 10.dp)
        ) {
            EmailImage()
            Text(
                text = email,
            )
        }
    }
}

@Composable
fun PhoneImage(modifier : Modifier = Modifier) {
    val phoneImage = painterResource(R.drawable.phone_icon)

    Image(
        painter = phoneImage,
        contentDescription = null,
    )
}

@Composable
fun UsernameImage(modifier : Modifier = Modifier) {
    val usernameImage = painterResource(R.drawable.username_icon)

    Image(
        painter = usernameImage,
        contentDescription = null,
    )
}

@Composable
fun EmailImage(modifier : Modifier = Modifier) {
    val emailImage = painterResource(R.drawable.email_icon)

    Image(
        painter = emailImage,
        contentDescription = null,
    )
}

@Composable
fun PersonImage(modifier: Modifier = Modifier) {
    val personImage = painterResource(R.drawable.person_icon)

    Image(
        painter = personImage,
        contentDescription = null,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VizitkaTheme {
        VizitkaText(
            phoneNumber = stringResource(R.string.phone_string),
            username = stringResource(R.string.username_string),
            email = stringResource(R.string.email_string),
            fullName = stringResource(R.string.name_string),
            title = stringResource(R.string.title_string)
        )
    }
}