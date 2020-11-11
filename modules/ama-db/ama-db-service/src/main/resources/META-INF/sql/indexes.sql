create index IX_BF7E007F on ogp_UserPersonalData (identificationId[$COLUMN_LENGTH:75$]);
create index IX_B8CB2018 on ogp_UserPersonalData (lawerId[$COLUMN_LENGTH:75$]);
create index IX_5C466146 on ogp_UserPersonalData (notaryId[$COLUMN_LENGTH:75$]);
create index IX_EAA9FCA9 on ogp_UserPersonalData (passportId[$COLUMN_LENGTH:75$], nationality[$COLUMN_LENGTH:75$]);
create index IX_914F65C1 on ogp_UserPersonalData (solicitorId[$COLUMN_LENGTH:75$]);
create index IX_BA9B605C on ogp_UserPersonalData (userId);