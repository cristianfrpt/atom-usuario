Componente desenvolvido para simular o https://user-info.herokuapp.com/users/{cpf}

Atualmente não faz nenhuma validação do parâmetro, apenas randomiza um inteiro e compara com a porcentagem de bloqueio configurada no application.properties, caso o inteiro randomico for menor que a porcentagem retorna "UNABLE_TO_VOTE", caso não: "ABLE_TO_VOTE".


curl --location 'http://localhost:8082/users/"00"' \
--data ''
