package com.kh.app.exception;

public class EmpJoinExceptions {
    public static class IdAlreadyExistsException extends RuntimeException {
        public IdAlreadyExistsException(String message) {
            super(message);
        }
    }

    public static class InvalidIdFormatException extends RuntimeException {
        public InvalidIdFormatException(String message) {
            super(message);
        }
    }

    public static class PasswordMismatchException extends RuntimeException {
        public PasswordMismatchException(String message) {
            super(message);
        }
    }

    public static class WeakPasswordException extends RuntimeException {
        public WeakPasswordException(String message) {
            super(message);
        }
    }

    public static class NicknameAlreadyExistsException extends RuntimeException {
        public NicknameAlreadyExistsException(String message) {
            super(message);
        }
    }

    public static class InvalidNicknameFormatException extends RuntimeException {
        public InvalidNicknameFormatException(String message) {
            super(message);
        }
    }
}
