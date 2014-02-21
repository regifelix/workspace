package br.com.semanario.flow;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

import br.com.semanario.controller.UsuarioController;
import br.com.semanario.model.Usuario;

public class UsuarioFlowTest extends AbstractXmlFlowExecutionTests {
    private UsuarioController usuarioController;

    @Override
    protected void setUp() throws Exception {
        // configuracoes do mock - @Before
        usuarioController = mock(UsuarioController.class);
    }

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        // define qual flow sera testado
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/flows/usuario.xml");
    }

    @Override
    protected void configureFlowBuilderContext(MockFlowBuilderContext builderContext) {
        // registra beans que serao utilizados no flow
        builderContext.registerBean("usuarioController", usuarioController);
    }

    public void testTransicaoViewState() {
        // mock do contexto do flow
        MockExternalContext context = new MockExternalContext();
        startFlow(context);
        assertCurrentStateEquals("telaBusca");
        // testa transicao on buscar
        context.setEventId("buscar");
        resumeFlow(context);
        assertCurrentStateEquals("telaListagem");
        // testa voltar
        context.setEventId("voltar");
        resumeFlow(context);
        assertCurrentStateEquals("telaBusca");
    }

    public void testAcaoTransicao() {
        // configura mock
        Usuario usuario = new Usuario();
        when(usuarioController.getNewUsuario()).thenReturn(usuario);
        // mock do contexto do flow
        MockExternalContext context = new MockExternalContext();
        startFlow(context);
        assertCurrentStateEquals("telaBusca");
        // testa transicao on novo
        context.setEventId("novo");
        resumeFlow(context);
        assertCurrentStateEquals("telaDetalhe");
        // verifica se as acoes na transicao foram executadas
        verify(usuarioController).getNewUsuario();
        // asserts
        assertNotNull(getFlowAttribute("usuario"));
        assertEquals(usuario, getFlowAttribute("usuario"));
    }
}
