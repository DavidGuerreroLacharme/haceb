package com.haceb.steps;

import com.haceb.pageObject.ProductosPage;
import com.haceb.pageObject.RegistroPage;
import com.haceb.utils.LeerExcel;

import net.thucydides.core.annotations.Step;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;
import static net.serenitybdd.core.Serenity.getDriver;

public class RegistroSteps {

    RegistroPage registroPage = new RegistroPage();
    ProductosPage producto = new ProductosPage();
    LeerExcel leer = new LeerExcel();
    public static final String CEDULA = "Cedula";
    public static final String GENERO = "Genero";
    public static final String FECHA_NACIMIENTO = "Fecha_nacimiento";
    public static final String CODIGO = "Codigo";
    public static final String NUMERO_CONTACTO = "Numero_contacto";
    public static final String DEPARTAMENTO = "Departamento";
    public static final String CIUDAD = "Ciudad";


    @Step("El usuario abre el navegador")

    public void abrirNavegador() {
        registroPage.openUrl("https://www.haceb.com/");
    }

    @Step("El usuario da clic en perfil")
    public void entrarPerfil() {
        registroPage.getDriver().findElement(registroPage.getTxtUsuario()).click();
    }

    @Step("El usuario da clic en el boton registro")
    public void clickRegisrtro() {
        registroPage.getDriver().findElement(registroPage.getBtnRegistro()).click();
    }

    @Step("El usuario da clic en el boton Registrarse")
    public void clickBotonRegistrarse() {
        registroPage.getDriver().findElement(registroPage.getBtnRegistrarse()).click();

        registroPage.cambioAVentanaEmergente();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("el usuario llena el formulario de registro")
    public void Registro_Usuario() throws IOException, InterruptedException {
        String filepath = "src\\test\\resources\\Data\\Datos_registro.xlsx";
        String Correo = leer.getCellValue(filepath, "registro", 1, 0);
        registroPage.getDriver().findElement(registroPage.getCampo_correo_electronico()).sendKeys(Correo);
        String nombre = leer.getCellValue(filepath, "registro", 1, 1);
        registroPage.getDriver().findElement(registroPage.getCampo_nombre()).sendKeys(nombre);
        String apellido = leer.getCellValue(filepath, "registro", 1, 2);
        registroPage.getDriver().findElement(registroPage.getCampo_apellido()).sendKeys(apellido);
        String contrasena = leer.getCellValue(filepath, "registro", 1, 3);
        registroPage.getDriver().findElement(registroPage.getCampo_contrasena()).sendKeys(contrasena);
        String ConContrasena = leer.getCellValue(filepath, "registro", 1, 4);
        registroPage.getDriver().findElement(registroPage.getCampo_confirmar_contrasena()).sendKeys(ConContrasena);
        Thread.sleep(5000);
        //registroPage.getDriver().findElement(registroPage.getTerminos_condiciones()).click();
        registroPage.getDriver().findElement(registroPage.getCheck_autorizacion()).click();
        registroPage.getDriver().findElement(registroPage.getBoton_registrarme()).click();

        Thread.sleep(5000);

    }

    @Step("Ingreamos los datos adicionales para terminarnar el registro")
    public void datos_adicionales_usuario(List<Map<String, String>> InformacionCNM) throws InterruptedException {


        registroPage.getDriver().findElement(registroPage.getCampo_cedula()).sendKeys(InformacionCNM.get(0).get(CEDULA));

        registroPage.getDriver().findElement(registroPage.getGenero()).click();
        Select Genero = new Select(getDriver().findElement(By.cssSelector("[name='profile.gender'][aria-required='true']")));
        Genero.selectByVisibleText(InformacionCNM.get(0).get(GENERO));

        registroPage.getDriver().findElement(registroPage.getFecha_nacimiento()).sendKeys(InformacionCNM.get(0).get(FECHA_NACIMIENTO));

        Select Codigo = new Select(getDriver().findElement(By.xpath("/html/body/div[5]/div[2]/div/form/div[1]/div[6]/fieldset/select")));
        Codigo.selectByValue(InformacionCNM.get(0).get(CODIGO));

        registroPage.getDriver().findElement(registroPage.getNumero_contacto()).sendKeys(InformacionCNM.get(0).get(NUMERO_CONTACTO));

        Select Departamento = new Select(getDriver().findElement(By.cssSelector("[name='data.region'][aria-required='false']")));
        Departamento.selectByVisibleText(InformacionCNM.get(0).get(DEPARTAMENTO));

        Select Ciudad = new Select(getDriver().findElement(By.cssSelector("[name='profile.city'][aria-required='false']")));
        Ciudad.selectByVisibleText(InformacionCNM.get(0).get(CIUDAD));
        registroPage.getDriver().findElement(registroPage.getBoton_enviar()).click();

        Thread.sleep(50000);


    }

    @Step("ingresa a categorias electrodomesticos de cocina")
    public void SelecionarCategoria() {
        registroPage.getDriver().findElement(producto.getBotonCategorias()).click();
    }

    @Step("selecciona una subcategoria agrega productos al carrito")
    public void compra_producto() throws InterruptedException {
        registroPage.getDriver().findElement(producto.getElectronicos_cocina()).click();
        Thread.sleep(2000);
        registroPage.getDriver().findElement(producto.getEstufas()).click();
        Thread.sleep(2000);
        registroPage.getDriver().findElement(producto.getProducto()).click();
        registroPage.getDriver().findElement(producto.getBoton_comprar()).click();
        Thread.sleep(2000);
        registroPage.getDriver().findElement(producto.getBoton_ir_pagar()).click();
    }

    @Step("el usuario visualiza el campo de ir a pagar")
    public void Irpagar(String datos) {
        String text = registroPage.getDriver().findElement(producto.getCampo_entrega()).getText();
        assertEquals(datos, text);
        System.out.println("Productos agregados existosamente al carrito de compras");
    }

}

