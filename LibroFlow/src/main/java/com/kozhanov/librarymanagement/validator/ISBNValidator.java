package com.kozhanov.librarymanagement.validator;

public class ISBNValidator {

    public static boolean isValidISBN(String isbn) {
        isbn = isbn.replace("-", "").replace(" ", ""); // Удаление дефисов и пробелов
        if (isbn.length() == 10) {
            return isValidISBN10(isbn);
        } else if (isbn.length() == 13) {
            return isValidISBN13(isbn);
        }
        return false;
    }

    private static boolean isValidISBN10(String isbn) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = isbn.charAt(i) - '0';
            if (0 > digit || 9 < digit) return false;
            sum += (digit * (10 - i));
        }

        char lastChar = isbn.charAt(9);
        if (lastChar != 'X' && (lastChar < '0' || lastChar > '9')) return false;

        sum += (lastChar == 'X') ? 10 : (lastChar - '0');

        return (sum % 11 == 0);
    }

    private static boolean isValidISBN13(String isbn) {
        int sum = 0;
        for (int i = 0; i < 13; i += 2) {
            sum += isbn.charAt(i) - '0';
        }
        for (int i = 1; i < 12; i += 2) {
            sum += (isbn.charAt(i) - '0') * 3;
        }

        return (sum % 10 == 0);
    }
}

