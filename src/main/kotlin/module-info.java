module crime.report {

    requires org.slf4j;

    requires java.sql;
    requires jakarta.persistence;
    requires jakarta.ws.rs;
    requires jakarta.xml.bind;

    requires kotlin.reflect;
    requires kotlin.stdlib;

    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.beans;
    requires spring.context;
    requires spring.core;
    requires spring.web;

    requires spring.data.commons;
    requires spring.data.jpa;

    requires org.hibernate.orm.core;

    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;

    opens me.samael.crimereport to
        kotlin.reflect,
        spring.core,
        spring.beans,
        spring.context,
        spring.web,
        com.fasterxml.jackson.databind;

    opens me.samael.crimereport.persistence to
        kotlin.reflect,
        spring.core,
        spring.data.commons,
        spring.data.jpa,
        org.hibernate.orm.core;
}
