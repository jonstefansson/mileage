#!/usr/bin/env bash

curl \
-v \
-X POST \
--header "Content-Type: application/json" \
--header "Accept: application/json" \
--data-binary @fillup.json \
--write-out "%{http_code}" \
--url "http://localhost:8080/fillup"
