-- DDL

CREATE TABLE plants (
	id INT IDENTITY NOT NULL,
	name VARCHAR(150) NOT NULL,
	description VARCHAR(250),
	PRIMARY KEY (id)
);

CREATE TABLE garden_plants (
	id INT IDENTITY NOT NULL,
	plant_id INT,
	health INT,
	art_proc_date DATE,
	planted_date DATE,
	removed_date DATE,
	removed BOOLEAN DEFAULT FALSE,
	description VARCHAR(250),
	PRIMARY KEY (id),
	FOREIGN KEY (plant_id) REFERENCES plants(id)
);

COMMIT;