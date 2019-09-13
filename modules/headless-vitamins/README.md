# Headless API

This directory holds the modules created by the REST Builder tool.

The headless-vitamins-impl is the important module. It contains the two yaml files used for code generation and knows how to add
the REST Builder plugin to the build.gradle file.

It is also where your implementation code will go.

There is an additional module, the headless-vitamins-cli module which provides a rather simplistic command line tool I used
to test the headless APIs, using the headless-vitamins-client module, but without requiring a full-blown web component.

When it comes time to deploy modules, only the headless-vitamins-api and headless-vitamins-impl modules would be deployed to
your environment.
