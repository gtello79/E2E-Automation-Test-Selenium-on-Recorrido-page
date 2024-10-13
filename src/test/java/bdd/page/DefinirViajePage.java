package bdd.page;

import webdriver.DOM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DefinirViajePage extends DOM {

    @FindBy(id = "bus_travel_departure_city_id-selectized") WebElement origin_input;

    @FindBy(css = "div.bus_travel_departure_city div.city-input .selectize-control .selectize-dropdown .selectize-dropdown-content div.option") List<WebElement> origin_options;

    public void hacerClickEnCasilla(String searched_trip) {

        onclick(origin_input);
    }

    public void escribirViajeDeIda(String searched_trip) {
        origin_input.sendKeys(searched_trip);
    }

    public List<WebElement> obtenerListadoDeOrigen(String searchString) {
        return origin_options;
    }

    public void inicializarNavegador(String URL) {
        iniciarNavegador(URL);
    }
}