package com.haceb.pageObject;

import org.openqa.selenium.By;

public class ProductosPage {

    By BotonCategorias = By.xpath("/html/body/header/div[3]/div/nav/ul[1]/div[1]/li[1]/a");
    By Electronicos_cocina = By.xpath("/html/body/header/div[3]/div/nav/ul[2]/li[4]/a");
    By Estufas = By.xpath("/html/body/div[4]/div/div[5]/div[2]/div/div/h2/a");
    By producto = By.xpath("/html/body/div[4]/div[6]/div[2]/div[1]/ul/li[2]/div/div[2]/a/div/div[1]/img");
    By Boton_comprar = By.xpath("/html/body/div[5]/div[3]/div[2]/div[1]/div[4]/div[8]/a");
    By Boton_ir_pagar = By.xpath("/html/body/header/div[2]/div[6]/div[4]/div[1]/div[2]/a");
 By Mi_carrito = By.xpath("/html/body/header/div[2]/div[6]/div[4]/span/p");
     private By Campo_entrega = By.xpath("/html/body/div[5]/div[3]/div[1]/div[2]/div/div[2]/div[2]/div/h2");



    public By getBotonCategorias() {
        return BotonCategorias;
    }

    public By getElectronicos_cocina() {
        return Electronicos_cocina;
    }

    public By getEstufas() {
        return Estufas;
    }

    public By getProducto() {
        return producto;
    }

    public By getBoton_comprar() {
        return Boton_comprar;
    }

    public By getBoton_ir_pagar() {
        return Boton_ir_pagar;
    }

    public By getMi_carrito() {
        return Mi_carrito;
    }

    public By getCampo_entrega() {
        return Campo_entrega;
    }
}
