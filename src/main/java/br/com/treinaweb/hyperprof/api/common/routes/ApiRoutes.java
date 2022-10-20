package br.com.treinaweb.hyperprof.api.common.routes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiRoutes {

    public static final String API = "/api";
    public static final String PROFESSORES = "/professores";

    public static final String BUSCAR_PROFESSORES = API + PROFESSORES;
    public static final String BUSCAR_PROFESSOR_POR_ID = API + PROFESSORES + "/{professorId}";

}
