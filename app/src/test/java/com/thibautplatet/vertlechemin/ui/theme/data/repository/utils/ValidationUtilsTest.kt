package com.thibautplatet.vertlechemin.ui.theme.data.repository.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Rules of the sign-in and registration forms.
 * Runs on the JVM: the cases below never reach android.util.Patterns.
 */
class ValidationUtilsTest {

    @Test
    fun passwordShorterThanSixCharactersIsRejected() {
        assertFalse(ValidationUtils.isValidPassword(""))
        assertFalse(ValidationUtils.isValidPassword("12345"))
    }

    @Test
    fun passwordOfSixCharactersOrMoreIsAccepted() {
        assertTrue(ValidationUtils.isValidPassword("123456"))
        assertTrue(ValidationUtils.isValidPassword("a longer passphrase"))
    }

    @Test
    fun passwordErrorMessageExplainsWhatIsWrong() {
        assertEquals("Le mot de passe ne peut pas être vide", ValidationUtils.getPasswordErrorMessage(""))
        assertEquals("Le mot de passe doit avoir au moins 6 caractères", ValidationUtils.getPasswordErrorMessage("abc"))
        assertNull(ValidationUtils.getPasswordErrorMessage("abcdef"))
    }

    @Test
    fun emptyEmailIsRejectedWithItsOwnMessage() {
        assertFalse(ValidationUtils.isValidEmail(""))
        assertEquals("L'email ne peut pas être vide", ValidationUtils.getEmailErrorMessage(""))
    }
}
