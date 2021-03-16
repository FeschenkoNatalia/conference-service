CREATE TABLE conference_dates
(
    conference_id BIGINT NOT NULL,
    dates         DATE,
    CONSTRAINT FK_conference_dates_conference FOREIGN KEY (conference_id) REFERENCES conference
);

INSERT INTO conference_dates VALUES (1, now());