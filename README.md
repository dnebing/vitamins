# vitamins

This is the repo for a custom vitamins headless api built using Liferay's REST Builder.

There's a four part blog series that accompanies this repository:

* https://liferay.dev/blogs/-/blogs/creating-headless-apis-part-1 - Introduces the project and starts the headless-vitamins api.

* https://liferay.dev/blogs/-/blogs/creating-headless-apis-part-2 - Continues the API definition by adding all of the REST endpoints.

* https://liferay.dev/blogs/-/blogs/creating-headless-apis-part-3 - Reviews the generated code from REST Builder.

* https://liferay.dev/blogs/-/blogs/creating-headless-apis-part-4 - Adds the Vitamins Service Builder persistence layer, reviews the implementations of each of the headless methods and wraps up the project.

This repository has two basic areas:

1. modules/vitamins - Contains the vitamins-api and vitamins-service modules which form the basis of the Service Builder persistence layer.

2. modules/headless-vitamins - Contains the headless-vitamins-api and headless-vitamins-impl for the headless API, but also a client library, an integration test module as well as a CLI used to test the services.

