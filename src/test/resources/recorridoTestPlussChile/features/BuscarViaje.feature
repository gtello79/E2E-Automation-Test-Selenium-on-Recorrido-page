@buscarViaje
Feature: Buscar viaje en la pagina de Pluss Chile

    Scenario: Buscar un lugar de origen en la pagina de Pluss Chile "
        Given El usuario se encuentra en la pagina de Pluss Chile con "https://www.recorrido.cl/pluss-chile/es/"
        When el usuario selecciona el "origen" del viaje 
        And el usuario escribe "Ovalle" un lugar de "origen"
        Then el usuario valida la busqueda del lugar de "Ovalle"

