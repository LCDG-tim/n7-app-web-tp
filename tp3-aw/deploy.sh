source comp.sh annuaire-jpa
apachepath=~/ws/apache-tomcat-11.0.1/webapps
cp annuaire-jpa.war $apachepath/.
cd facade
./mvnw package
cd -
cp facade/target/facade-0.0.1-SNAPSHOT.war $apachepath/facade.war

