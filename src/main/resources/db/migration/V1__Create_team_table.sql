CREATE TABLE teams (
	ID int not null auto_increment,
	NAME varchar(100) not null,
	RATING int not null,
	ORGANIZATION_ID int,
	PRIMARY KEY (`ID`)
);