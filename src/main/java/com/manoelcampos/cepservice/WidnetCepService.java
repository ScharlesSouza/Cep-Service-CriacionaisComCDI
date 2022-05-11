package com.manoelcampos.cepservice;

import javax.enterprise.context.Dependent;

@Dependent
public final class WidnetCepService extends AbstractCepService {
    /**
     * Instancia o serviço de CEP, definindo a URL base para acesso.
     * O construtor é protegido, pois, não queremos que quem for utilizar
     * as subclasses desta, possa indicar o domínio.
     * Classes filhas como {@link ViaCepService} são utilizadas para acesso
     * a um serviço específico, cujo domínio é definida pela própria subclasse.
     * Quem for utilizar tal subclasse não deve ter permissão para alterar o domínio.
     *
     * @param dominio domínio para acesso ao serviço
     * @return
     */
    private static final String DOMINIO = "https://apps.widenet.com.br/";

    /**
     * Define um construtor padrão que não aceita parâmetros.
     * Ele apenas chama o construtor protegido na superclasse,
     * passando o domínio do serviço a ser acessado.
     * O construtor da superclasse não é incluído aqui pois
     * não queremos que quem for utilizar tal classe,
     * possa chamar aquele construtor.
     * Se tal construtor fosse adicionado,
     * o usuário da classe poderia instanciá-la, indicando um domínio diferente
     * para o serviço. No entanto, o domínio e fixo, logo, não deve ser alterado.
     */
    public WidnetCepService(){
        super(DOMINIO);
    }

    @Override
    protected String buildPath(final String cep) {
        return "busca-cep/api/cep.json?code=" + cep;
    }
}
