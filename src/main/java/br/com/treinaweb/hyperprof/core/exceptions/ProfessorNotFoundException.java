package br.com.treinaweb.hyperprof.core.exceptions;

public class ProfessorNotFoundException extends ModelNotFoundException {

    public ProfessorNotFoundException() {
        super("Professor não econtrado");
    }

    public ProfessorNotFoundException(String message) {
        super(message);
    }

}
