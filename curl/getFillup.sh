#!/usr/bin/env bash

id="44"

curl \
-v \
--get \
--header "Accept: application/json" \
--url "http://localhost:8080/fillup/id/${id}" | python -mjson.tool
