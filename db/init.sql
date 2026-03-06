CREATE TABLE app_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(200) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE origin_line (
                          id          BIGINT AUTO_INCREMENT PRIMARY KEY,
                          line_number INT NOT NULL
);

CREATE TABLE message (
                       id           BIGINT AUTO_INCREMENT PRIMARY KEY,
                       destination  INT          NOT NULL,
                       message_type VARCHAR(50) NOT NULL,
                       content      TEXT         NOT NULL,
                       origin_id    BIGINT       NOT NULL,
    CONSTRAINT fk_message_origin FOREIGN KEY (origin_id) REFERENCES origin_line(id)
    );

INSERT INTO app_user (id, username, password, role)
VALUES (1, '123456', '$2a$12$tDg6bg1MP2k6KyWxqRmWT.4Q3ApzZImUvmmfrtY34O2hBdt2MrSzq', 'ADMIN');

INSERT INTO origin_line (line_number) VALUES
                           (1001),
                           (1002),
                           (1003),
                           (1004),
                           (1005);

INSERT INTO message (destination, message_type, content, origin_id) VALUES
                        (2001, 'TEXTO',     'Hola, este es un mensaje de texto',          1),
                        (2002, 'IMAGEN',    'https://example.com/imagen.jpg',             2),
                        (2003, 'VIDEO',     'https://example.com/video.mp4',              3),
                        (2004, 'DOCUMENTO', 'https://example.com/documento.pdf',          4),
                        (2005, 'TEXTO',     'Otro mensaje de texto de prueba',            5);