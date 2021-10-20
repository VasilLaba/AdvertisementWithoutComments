CREATE TABLE author
(
    id SERIAL PRIMARY KEY,
    first_name CHARACTER VARYING(40) NOT NULL,
    last_name CHARACTER VARYING(40) NOT NULL,
    user_password CHARACTER VARYING(400) NOT NULL,
    created_date DATE NOT NULL
);
CREATE TABLE category
(
    id SERIAL PRIMARY KEY,
    name CHARACTER VARYING(60) NOT NULL,
    description CHARACTER VARYING(250) NOT NULL,
    created_at DATE NOT NULL
);
CREATE TABLE advertisement
(
    id SERIAL PRIMARY KEY,
    title CHARACTER VARYING(60) NOT NULL,
    description CHARACTER VARYING(2000) NOT NULL,
    category_id INTEGER NOT NULL,
    author_id INTEGER NOT NULL,
    created_date DATE NOT NULL,
    FOREIGN KEY (author_id) REFERENCES author (id),
    FOREIGN KEY (category_id) REFERENCES category (id)
);