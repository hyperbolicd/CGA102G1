# CGA102G1

## Demo

**video**  
https://www.youtube.com/watch?v=GsD2gFseBa0
  
**ppt**  
https://drive.google.com/file/d/1Hlra9Pbw-wq_sjWKOs8l-BHvFnXWh-uq/view  

## Env
Java 8 + Tomcat 9.0 + Windows + Eclipse EE

## How to Run
1. Clone source code and open project in Eclipse EE IDE.
2. Export WAR to project root directory after setting Runtime Environments (Window -> Preferences -> Server -> Runtime Environments)
3. Deploy on local Tomcat or Docker.
* **local Tomcat**  
Copy WAR file to your Tomcat's `webapps/` and update `context.xml` under `conf/`, you could refer to `tomcat-config` in this project.
* **Docker**  
Open terminal and cd to project root, you will see Dockerfile, compose.yaml, WAR file, sql and tomcat-config directory.
4. Run service
* **local Tomcat**  
Execute `bin/startup.sh` for start up and `bin/shutdown.sh` for shut down.
* **Docker**  
Run `docker compose up` for first time or `docker compose up -d --force-recreate --build web` if you export a new WAR file.
5. You can access the application at http://localhost:8081/CGA102G1/frond_end/index.jsp for customer use and http://localhost:8081/CGA102G1/back_end/emp_index.jsp for manager use.  

### Test account  

|Role|act|psw|
|---|---|---|
|member|hireme123@gmail.com|aa123123|
|admin|1|123456|

## Other issues
1. The notify animation(keyframes) works on Windows server but but does not work when deployed on Docker. The main reason is unclear.