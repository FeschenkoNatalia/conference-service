CREATE TABLE talk
(
    id            BIGINT generated by default as identity,
    conference_id BIGINT,
    name          VARCHAR(255),
    description   VARCHAR(255),
    speaker       VARCHAR(255),
    type          VARCHAR(255) NOT NULL,
    CONSTRAINT PK_talk PRIMARY KEY (id),
    CONSTRAINT FK_talk_conference FOREIGN KEY (conference_id) REFERENCES conference
);

INSERT INTO talk VALUES (1, 1, 'talk1', 'description1', 'speaker1', 'WORKSHOP');