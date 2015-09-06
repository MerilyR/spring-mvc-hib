CREATE TABLE teammembers (
	ID int not null auto_increment,
	TEAM_ID int not null,
	MEMBER_ID int not null,
	PRIMARY KEY (`ID`)
)