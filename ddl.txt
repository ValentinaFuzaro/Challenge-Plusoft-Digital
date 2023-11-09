CREATE TABLE feedback (
    feedback_id BIGINT PRIMARY KEY,
    description_feedback VARCHAR(255),
    date_feedback DATE
);

CREATE TABLE usuario (
    id_usuario BIGINT PRIMARY KEY,
    name_user VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255),
    cellphone_user VARCHAR(20),
    company_user VARCHAR(255),
    date_user DATE
);

