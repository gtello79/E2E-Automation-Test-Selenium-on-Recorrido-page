package recorridoTestPlussChile.stepdefinition;
import bdd.step.BuscarViajeStep;
import webdriver.DOM;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class BuscarViajeStepDefinition{
    
    private BuscarViajeStep buscarViajeStep = new BuscarViajeStep();

    @After
    public void afterScenario(){
        DOM.close();
    }

    @Given("El usuario se encuentra en la pagina de Pluss Chile con {string}")
    public void que_el_usuario_se_encuentra_en_la_pagina_de_Pluss_Chile(String URL) {
        // Write code here that turns the phrase above into concrete actions
        buscarViajeStep.stepInicializarNavegador(URL);
    }

    @When("el usuario selecciona el {string} del viaje")
    public void el_usuario_selecciona_el_site_del_viaje(String site) {
        // Write code here that turns the phrase above into concrete actions
        buscarViajeStep.stepHacerClickEnCasillaDeOrigen(site);
    }

    @When("el usuario escribe {string} un lugar de {string}")
    public void el_usuario_escribe_city_un_lugar_de_site(String city, String site) {
        // Write code here that turns the phrase above into concrete actions
        buscarViajeStep.el_usuario_escribe_city_un_lugar_de_site(city, site);
    }

    @Then("el usuario valida la busqueda del lugar de {string}")
    public void el_usuario_valida_que_la_ciudad_de_origen_sea(String site) {
        // Write code here that turns the phrase above into concrete actions
        buscarViajeStep.validarCiudadDeOrigen(site);
    }
    


}