while test 1
do
    echo actualisation
    date
    ./comp.sh Annuaire$1 && cp Annuaire$1.war ~/ws/apache-tomcat-11.0.1/webapps/
    sleep 300
done
