create index IX_7774ED78 on NEB_PersistedVitamin (name[$COLUMN_LENGTH:150$]);
create index IX_F51061AA on NEB_PersistedVitamin (surrogateId[$COLUMN_LENGTH:75$]);
create index IX_5401522D on NEB_PersistedVitamin (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C227FEF on NEB_PersistedVitamin (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_7AD52392 on NEB_VitaminDetail (persistedVitaminId, type_);
create index IX_E0A93FA9 on NEB_VitaminDetail (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_839F9C6B on NEB_VitaminDetail (uuid_[$COLUMN_LENGTH:75$], groupId);