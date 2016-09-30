CREATE TABLE MEDICINE (
  ID                  BIGSERIAL      NOT NULL,
  VERSION             INTEGER                 DEFAULT 0,
  NAME                VARCHAR(100)   NOT NULL,
  CATEGORY            VARCHAR(50)    NOT NULL DEFAULT 'GENERAL',
  DESCRIPTION         VARCHAR(255)   NOT NULL,
  PRICE               NUMERIC(10, 2) NOT NULL,
  PRICE_CURRENCY      VARCHAR(3)     NOT NULL DEFAULT 'PLN',
  IMAGE_DISK_LOCATION VARCHAR(50)    NOT NULL DEFAULT 'img//no-image.png',
  QUANTITY              INTEGER,

  PRIMARY KEY (ID)
)