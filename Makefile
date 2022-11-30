all: compile

compile:
	(cd AgencyRest ; mvn compile)
	(cd HotelRest ; mvn compile)
	(cd RitzHotel ; mvn compile)
	(cd Formule1 ; mvn compile)
	(cd IbisWilson ; mvn compile)
	(cd TripFinder ; mvn compile)
	(cd HotelScanner ; mvn compile)
	(cd Comparator ; mvn compile)
	(cd Kyriad ; mvn compile)
	(cd FormuleMtp ; mvn compile)

hotels:
	(cd HotelRest ; mvn spring-boot:run&)
	(cd RitzHotel ; mvn spring-boot:run&)
	(cd Formule1 ; mvn spring-boot:run&)
	(cd IbisWilson ; mvn spring-boot:run&)
	(cd Kyriad ; mvn spring-boot:run&)
	(cd FormuleMtp ; mvn spring-boot:run&)

agencies:
	(cd AgencyRest ; mvn spring-boot:run)
	(cd TripFinder ; mvn spring-boot:run&)
	(cd HotelScanner ; mvn spring-boot:run&)

comparator:
	(cd Comparator ; mvn spring-boot:run&)

gui:
	(cd Client ; mvn exec:java@AgencyGUI)

clean:
	find ./HotelRest/target -mindepth 1 ! -regex '^./HotelRest/target/classes\(/.*\)?' -delete
	find ./HotelRest/target/classes -mindepth 1 ! -regex '^./HotelRest/target/classes/META-INF\(/.*\)?' -delete
	find ./RitzHotel/target -mindepth 1 ! -regex '^./RitzHotel/target/classes\(/.*\)?' -delete
	find ./RitzHotel/target/classes -mindepth 1 ! -regex '^./RitzHotel/target/classes/META-INF\(/.*\)?' -delete
	find ./AgencyRest/target -mindepth 1 ! -regex '^./AgencyRest/target/classes\(/.*\)?' -delete
	find ./AgencyRest/target/classes -mindepth 1 ! -regex '^./AgencyRest/target/classes/META-INF\(/.*\)?' -delete
