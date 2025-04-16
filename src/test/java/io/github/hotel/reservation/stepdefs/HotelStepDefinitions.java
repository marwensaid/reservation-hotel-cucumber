package io.github.hotel.reservation.stepdefs;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import io.github.hotel.reservation.model.Reservation;
import io.github.hotel.reservation.service.HotelService;
import org.junit.runner.RunWith;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@CucumberContextConfiguration
public class HotelStepDefinitions {

    private HotelService hotelService;
    private String resultReservationId;
    private Reservation reservation;

    public HotelStepDefinitions() {
        this.hotelService = new HotelService();
    }

    @Given("des chambres existent dans l'hôtel")
    public void desChambresExistentDansHotel() {
        assertNotNull(hotelService.findAvailableRooms(LocalDate.now(), LocalDate.now().plusDays(1)));
    }

    @When("je recherche des chambres disponibles entre {string} et {string}")
    public void jeRechercheDesChambresDisponibles(String checkIn, String checkOut) {
        assertFalse(hotelService.findAvailableRooms(LocalDate.parse(checkIn), LocalDate.parse(checkOut)).isEmpty());
    }

    @Then("les chambres disponibles sont affichées")
    public void lesChambresDisponiblesSontAffichees() {
        assertFalse(hotelService.findAvailableRooms(LocalDate.now(), LocalDate.now().plusDays(1)).isEmpty());
    }

    @Given("une chambre est disponible")
    public void uneChambreEstDisponible() {
        assertNotNull(hotelService.findAvailableRooms(LocalDate.now(), LocalDate.now().plusDays(1)).get(0));
    }

    @When("je réserve la chambre avec les informations suivantes:")
    public void jeReserveLaChambreAvecLesInformations(io.cucumber.datatable.DataTable dataTable) {
        resultReservationId = hotelService.reserveRoom("John Doe", "john.doe@gmail.com", "101",
                LocalDate.now(), LocalDate.now().plusDays(1));
    }

    @Then("la réservation est confirmée avec un ID unique")
    public void laReservationEstConfirmeeAvecUnIDUnique() {
        assertNotNull(resultReservationId);
    }

    @When("j'annule la réservation avec l'ID {string}")
    public void jAnnuleLaReservationAvecLID(String reservationId) {
        assertTrue(hotelService.cancelReservation(reservationId));
    }

    @Then("la réservation est annulée")
    public void laReservationEstAnnulee() {
        assertNull(hotelService.getReservation(resultReservationId));
    }

    @When("je consulte les détails de la réservation avec l'ID {string}")
    public void jeConsulteLesDetailsDeLaReservationAvecLID(String reservationId) {
        reservation = hotelService.getReservation(reservationId);
    }

    @Then("les détails de la réservation sont affichés")
    public void lesDetailsDeLaReservationSontAffiches() {
        assertNotNull(reservation);
    }
}