# Service Builder Tier

This is the implementation of the Service Builder persistence tier for the vitamins example.

The PersistedVitamin is the main entity, and VitaminDetail will hold one or more child records.

The PersistedVitamin entity is indexed and also uses resource permissions.

There's a remote service layer that will be used by the Headless API to manage direct access to the entity space.
