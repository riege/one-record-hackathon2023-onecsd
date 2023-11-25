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

The ONeCSD webserver is designed to run linked directly with a ONE Record server of a forwarder.
The current ONeCSD implementation as a Hackathon project was running against a provided AWS NE:ONE server,
the current code has no support to configure the URL of the connected ONE Record server.

Nevertheless, once the ONeCSD webserver is deployed, forwarder should add
QR code with a link to the ONeCSD webserver to be used by the screening provider.

The URL for the QR have the following format:

    https://fqdn:port/?w=123-12345678

with 
* `fqdn` being the full qualified domain name of the server,
* `port` being the port where the server is running (default server.port is 8023)
* `123-12345678` being the AWB number of the IATA shipment, in format nnn-nnnnnnnn, here 123-12345678 as an example value.

The ONeCSD webserver loads the shipment data for the AWB number from the ONE Record server
and updates the Screening Result for the given AWB in the ONE Record server once user confirms it.
