## one-record-hackathon2023-onecsd

# ONeCSD

For more background information, see devpost https://devpost.com/software/onecsd

This project has been created during 
_IATA ONE Record Hackathon – hosted by Qatar Airways Cargo, 24-26 November 2023_, see https://onerecord-doh.devpost.com/

## Toolbox
This project uses public available tools / libraries, mainly

* NE:ONE server https://openlogisticsfoundation.org/project/neone/
* https://wicket.apache.org/ for the webserver
* https://pdfbox.apache.org/ to build a PDF

# Developer Info

## How to run ONeCSD from scratch
Make sure the `repository` is checked out and everything starts from that directory. You also need a JDK.

### Local webserver startup from project commandline from scratch

Execute the following commandline after checkout of the git project:

    ./gradlew clean bootRun

then check http://localhost:8023 for generated demo data.

During the Hackathon event, opening http://localhost:8023 was loading the AWB data for 157-111111 from the available ONE Record AWS deployed server.
For the general use with a URL providing the key to the relevant, see 'Format of QR codes' below.


### Docker Deployment
Build project (spring)bootJar, then build docker-image and tag it as my/wicketspringboottemplate:

    # building file ONeCSD*.jar in directory build/libs:
    ./gradlew clean bootJar;
    # building docker file 
    docker build --build-arg JAR_FILE=build/libs/\*.jar -t my/wicketspringboottemplate .

Optional: Changes in Dockerfile or programming can be updates into docker via

    docker build -t my/wicketspringboottemplate .

To run it, execute

    docker run -p 8888:8023 my/wicketspringboottemplate 

then check http://localhost:8888/


## Format of QR codes

The ONeCSD webserver is designed to run in combination with a ONE Record server of a forwarder.
The current ONeCSD implementation as a Hackathon project was running against a provided AWS NE:ONE server,
the current code has no support to configure the URL of the connected ONE Record server.

Nevertheless, once the ONeCSD webserver is deployed, forwarder should add
QR code with a link to the ONeCSD webserver to be used by the screening provider.

The URL for the QR have the following format:

    https://fqdn:port/?loid=<LogisticObject_id_of_the_shipment>

with 
* `fqdn` being the full qualified domain name of the server,
* `port` being the port where the server is running (default server.port is 8023)
* LogisticObject_id_of_the_shipment being the ID of the shipment which refers to the AWB. 

During the Hackathon, the webservice was loading with loid = e9e5990a-aad9-4f19-a696-d9bd6824c195 as a default if no ID was provided.

The ONeCSD webserver loads the shipment data for the AWB number from the ONE Record server
and updates the Screening Result for the given AWB in the ONE Record server once user confirms it.


### Thank you
Made without crunch by people who care about their forwarders at a software company that cares about its people.

Thanks,


        _                _ _
	   / \   _ __  _ __ (_) | ____ _
	  / _ \ | '_ \| '_ \| | |/ / _` |
	 / ___ \| | | | | | | |   < (_| |
	/_/   \_\_| |_|_| |_|_|_|\_\__,_|
	
	 _____            _
	| ____|_ __  _ __(_) ___ ___
	|  _| | '_ \| '__| |/ __/ _ \
	| |___| | | | |  | | (_| (_) |
	|_____|_| |_|_|  |_|\___\___/
	
	 _  __          _
	| |/ /_____   _(_)_ __
	| ' // _ \ \ / / | '_ \
	| . \  __/\ V /| | | | |
	|_|\_\___| \_/ |_|_| |_|
	
	 __  __            _   _
	|  \/  | __ _ _ __| |_(_)_ __
	| |\/| |/ _` | '__| __| | '_ \
	| |  | | (_| | |  | |_| | | | |
	|_|  |_|\__,_|_|   \__|_|_| |_|
