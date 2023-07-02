package com.haceb.stepDefinitions;

import com.haceb.pageObject.ProductosPage;
import com.haceb.pageObject.RegistroPage;
import com.haceb.steps.RegistroSteps;

import io.cucumber.java.es.*;

import net.thucydides.core.annotations.Steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class RegistoStepDefinition {

    @Steps
    RegistroSteps registroSteps;


    @Dado("que el usuario ingresa a la pagina haceb.com")
    public void queElUsuarioIngresaALaPaginaHacebComYLeDaEnLaOpcionDeRegistarse() {
        registroSteps.abrirNavegador();

    }

    @Cuando("el usuario llena el formulario de registro")
    public void elUsuarioLlenaElFormularioDeRegistro() throws IOException, InterruptedException {
        registroSteps.entrarPerfil();
        registroSteps.clickRegisrtro();
        registroSteps.clickBotonRegistrarse();
        registroSteps.Registro_Usuario();

    }

    @Entonces("el usuario visualiza informacion de su perfil.")
    public void elUsuarioVisualizaInformacionDeSuPerfil() {

    }

    @Y("Ingresamos los datos adicionales para terminar el registro")
    public void ingreamosLosDatosAdicionalesParaTerminarnarElRegistro(List<Map<String, String>> InformacionCNM) throws InterruptedException {
        registroSteps.datos_adicionales_usuario(InformacionCNM);
    }

    @Cuando("ingresa a categorias electrodomesticos de cocina")
    public void ingresaACategoriasElectrodomesticosDeCocina() {
        registroSteps.SelecionarCategoria();
    }

    @Y("selecciona una subcategoria agrega productos al carrito")
    public void seleccionaUnaSubcategoriaAgregaProductosAlCarrito() throws InterruptedException {
        registroSteps.compra_producto();


    }

    @Entonces("el usuario visualiza el campo de {string}")
    public void elUsuarioVisualizaElCampoDe(String arg0) {
       registroSteps.Irpagar(arg0);
    }
}
