#!/usr/bin/env bash

vehicle=${1:?"vehicle is required"}

if [ ! -f "fillup-${vehicle}.json" ]; then
	echo "fillup-${vehicle}.json not found"
	exit 1
fi

curl \
-v \
-X POST \
--header "Content-Type: application/json" \
--header "Accept: application/json" \
--data-binary "@fillup-${vehicle}.json" \
--write-out "%{http_code}" \
--url "http://localhost:8080/fillup"
