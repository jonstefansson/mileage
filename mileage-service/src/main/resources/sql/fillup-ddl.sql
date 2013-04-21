create table fillup (
	id bigint generated by default as identity,
	date timestamp,
	mileage integer not null check (mileage>=1 AND mileage<=500000),
	quantity decimal(19,2) not null,
	vehicle varchar(255),
	primary key (id),
	unique (mileage, vehicle)
);
