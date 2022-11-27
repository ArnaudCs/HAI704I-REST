all: compile

compile:
	(cd AgencyRest ; mvn compile )
	(cd HotelRest ; mvn compile)
	(cd RitzHotel ; mvn compile)

hotels:
	(cd HotelRest ; mvn spring-boot:run&)
	(cd RitzHotel ; mvn spring-boot:run&)

agency:
	(cd AgencyRest ; mvn spring-boot:run)

gui:
	(cd Client ; mvn exec:java@AgencyGUI)

clean:
	find ./HotelRest/target -mindepth 1 ! -regex '^./HotelRest/target/classes\(/.*\)?' -delete
	find ./HotelRest/target/classes -mindepth 1 ! -regex '^./HotelRest/target/classes/META-INF\(/.*\)?' -delete
	find ./RitzHotel/target -mindepth 1 ! -regex '^./RitzHotel/target/classes\(/.*\)?' -delete
	find ./RitzHotel/target/classes -mindepth 1 ! -regex '^./RitzHotel/target/classes/META-INF\(/.*\)?' -delete
	find ./AgencyRest/target -mindepth 1 ! -regex '^./AgencyRest/target/classes\(/.*\)?' -delete
	find ./AgencyRest/target/classes -mindepth 1 ! -regex '^./AgencyRest/target/classes/META-INF\(/.*\)?' -delete
