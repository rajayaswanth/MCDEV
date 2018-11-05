/********************************************************/
/*	Sri Sathya Sai Alumni Medical Camp		*/
/*	Author: manojsr6@gmail.com			*/
/********************************************************/

/********************************************************/
/*	This file consists of the SQL queries to	*/
/*	create the database tables for SSSAMC.		*/
/********************************************************/

create table user_master_table
(
	user_id				INT unsigned NOT NULL auto_increment,
	name				VARCHAR(150) NOT NULL,
	email				VARCHAR(150) NOT NULL,
	mobile				VARCHAR(150) NOT NULL,
	password			VARCHAR(150) NOT NULL,
	role				INT unsigned NOT NULL,
	status				INT unsigned NOT NULL,
	validated			BOOLEAN NOT NULL,
	PRIMARY KEY(user_id)
);

create table medicine_master_table
(
	medicine_id			INT unsigned NOT NULL auto_increment,
	general_name		VARCHAR(150) NOT NULL,
	trade_name			VARCHAR(150) NOT NULL,
	composition			VARCHAR(150),
	manufacturer_name	VARCHAR(150) NOT NULL,
	medicine_strength	VARCHAR(50) NOT NULL,
	PRIMARY KEY(medicine_id)
);

create table department_master_table
(
	department_id		INT unsigned NOT NULL auto_increment,
	department_name		VARCHAR(150) NOT NULL,
	room_no				VARCHAR(150) NOT NULL,
	PRIMARY KEY(department_id)
);

create table batch_table
(
	batch_id			INT unsigned NOT NULL auto_increment,
	batch_number		VARCHAR(150) NOT NULL,
	medicine_id			INT unsigned NOT NULL,
	mfg_date			DATE NOT NULL,
	exp_date			DATE NOT NULL,
	PRIMARY KEY(batch_id),
	FOREIGN KEY(medicine_id) REFERENCES medicine_master_table (medicine_id)
);

create table patient_master_table
(
	patient_id			INT unsigned NOT NULL auto_increment,
	patient_name		VARCHAR(150) NOT NULL,
	address				VARCHAR(150) NOT NULL,
	mobile				VARCHAR(150) NOT NULL,
	phone_number		VARCHAR(150) NOT NULL,
	PRIMARY KEY(patient_id)
);

create table stock_table
(
	stock_id			INT unsigned NOT NULL auto_increment,
	medicine_id			INT unsigned NOT NULL,
	batch_id			INT unsigned NOT NULL,
	/* quantity: smallest pricable unit like strip/bottle */
	quantity			INT NOT NULL,
	/* How many dispensable unit do a pricable unit contain
	e.g. 10 tablets/strip */
	unit_factor			INT NOT NULL,
	invoice_number		VARCHAR(50) NOT NULL,
	price				FLOAT NOT NULL,
	stock_room			VARCHAR(6) NOT NULL,
	rack_number			VARCHAR(6) NOT NULL,
	PRIMARY KEY (stock_id),
	FOREIGN KEY (medicine_id) REFERENCES medicine_master_table (medicine_id),
	FOREIGN KEY (batch_id) REFERENCES batch_table (batch_id)
);

create table visit_table
(
	visit_id			INT unsigned NOT NULL auto_increment,
	patient_id			INT unsigned NOT NULL,
	visit_date			DATE NOT NULL,
	PRIMARY KEY (visit_id),
	FOREIGN KEY (patient_id) REFERENCES patient_master_table(patient_id)
);

create table prescription_table
(
	prescription_id		INT unsigned NOT NULL auto_increment,
	department_id		INT unsigned NOT NULL,
	visit_id			INT unsigned NOT NULL,
	PRIMARY KEY (prescription_id),
	FOREIGN KEY (department_id) REFERENCES department_master_table(department_id),
	FOREIGN KEY (visit_id) REFERENCES visit_table(visit_id)
);

create table medicine_dispense_table
(
	dispense_id			INT unsigned NOT NULL auto_increment,
	prescription_id		INT unsigned NOT NULL,
	stock_id			INT unsigned NOT NULL,
	/* Here quantity is in terms of dispensable units
	[as tablets/capsules and not strips]
	comparable to (quantity * unit_factor) of stock table */
	quantity			INT NOT NULL,
	PRIMARY KEY (dispense_id),
	FOREIGN KEY (prescription_id) REFERENCES prescription_table (prescription_id),
	FOREIGN KEY (stock_id) REFERENCES stock_table(stock_id)
);
