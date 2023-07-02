package com.haceb.pageObject;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import java.util.Set;


public class RegistroPage extends PageObject {
    By txtUsuario = By.xpath("//a/span[@class='icon-user']");
    By btnRegistro = By.xpath("//a[@class='cdc-fire cdc-register']");

    By btnRegistrarse = By.xpath("//button[@Id='vtexIdUI-custom-oauth']");
    By Campo_correo_electronico = By.cssSelector("[placeholder='Correo electrónico *']");
    By Campo_nombre = By.cssSelector("[placeholder='Nombre *']");
    By Campo_apellido = By.cssSelector("[placeholder='Apellido *']");
    By Campo_contrasena = By.cssSelector("[placeholder='Contraseña *']");
    By Campo_confirmar_contrasena = By.cssSelector("[placeholder='Confirma la contraseña *']");
    By Terminos_condiciones = By.cssSelector("[for='gigya-checkbox-70031539084410860']>[data-screenset-roles='instance,template']");
    By Check_autorizacion = By.cssSelector("[data-translation-key='MULTICHOICE_109350074984747230_CHOICES_B326B5062B2F0E69046810717534CB09'][data-screenset-roles='template,instance,instance']");
    By Boton_registrarme = By.cssSelector("[value='REGISTRARME']");
    By Campo_cedula = By.cssSelector("[placeholder='Ingrese su documento de identidad *']");
    By Genero = By.cssSelector("[name='profile.gender'][aria-required='true']");

    By Fecha_nacimiento = By.cssSelector("[name='data.fechaNacimiento'][aria-invalid='false']");

    By Numero_contacto = By.cssSelector("[placeholder='Numero de contacto']");




    By Boton_enviar = By.cssSelector("[value='Enviar']");


    public By getTxtUsuario() {
        return txtUsuario;
    }

    public By getBtnRegistro() {
        return btnRegistro;
    }

    public By getBtnRegistrarse() {
        return btnRegistrarse;
    }

    public By getCampo_correo_electronico() {
        return Campo_correo_electronico;
    }

    public By getCampo_nombre() {
        return Campo_nombre;
    }

    public By getCampo_apellido() {
        return Campo_apellido;
    }

    public By getCampo_contrasena() {
        return Campo_contrasena;
    }

    public By getCampo_confirmar_contrasena() {
        return Campo_confirmar_contrasena;
    }

    public By getTerminos_condiciones() {
        return Terminos_condiciones;
    }

    public By getCheck_autorizacion() {
        return Check_autorizacion;
    }

    public By getBoton_registrarme() {
        return Boton_registrarme;
    }

    public By getCampo_cedula() {
        return Campo_cedula;
    }

    public By getGenero() {
        return Genero;
    }

    public By getFecha_nacimiento() {
        return Fecha_nacimiento;
    }


    public void cambioAVentanaEmergente() {
        Set<String> ventanas = getDriver().getWindowHandles();
        for (String ventana : ventanas) {
            getDriver().switchTo().window(ventana);
        }
    }




    public By getNumero_contacto() {
        return Numero_contacto;
    }

    public void setNumero_contacto(By numero_contacto) {
        Numero_contacto = numero_contacto;
    }




    public By getBoton_enviar() {
        return Boton_enviar;
    }



}
