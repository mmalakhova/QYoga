CREATE TABLE questions
(
    id    BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title TEXT,
    question_type VARCHAR,
    questionnaire_id BIGINT NOT NULL REFERENCES questionnaires ON DELETE CASCADE,
    image_id BIGINT REFERENCES images ON DELETE SET NULL
)