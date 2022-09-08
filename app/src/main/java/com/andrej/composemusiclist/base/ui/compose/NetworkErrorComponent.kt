package com.andrej.composemusiclist.base.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.andrej.composemusiclist.R
import com.andrej.composemusiclist.base.ui.theme.BrightBlue

@Composable
fun NetworkErrorComponent(showRetryButton: Boolean, onNetworkRetry: (() -> Unit)? = null) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(modifier = Modifier.fillMaxWidth(), text = stringResource(R.string.network_error), textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(16.dp))
            if (showRetryButton) {
                Button(
                    onClick = { onNetworkRetry?.invoke() },
                    colors = ButtonDefaults.buttonColors(backgroundColor = BrightBlue)
                ) {
                    Text(text = stringResource(R.string.try_again))
                }
            }
        }
    }
}