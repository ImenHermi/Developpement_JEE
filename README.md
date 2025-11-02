# 🩺 Mini Projet Spring Boot - Gestion de Rendez-vous Médicaux

##  Contexte du projet
Ce mini-projet a pour objectif de développer une application **Spring Boot** permettant de gérer les rendez-vous médicaux entre **patients** et **médecins**, avec gestion des **spécialités**.

L’application permet d’effectuer des opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) sur les entités principales.


##  Entités principales

###  Patient
| Champ | Type | Description |

| `id` | Long | Identifiant unique |

| `nom` | String | Nom du patient |

| `email` | String | Adresse email du patient |


###  Médecin
| Champ | Type | Description |

| `id` | Long | Identifiant unique |

| `nom` | String | Nom du médecin |

| `email` | String | Adresse email du médecin |

| `specialite` | Specialite | Spécialité du médecin |


###  Spécialité
| Champ | Type | Description |

| `id` | Long | Identifiant unique |

| `nom` | String | Nom de la spécialité |

| `description` | String | Détails sur la spécialité |

###  RendezVous
| Champ | Type | Description |

| `id` | Long | Identifiant unique |

| `date` | LocalDateTime | Date et heure du rendez-vous |

| `statut` | String | Statut du rendez-vous (`prévu`, `confirmé`, `annulé`, `terminé`) |

| `patient` | Patient | Patient concerné |

| `medecin` | Medecin | Médecin concerné |

---

##  Endpoints principaux (API REST)

###  Patients
| Méthode | Endpoint | Description |

| `POST` | `/api/patients` | Ajouter un patient |

| `GET` | `/api/patients` | Lister tous les patients |

| `GET` | `/api/patients/{id}` | Récupérer un patient par ID |

| `PUT` | `/api/patients/{id}` | Modifier un patient |

| `DELETE` | `/api/patients/{id}` | Supprimer un patient |

###  Médecins
| Méthode | Endpoint | Description |

| `POST` | `/api/medecins` | Ajouter un médecin |

| `GET` | `/api/medecins` | Lister tous les médecins |

| `PUT` | `/api/medecins/{id}` | Modifier un médecin |

| `DELETE` | `/api/medecins/{id}` | Supprimer un médecin |

| `GET` | `/api/medecins/{id}` | Récupérer un medecin par ID |

###  Spécialités
| Méthode | Endpoint | Description |

| `POST` | `/api/specialites` | Ajouter une spécialité |

| `GET` | `/api/specialites` | Lister toutes les spécialités |

| `DELETE` | `/api/specialites/{id}` | Supprimer une specialite |

| `PUT` | `/api/specialites/{id}` | Modifier une specialite |

| `GET` | `/api/specialites/{id}` | Récupérer une specialite par ID |

###  RendezVous
| Méthode | Endpoint | Description |

| `POST` | `/api/rendezvous` | Créer un rendez-vous |

| `GET` | `/api/rendezvous` | Lister tous les rendez-vous |

| `PUT` | `/api/rendezvous/{id}` | Mettre à jour un rendez-vous |

| `DELETE` | `/api/rendezvous/{id}` | Supprimer un rendez-vous |

| `GET` | `/api/rendezvous/{id}` | Récupérer un rendezvous par ID |

---

##  Instructions d’exécution

### 🔸 Prérequis
- Java 17
- Maven
- Spring Boot 3.2.5
- Postman 
  *Git 

### 🔸 Étapes pour exécuter le projet

1. Cloner le projet depuis GitHub
   ```bash
   git clone https://github.com/ImenHermi/Developpement_JEE.git
