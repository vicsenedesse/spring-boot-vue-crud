# spring-boot-vue-crud

Obs: Backend não está linkando com banco Mysql, está sendo utilizado json-server como backend falso.

Comandos necessários

**Diretório Backend**

    sudo apt-get install mvn

    mvn clean install
    
**Diretório Frontend**

    npm install
    
    npm i -g json-server
    
    json-server --watch db.json
  
    npm run server


**Diretório Principal**
#### irá rodar o backend + banco Mysql + phpMyAdmin
#### banco já está subindo populado

    docker-compose up
    
