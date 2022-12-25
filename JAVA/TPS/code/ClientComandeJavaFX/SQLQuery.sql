CREATE database gestionCommande
USE gestionCommande
CREATE TABLE clients (
    id int NOT NULL AUTO_INCREMENT,
    nom varchar(50) NOT NULL,
    prenom varchar(50) NOT NULL,
    age int NOT NULL,
    adresse varchar(50) NOT NULL,
    telephone varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE commandes (
    id int NOT NULL AUTO_INCREMENT,
	reference varchar(50) NOT NULL,
    dateCreation varchar(50) NOT NULL,
    prix double NOT NULL,
    idClient int NOT NULL,
    FOREIGN KEY (idClient) REFERENCES clients(id),
    PRIMARY KEY (id)
);
