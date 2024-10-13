package bdd.step;

import bdd.page.DefinirViajePage;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebElement;
import java.util.List;

public class BuscarViajeStep {
        

        public DefinirViajePage obtenerDefinirViajePage(){
            return new DefinirViajePage();
        }

        public void stepInicializarNavegador(String URL) {
            // Write code here that turns the phrase above into concrete actions
            obtenerDefinirViajePage().inicializarNavegador(URL);
        }

        public void stepHacerClickEnCasillaDeOrigen(String searchString) {
            // Write code here that turns the phrase above into concrete actions
            obtenerDefinirViajePage().hacerClickEnCasilla(searchString);
        }
    
        public void el_usuario_escribe_city_un_lugar_de_site(String city, String site) {
            // Write code here that turns the phrase above into concrete actions
            obtenerDefinirViajePage().escribirViajeDeIda(city);
        }
        public void el_usuario_selecciona_el_site_del_viaje(String site) {
            // Write code here that turns the phrase above into concrete actions
            obtenerDefinirViajePage().obtenerListadoDeOrigen(site);

        }

        public void validarCiudadDeOrigen(String site) {

            List<WebElement> selectedCity = obtenerDefinirViajePage().obtenerListadoDeOrigen(site);
            // Write code here that turns the phrase above into concrete actions
            
            Assertions.assertNotEquals(0, selectedCity.size(), "No se encontró la ciudad de origen");

            Boolean found = false;
            for (WebElement option : selectedCity) {
                System.out.println(option.getText());
                if (option.getText().equals(site)) {
                    found = true;
                    break;
                }
            }

            Assertions.assertTrue(found, "No se encontró la ciudad de origen");
        }
    
}
