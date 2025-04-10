package io.github.hotel.reservation.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.hotel.reservation.model.Reservation;
import io.github.hotel.reservation.service.HotelService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class HotelStepDefinitions {

    private HotelService hotelService;
    private String resultReservationId;
    private Reservation reservation;

    public HotelStepDefinitions() {
        this.hotelService = new HotelService();
    }

    @Given("des chambres existent dans l'hôtel")
    public void desChambresExistentDansHotel() {
    }

    @When("je recherche des chambres disponibles entre {string} et {string}")
    public void jeRechercheDesChambresDisponibles(String checkIn, String checkOut) {
    }

    @Then("les chambres disponibles sont affichées")
    public void lesChambresDisponiblesSontAffichees() {
    }

    @Given("une chambre est disponible")
    public void uneChambreEstDisponible() {
    }

    @When("je réserve la chambre avec les informations suivantes:")
    public void jeReserveLaChambreAvecLesInformations(io.cucumber.datatable.DataTable dataTable) {
    }

    @Then("la réservation est confirmée avec un ID unique")
    public void laReservationEstConfirmeeAvecUnIDUnique() {
    }

    @When("j'annule la réservation avec l'ID {string}")
    public void jAnnuleLaReservationAvecLID(String reservationId) {
    }

    @Then("la réservation est annulée")
    public void laReservationEstAnnulee() {
    }

    @When("je consulte les détails de la réservation avec l'ID {string}")
    public void jeConsulteLesDetailsDeLaReservationAvecLID(String reservationId) {
    }

    @Then("les détails de la réservation sont affichés")
    public void lesDetailsDeLaReservationSontAffiches() {
    }
}