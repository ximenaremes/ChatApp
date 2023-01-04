package com.example.chatapp.utils

import com.example.chatapp.R


enum class  ErrorMessage(val stringResource: Int) {
    VALID_NAME(R.string.textErroName),
    VALID_EMAIL(R.string.textErroEmail),
    VALID_EMAIL_CHARACTERS(R.string.textErroEmailCharacters),
    VALID_PASSWORD(R.string.textErroPassword),
    VALID_PASSWORD_LENGTH(R.string.textErroPasswordLength),
    VALID_PASSWORD_CHARACTERS(R.string.textErroPasswordCharacters),
    VALID_CONFIRM_PASSWORD(R.string.textErroConfPassword),
    VALID_CONFIRM_PASSWORD_IDENTICAL(R.string.textErroConfPasswordIdentical)

}