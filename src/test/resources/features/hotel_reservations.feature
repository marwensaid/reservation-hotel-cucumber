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