CREATE TABLE ofxData(
    id bigserial not null,
    ofxData VARCHAR not null
);
ALTER TABLE ofxData ADD CONSTRAINT ofxData_pk PRIMARY KEY (id);