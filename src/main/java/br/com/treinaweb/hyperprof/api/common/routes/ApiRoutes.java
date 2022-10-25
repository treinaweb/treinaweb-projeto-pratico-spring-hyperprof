package br.com.treinaweb.hyperprof.api.common.routes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiRoutes {

    public static final String ME = "/me";
    public static final String API = "/api";
    public static final String AUTH = "/auth";
    public static final String ALUNOS = "/alunos";
    public static final String PROFESSORES = "/professores";

    public static final String PROFESSOR_LOGADO = API + ME;

    public static final String LOGIN = API + AUTH + "/login";
    public static final String LOGOUT = API + AUTH + "/logout";
    public static final String REFRESH = API + AUTH + "/refresh";

    public static final String BUSCAR_PROFESSORES = API + PROFESSORES;
    public static final String CADASTRAR_PROFESSOR = API + PROFESSORES;
    public static final String ATUALIZAR_PROFESSOR_LOGADO = API + PROFESSORES;
    public static final String BUSCAR_PROFESSOR_POR_ID = API + PROFESSORES + "/{professorId}";

    public static final String CADASTRAR_ALUNO = API + PROFESSORES + "/{professorId}" + ALUNOS;

}
