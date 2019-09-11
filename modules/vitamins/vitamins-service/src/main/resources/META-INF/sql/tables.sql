create table NEB_PersistedVitamin (
	uuid_ VARCHAR(75) null,
	persistedVitaminId LONG not null primary key,
	surrogateId VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	groupName VARCHAR(150) null,
	articleId VARCHAR(75) null,
	description STRING null,
	name VARCHAR(150) null,
	type_ INTEGER
);

create table NEB_VitaminDetail (
	uuid_ VARCHAR(75) null,
	vitaminDetailId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	persistedVitaminId LONG,
	type_ INTEGER,
	value VARCHAR(2000) null
);