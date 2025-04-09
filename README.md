Gestion des Réservations d'Hôtel

#### **Introduction**
Ce TD vous permettra de pratiquer le **TDD** et d'écrire des tests comportementaux en utilisant **Cucumber** pour une application de gestion des réservations d'hôtel. L'objectif est de développer une application qui permet :
1. De rechercher des chambres disponibles.
2. De réserver une chambre.
3. D'annuler une réservation.
4. De consulter les détails d'une réservation.

Vous commencerez par écrire des **scénarios Gherkin** pour définir le comportement attendu, puis vous implémenterez les tests et le code correspondant.

---

### **Objectifs pédagogiques**
1. Comprendre et pratiquer le **Behavior-Driven Development (BDD)** avec Cucumber.
2. Appliquer les principes du **Test-Driven Development (TDD)**.
3. Apprendre à écrire des scénarios Gherkin en langage naturel.
4. Construire une application Spring Boot basée sur des tests comportementaux.

---

### **Contexte et Description de l'Application**

L'application est un système de gestion des réservations d'hôtel. Elle doit permettre aux utilisateurs de :
1. **Rechercher des chambres disponibles** : À partir d'une date d'arrivée et d'une date de départ, l'utilisateur peut connaître les chambres disponibles.
2. **Réserver une chambre** : L'utilisateur peut réserver une chambre en fournissant son nom, son email et les détails de la réservation (dates, numéro de chambre).
3. **Annuler une réservation** : L'utilisateur peut annuler une réservation à l'aide de son ID de réservation.
4. **Consulter les détails d'une réservation** : L'utilisateur peut consulter les informations d'une réservation existante.

---

### **Architecture et Détails Techniques**

#### 1. **Architecture**
- `Controller` : Gère les requêtes HTTP.
- `Service` : Contient la logique métier.
- `Repository` : Gère les données en mémoire (ou dans une base de données).

#### 2. **Technologies**
- **Langage** : Java
- **Framework** : Spring Boot
- **BDD Framework** : Cucumber
- **Tests Unitaires/Intégration** : JUnit 5
- **Build Tool** : Maven

---

### **Consignes**

1. **Étape 1 : Configurer Cucumber**
   - Ajoutez les dépendances Maven nécessaires pour utiliser Cucumber avec Spring Boot.
   - Configurez un fichier `features` pour écrire les scénarios Gherkin.

2. **Étape 2 : Écrire des Scénarios Gherkin**
   - Écrivez des scénarios pour chaque fonctionnalité dans un langage naturel (Given, When, Then).

3. **Étape 3 : Implémenter les Tests**
   - Implémentez les **Step Definitions** pour chaque étape des scénarios.
   - Écrivez les tests associés en utilisant Cucumber.

4. **Étape 4 : Développer l'Application**
   - Implémentez le code nécessaire pour passer les tests.
   - Respectez le cycle TDD : **Test rouge → Implémentation → Test vert → Refactorisation**.

5. **Étape 5 : Exécuter les Tests**
   - Vérifiez que tous les tests passent avec succès.
   - Ajoutez des validations supplémentaires si nécessaire.

---

### **Scénarios Gherkin**

Créez un fichier `hotel_reservations.feature` pour définir les scénarios suivants.

````gherkin name=src/test/resources/features/hotel_reservations.feature
Feature: Gestion des réservations d'hôtel
  En tant qu'utilisateur,
  Je veux pouvoir gérer des réservations d'hôtel
  Afin de réserver et consulter mes séjours.

  Scenario: Rechercher des chambres disponibles
    Given des chambres existent dans l'hôtel
    When je recherche des chambres disponibles entre "2025-05-01" et "2025-05-05"
    Then les chambres disponibles sont affichées

  Scenario: Réserver une chambre
    Given une chambre est disponible
    When je réserve la chambre avec les informations suivantes:
      | Nom       | Email                | Date d'arrivée | Date de départ |
      | John Doe  | john.doe@gmail.com   | 2025-05-01     | 2025-05-05     |
    Then la réservation est confirmée avec un ID unique

  Scenario: Annuler une réservation
    Given une réservation existe avec l'ID "12345"
    When j'annule la réservation avec l'ID "12345"
    Then la réservation est annulée

  Scenario: Consulter les détails d'une réservation
    Given une réservation existe avec l'ID "12345"
    When je consulte les détails de la réservation avec l'ID "12345"
    Then les détails de la réservation sont affichés
````

---

### **Configuration Maven**

Ajoutez les dépendances suivantes dans votre fichier `pom.xml`.


---

### **Step Definitions**

````java name=src/test/java/com/example/hotel/stepdefs/HotelStepDefinitions.java
package com.example.hotel.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HotelStepDefinitions {

    private List<String> availableRooms;
    private String reservationId;

    @Given("des chambres existent dans l'hôtel")
    public void desChambresExistentDansHotel() {
    }

    @When("je recherche des chambres disponibles entre {string} et {string}")
    public void jeRechercheDesChambresDisponibles(String dateDebut, String dateFin) {
    }

    @Then("les chambres disponibles sont affichées")
    public void lesChambresDisponiblesSontAffichees() {
    }

    @Given("une chambre est disponible")
    public void uneChambreEstDisponible() {
    }

    @When("je réserve la chambre avec les informations suivantes:")
    public void jeReserveLaChambreAvecLesInformations(List<List<String>> reservationDetails) {
    }

    @Then("la réservation est confirmée avec un ID unique")
    public void laReservationEstConfirmeeAvecUnIDUnique() {
    }

    @Given("une réservation existe avec l'ID {string}")
    public void uneReservationExisteAvecLID(String id) {
    }

    @When("j'annule la réservation avec l'ID {string}")
    public void jAnnuleLaReservationAvecLID(String id) {
    }

    @Then("la réservation est annulée")
    public void laReservationEstAnnulee() {
    }

    @When("je consulte les détails de la réservation avec l'ID {string}")
    public void jeConsulteLesDetailsDeLaReservationAvecLID(String id) {
    }

    @Then("les détails de la réservation sont affichés")
    public void lesDetailsDeLaReservationSontAffiches() {
    }
}
````

---

### **Étape 6 : Implémentation du Code**

Laissez les étudiants écrire les classes `Controller`, `Service` et `Repository` pour implémenter les fonctionnalités décrites dans les scénarios Gherkin.

---

### **Livrables**
1. Le fichier `hotel_reservations.feature`.
2. Les classes `Controller`, `Service`, `Repository` bien implémentées.
3. Les fichiers de tests avec Cucumber.
4. Le rapport d'exécution des tests montrant que tous les scénarios passent.

