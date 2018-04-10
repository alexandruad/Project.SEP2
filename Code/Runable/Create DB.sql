DROP SCHEMA IF EXISTS evidence_room CASCADE;
CREATE SCHEMA evidence_room;
set search_path = evidence_room;

CREATE TABLE items
(
   casenumber_1           integer NOT NULL,
   casenumber_2           integer NOT NULL,
   casenumber_3           integer NOT NULL,
   casenumber_4           integer NOT NULL,
   offencelocation        CHARACTER VARYING NOT NULL,
   number                 integer NOT NULL,
   offencetype            CHARACTER VARYING NOT NULL,
   evidencedescription    CHARACTER VARYING NOT NULL,
   evidencetype           CHARACTER VARYING NOT NULL,
   victim                 CHARACTER VARYING NOT NULL,
   suspect                CHARACTER VARYING NOT NULL,
   reasonsiezed           CHARACTER VARYING NOT NULL,
   dateofrecovery         date NOT NULL,
   recoveredby            CHARACTER VARYING NOT NULL,
   locationofrecoverry    CHARACTER VARYING NOT NULL,
   transportedby          CHARACTER VARYING NOT NULL,
   temporarylocation      CHARACTER VARYING NOT NULL,
   evidenceroomlocation   CHARACTER VARYING NOT NULL,
   casestatus             boolean NOT NULL,
   caseofficer            CHARACTER VARYING NOT NULL,
   disposition            CHARACTER VARYING NOT NULL,
   dateofdisposition      date NOT NULL,
   id 			  integer NOT NULL
)
;