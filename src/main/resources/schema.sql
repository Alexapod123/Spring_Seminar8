create table if not exists "Person"(
    "id" INT AUTO_INCREMENT PRIMARY KEY,
    "name" VARCHAR(50) NOT NULL,
    "birthday" DATE NOT NULL,
    "married" VARCHAR(50) NOT NULL
);