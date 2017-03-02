###Below are the instructions for setting hotel-deals-finder site up in a local sandbox. 


##Prerequisites

* Git
* Maven
* JDK 1.8
* Heroku


##Instructions

1- Clone _hotel-deals-finder_ repository by executing:
	git clone https://github.com/zaidaquel/hotel-deal-finder

2- Build the project war by executing:
	mvn clean install
	
3- Deploy the application locally by executing:
	heroku local web -f Procfile.local
	
4- Open http://localhost and start using the application.
