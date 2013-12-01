#!/usr/bin/env bash

# vehicle=${0:?"vehicle code is required"}
# SCOOTER, VSTAR, ACURA
vehicle=${1:?"vehicle is required"}

curl \
-v \
--get \
--header "Accept: application/json" \
--data-urlencode "limit=10" \
--url "http://localhost:8080/fillup/vehicle/${vehicle}" | python -mjson.tool
