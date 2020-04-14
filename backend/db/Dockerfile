FROM postgres

ENV POSTGRES_DB secret-pal
ENV POSTGRES_USER pal
ENV POSTGRES_PASSWORD secret
            
ADD scripts/ /docker-entrypoint-initdb.d   
