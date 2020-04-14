FROM jboss/wildfly:latest

ENV WILDFLY_USER admin
ENV WILDFLY_PASS admin

ENV DB_NAME secret-pal
ENV DB_USER pal
ENV DB_PASS secret

ENV POSTGRES_VERSION 42.2.10
ENV JBOSS_CLI /opt/jboss/wildfly/bin/jboss-cli.sh
ENV DEPLOYMENT_DIR /opt/jboss/wildfly/standalone/deployments/

RUN echo "=> Adding WildFly administrator"
RUN $JBOSS_HOME/bin/add-user.sh -u $WILDFLY_USER -p $WILDFLY_PASS --silent

RUN echo "=> Starting WildFly server" && \
      bash -c '$JBOSS_HOME/bin/standalone.sh &' && \
    echo "=> Waiting for the server to boot" && \
      bash -c 'until `$JBOSS_CLI -c ":read-attribute(name=server-state)" 2> /dev/null | grep -q running`; do echo `$JBOSS_CLI -c ":read-attribute(name=server-state)" 2> /dev/null`; sleep 1; done' && \
    echo "=> Downloading Postgres driver" && \
      curl --location --output /tmp/postgresql-${POSTGRES_VERSION}.jar --url https://jdbc.postgresql.org/download/postgresql-${POSTGRES_VERSION}.jar && \
    echo "=> Adding Postgres module" && \
      $JBOSS_CLI --connect --command="module add --name=org.postgresql --resources=/tmp/postgresql-${POSTGRES_VERSION}.jar --dependencies=javax.api,javax.transaction.api" && \
    echo "=> Adding Postgres driver" && \
      $JBOSS_CLI --connect --command="/subsystem=datasources/jdbc-driver=postgres:add(driver-name=postgres,driver-module-name=org.postgresql,driver-class-name=org.postgresql.Driver)" && \
    echo "=> Creating a new datasource" && \
      $JBOSS_CLI --connect --command="data-source add --jndi-name=java:jboss/datasources/${DB_NAME} --name=${DB_NAME}DS --connection-url=jdbc:postgresql://db:5432/${DB_NAME} --driver-name=postgres --user-name=${DB_USER} --password=${DB_PASS}" && \
    echo "=> Shutting down WildFly and Cleaning up" && \
      $JBOSS_CLI --connect --command=":shutdown" && \
      rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history/ $JBOSS_HOME/standalone/log/* && \
      rm -f /tmp/*.jar

ADD build/libs/secret-pal-service-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

EXPOSE 8080 9990

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
