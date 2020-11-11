create table ogp_UserPersonalData (
	userId LONG not null primary key,
	companyId LONG,
	identificationId VARCHAR(75) null,
	lawerId VARCHAR(75) null,
	solicitorId VARCHAR(75) null,
	notaryId VARCHAR(75) null,
	passportId VARCHAR(75) null,
	nationality VARCHAR(75) null,
	authenticationType VARCHAR(75) null,
	agreeFullName VARCHAR(75) null,
	agreePortalUseData VARCHAR(75) null,
	agreeEmail VARCHAR(75) null
);