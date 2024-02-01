package com.example.otpvalidator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.nativeKeyCode
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp

private var string = ""

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OtpComposableOutlined(
    widthInDp : Dp,
    heightInDp : Dp,
    backgroundColor : Color,
    passwordToggle : Boolean,
    focusColor : Color,
    unfocusColor: Color,
    cornerRadius : Dp,
    modifier: Modifier,
    horizontalArrangement: Arrangement.HorizontalOrVertical = Arrangement.SpaceEvenly,
    automaticCapture : Boolean? = false,
    otpComposableType : Int = ComposableType.TYPE_SIX,
    onvaluechange: (String) -> Unit
)
{
    var otp1 by remember { mutableStateOf("") }
    var otp2 by remember { mutableStateOf("") }
    var otp3 by remember { mutableStateOf("") }
    var otp4 by remember { mutableStateOf("") }
    var otp5 by remember { mutableStateOf("") }
    var otp6 by remember { mutableStateOf("") }

//    if (automaticCapture == true){
//        SmsRetrieverUserConsentBroadcast(smsCodeLength = otpComposableType){ message, code ->
//            otp1 = code[0].toString()
//            otp2 = code[1].toString()
//            otp3 = code[2].toString()
//            otp4 = code[3].toString()
//
//            if (otpComposableType != 4){
//                try {
//                    otp5 = code[4].toString()
//                    otp6 = code[5].toString()
//                    string = otp1+otp2+otp3+otp4+otp5+otp6
//                    onvaluechange(string)
//                }catch (e : Exception){
//                    e.toString()
//                }
//            }else{
//                string = otp1+otp2+otp3+otp4
//                onvaluechange(string)
//            }
//        }
//    }

    val (item1, item2, item3, item4, item5, item6) = remember { FocusRequester.createRefs() }
    val focusManager = LocalFocusManager.current

    Row(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement
    ) {
        OutlinedTextField(
            modifier = Modifier
                .size(widthInDp, heightInDp)
                .clip(RoundedCornerShape(cornerRadius))
                .focusRequester(item1)
                .background(color = backgroundColor)
                .onKeyEvent {
                    if (it.key.nativeKeyCode == 67) {
                        otp1 = ""
                        item1.freeFocus()
                        true
                    } else {
                        // let other handlers receive this event
                        false
                    }
                },
            value = otp1,
            maxLines = 1,
            singleLine = true,
            shape = RoundedCornerShape(cornerRadius),
            visualTransformation = if (passwordToggle) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Next
            ),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = focusColor,
                unfocusedBorderColor = unfocusColor
            ),
            onValueChange = {
                if (it.length == 1) {
                    otp1 = it
                    item2.requestFocus()
                }else {
                    otp1 = ""
                }
            },
        )
        OutlinedTextField(
            modifier = Modifier
                .size(widthInDp, heightInDp)
                .focusRequester(item2)
                .clip(RoundedCornerShape(cornerRadius))
                .background(color = backgroundColor)
                .onKeyEvent {
                    if (it.key.nativeKeyCode == 67) {
                        otp2 = ""
                        item1.requestFocus()
                        item2.freeFocus()
                        true
                    } else {
                        // let other handlers receive this event
                        false
                    }
                },
            value = otp2,
            maxLines = 1,
            singleLine = true,
            shape = RoundedCornerShape(cornerRadius),
            visualTransformation = if (passwordToggle) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Next
            ),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = focusColor,
                unfocusedBorderColor = unfocusColor
            ),
            onValueChange = {
                if (it.length == 1) {
                    otp2 = it
                    item2.freeFocus()
                    item3.requestFocus()
                }
            },
        )
        OutlinedTextField(
            modifier = Modifier
                .size(widthInDp, heightInDp)
                .focusRequester(item3)
                .clip(RoundedCornerShape(cornerRadius))
                .background(backgroundColor)
                .onKeyEvent {
                    if (it.key.nativeKeyCode == 67) {
                        otp3 = ""
                        item2.requestFocus()
                        item3.freeFocus()
                        true
                    } else {
                        // let other handlers receive this event
                        false
                    }
                },
            value = otp3,
            maxLines = 1,
            singleLine = true,
            shape = RoundedCornerShape(cornerRadius),
            visualTransformation = if (passwordToggle) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Next
            ),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = focusColor,
                unfocusedBorderColor = unfocusColor
            ),
            onValueChange = {
                if (it.length == 1) {
                    otp3 = it
                    item3.freeFocus()
                    item4.requestFocus()
                }
            },
        )
        OutlinedTextField(
            modifier = Modifier.size(widthInDp, heightInDp)
                .focusRequester(item4)
                .clip(RoundedCornerShape(cornerRadius))
                .background(backgroundColor)
                .onKeyEvent {
                    if (it.key.nativeKeyCode == 67) {
                        otp4 = ""
                        item3.requestFocus()
                        item4.freeFocus()
                        true
                    } else {
                        // let other handlers receive this event
                        false
                    }
                },
            value = otp4,
            maxLines = 1,
            singleLine = true,
            shape = RoundedCornerShape(cornerRadius),
            visualTransformation = if (passwordToggle) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Go
            ),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = focusColor,
                unfocusedBorderColor = unfocusColor
            ),
            onValueChange = {
                if (it.length == 1) {
                    otp4 = it
                    if (otpComposableType != 4) {
                        item5.requestFocus()
                    } else {
                        string = otp1 + otp2 + otp3 + otp4
                        onvaluechange(string)
                        focusManager.clearFocus()
                    }
                } else {
                    otp4 = ""
                }
            },
        )

        if (otpComposableType != 4) {
            OutlinedTextField(
                modifier = Modifier
                    .size(widthInDp, heightInDp)
                    .focusRequester(item5)
                    .clip(RoundedCornerShape(cornerRadius))
                    .background(backgroundColor)
                    .onKeyEvent {
                        if (it.key.nativeKeyCode == 67) {
                            otp5 = ""
                            item4.requestFocus()
                            item5.freeFocus()
                            true
                        } else {
                            // let other handlers receive this event
                            false
                        }
                    },
                value = otp5,
                maxLines = 1,
                singleLine = true,
                shape = RoundedCornerShape(cornerRadius),
                visualTransformation = if (passwordToggle) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = ImeAction.Next
                ),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = focusColor,
                    unfocusedBorderColor = unfocusColor
                ),
                onValueChange = {
                    if (it.length == 1) {
                        otp5 = it
                        if (otpComposableType != 4) {
                            item6.requestFocus()
                        }
                    } else {
                        otp5 = ""
                    }
                },
            )
            OutlinedTextField(
                modifier = Modifier.size(widthInDp, heightInDp)
                    .focusRequester(item6)
                    .clip(RoundedCornerShape(cornerRadius))
                    .background(backgroundColor)
                    .onKeyEvent {
                        if (it.key.nativeKeyCode == 67) {
                            otp6 = ""
                            item5.requestFocus()
                            item6.freeFocus()
                            true
                        } else {
                            // let other handlers receive this event
                            false
                        }
                    },
                value = otp6,
                maxLines = 1,
                singleLine = true,
                shape = RoundedCornerShape(cornerRadius),
                visualTransformation = if (passwordToggle) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = ImeAction.Go
                ),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = focusColor,
                    unfocusedBorderColor = unfocusColor
                ),
                onValueChange = {

                    if (it.length == 1) {
                        otp6 = it
                        if (otpComposableType != 4) {
                            otp6 = it
                            string = otp1 + otp2 + otp3 + otp4 + otp5 + otp6
                            onvaluechange(string)
                            focusManager.clearFocus()
                        }
                    } else {
                        otp6 = ""
                    }
                },
            )
        }
    }
}