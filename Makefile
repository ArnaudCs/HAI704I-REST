all: compile


compile:
	echo "[BASH] Compiling projects"
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
	echo "[BASH] Compilation done"

max:
	echo "[BASH] Starting 6 hotels"
	(cd HotelRest ; mvn spring-boot:run&)
	(cd RitzHotel ; mvn spring-boot:run&)
	(cd Formule1 ; mvn spring-boot:run&)
	(cd IbisWilson ; mvn spring-boot:run&)
	(cd Kyriad ; mvn spring-boot:run&)
	(cd FormuleMtp ; mvn spring-boot:run&)
	echo "[BASH] Starting 3 agencies"
	(cd AgencyRest ; mvn spring-boot:run&)
	(cd TripFinder ; mvn spring-boot:run&)
	(cd HotelScanner ; mvn spring-boot:run&)

min:
	echo "[BASH] Starting 4 hotels"
	(cd HotelRest ; mvn spring-boot:run&)
	(cd RitzHotel ; mvn spring-boot:run&)
	(cd Formule1 ; mvn spring-boot:run&)
	(cd IbisWilson ; mvn spring-boot:run&)
	echo "[BASH] Starting 3 agencies"
	(cd AgencyRest ; mvn spring-boot:run&)
	(cd TripFinder ; mvn spring-boot:run&)
	(cd HotelScanner ; mvn spring-boot:run&)

comparator:
	(cd Comparator ; mvn spring-boot:run)

clean:
	(pkill -9 -f AgencyRest&)
	(pkill -9 -f HotelRest&)
	(pkill -9 -f RitzHotel&)
	(pkill -9 -f Formule1&)
	(pkill -9 -f IbisWilson&)
	(pkill -9 -f TripFinder&)
	(pkill -9 -f HotelScanner&)
	(pkill -9 -f Comparator&)
	(pkill -9 -f Kyriad&)
	(pkill -9 -f FormuleMtp&)
	(cd AgencyRest ; mvn clean)
	(cd HotelRest ; mvn clean)
	(cd RitzHotel ; mvn clean)
	(cd Formule1 ; mvn clean)
	(cd IbisWilson ; mvn clean)
	(cd TripFinder ; mvn clean)
	(cd HotelScanner ; mvn clean)
	(cd Comparator ; mvn clean)
	(cd Kyriad ; mvn clean)
	(cd FormuleMtp ; mvn clean)
